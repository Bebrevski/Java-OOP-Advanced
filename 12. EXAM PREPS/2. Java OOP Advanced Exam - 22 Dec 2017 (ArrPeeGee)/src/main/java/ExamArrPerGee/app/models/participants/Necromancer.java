package ExamArrPerGee.app.models.participants;

import ExamArrPerGee.app.constants.Config;
import ExamArrPerGee.app.contracts.Targetable;

public class Necromancer extends AbstractHero {

    public Necromancer() {
        super(Config.NECROMANCER_BASE_STRENGTH, Config.NECROMANCER_BASE_DEXTERITY, Config.NECROMANCER_BASE_INTELLIGENCE);
    }

    public Necromancer(String name) {
        this();
        this.setName(name);
    }

    @Override
    public double getDamage() {
        return this.getIntelligence() * Config.NECROMANCER_DAMAGE_MULTIPLIER +
                this.getDexterity() * Config.NECROMANCER_DAMAGE_MULTIPLIER +
                this.getStrength() * Config.NECROMANCER_DAMAGE_MULTIPLIER;
    }

    @Override
    public String attack(Targetable target) {
        String result = super.attack(target);
        super.activateSpeciality();
        return result;
    }
}
