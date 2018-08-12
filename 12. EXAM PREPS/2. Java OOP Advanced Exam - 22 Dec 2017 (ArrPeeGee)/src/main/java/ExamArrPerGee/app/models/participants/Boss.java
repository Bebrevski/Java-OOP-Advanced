package ExamArrPerGee.app.models.participants;

import ExamArrPerGee.app.constants.Config;
import ExamArrPerGee.app.constants.Texts;
import ExamArrPerGee.app.factory.BaseStructureFactory;

public class Boss extends AbstractActor {

    public Boss() {
        super(Config.BOSS_GOLD);
        this.setHealth(Config.BOSS_HEALTH);
    }

    public Boss(String name) {
        this();
        this.setName(name);
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
    }

    @Override
    public void receiveReward(double reward) {
        this.addGold(reward * Config.BOSS_RECEIVE_REWARD_MODIFIER);
    }

    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public String toString() {
        final StringBuilder sb = BaseStructureFactory.createStringBuilder();
        sb.append(super.toString()).append(String.format(Texts.BOSS_STATS, this.getGold()));
        return sb.toString();
    }
}
