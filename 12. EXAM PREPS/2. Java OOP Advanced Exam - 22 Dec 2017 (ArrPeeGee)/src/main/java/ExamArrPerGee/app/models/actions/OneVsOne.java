package ExamArrPerGee.app.models.actions;

import ExamArrPerGee.app.constants.Texts;
import ExamArrPerGee.app.contracts.Action;
import ExamArrPerGee.app.contracts.Targetable;
import ExamArrPerGee.app.factory.BaseStructureFactory;

import java.util.List;

public class OneVsOne implements Action {

    public String executeAction(List<Targetable> participants) {

        if (participants.size() != 2) {
            return Texts.INVALID_PARTICIPANTS_FOR_ONE_VS_ONE;
        }

        StringBuilder sb = BaseStructureFactory.createStringBuilder();

        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        while (firstHero.isAlive()) {
            sb.append(firstHero.attack(secondHero)).append(System.lineSeparator());
            if (secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero)).append(System.lineSeparator());
            } else {
                break;
            }
        }

        Targetable victor = firstHero.isAlive() ? firstHero : secondHero;
        victor.levelUp();
        sb.append(String.format(Texts.HERO_IS_VICTORIOUS, victor.getName(), victor));

        return sb.toString();
    }

}
