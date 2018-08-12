package ExamArrPerGee.app.models.participants;

import ExamArrPerGee.app.constants.Config;

public class Warrior extends AbstractHero {

    public Warrior() {
        super(Config.WARRIOR_BASE_STRENGTH, Config.WARRIOR_BASE_DEXTERITY, Config.WARRIOR_BASE_INTELLIGENCE);
    }

    public Warrior(String name) {
        this();
        this.setName(name);
    }

    @Override
    public double getDamage() {
        return (this.getStrength() * Config.WARRIOR_DAMAGE_MULTIPLIER) + this.getDexterity();
    }

    @Override
    public void takeDamage(double damage) {
        super.takeDamage(damage);
        super.activateSpeciality();
    }
}
