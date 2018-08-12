package ExamArrPerGee.app.models.actions;

import ExamArrPerGee.app.constants.Config;
import ExamArrPerGee.app.constants.Texts;
import ExamArrPerGee.app.contracts.Action;
import ExamArrPerGee.app.contracts.Targetable;
import ExamArrPerGee.app.factory.BaseStructureFactory;

import java.util.Comparator;
import java.util.List;

public class BossFight implements Action {

    @Override
    public String executeAction(List<Targetable> participants) {

        if (participants.size() < 2) {
            return Texts.INVALID_PARTICIPANTS_FOR_BOSS_FIGHT;
        }

        Targetable boss = participants.get(0);

        boolean heroesAlive = true;
        while (boss.isAlive() && heroesAlive) {
            heroesAlive = false;
            for (int i = 1; i < participants.size(); i++) {
                Targetable hero = participants.get(i);
                if (hero.isAlive()) {
                    hero.attack(boss);
                    if (boss.isAlive()) {
                        boss.attack(hero);
                        if (hero.isAlive()) {
                            heroesAlive = true;
                        }
                    }
                }
            }
        }

        StringBuilder sb = BaseStructureFactory.createStringBuilder();

        if (!boss.isAlive()) {
            sb.append(Texts.BOSS_HAS_BEEN_SLAIN).append(System.lineSeparator());
            participants.stream()
                    .skip(1)
                    .filter(Targetable::isAlive)
                    .sorted(Comparator.comparing(Targetable::getName))
                    .forEach(x -> {
                        x.levelUp();
                        x.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
                        sb.append(x).append(System.lineSeparator());
                    });
        } else {
            boss.levelUp();
            sb.append(Texts.BOSS_HAS_SLAIN_THEM_ALL);
        }

        return sb.toString().trim();
    }
}
