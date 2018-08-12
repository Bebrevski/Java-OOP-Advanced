package ExamArrPerGee.app.models.participants;

import ExamArrPerGee.app.constants.Config;
import ExamArrPerGee.app.constants.Texts;
import ExamArrPerGee.app.contracts.Specialty;
import ExamArrPerGee.app.contracts.SuperHero;
import ExamArrPerGee.app.factory.BaseStructureFactory;
import ExamArrPerGee.app.models.specialties.Toughness;

public abstract class AbstractHero extends AbstractActor implements SuperHero {

    private int strength;
    private int dexterity;
    private int intelligence;
    private Specialty specialty;
    private boolean healthBonusGiven;

    protected AbstractHero(int strength, int dexterity, int intelligence) {
        super(Config.HERO_START_GOLD);
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.setHealth(this.getMaxHealth());
        this.specialty = null;
        this.healthBonusGiven = false;
    }

    @Override
    public int getStrength() {
        return this.strength + this.getToughnessBonus();
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getDexterity() {
        return this.dexterity + this.getSwiftnessBonus();
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void receiveReward(double reward) {
        this.addGold(reward);
    }

    @Override
    public void levelUp() {
        if (this.specialty != null) {
            this.specialty.deactivate();
        }

        this.strength *= Config.LEVEL_UP_MULTIPLIER;
        this.dexterity *= Config.LEVEL_UP_MULTIPLIER;
        this.intelligence *= Config.LEVEL_UP_MULTIPLIER;
        this.healthBonusGiven = false;
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public String toString() {
        final StringBuilder sb = BaseStructureFactory.createStringBuilder();
        sb.append(super.toString()).append(String.format(Texts.HERO_STATS,
                this.getStrength(), this.getDexterity(), this.getIntelligence(), this.getGold()));
        return sb.toString();
    }

    @Override
    public int getToughnessBonus() {
        if (this.specialty != null && this.isUnderHalfHealth()) {
            return this.specialty.getToughnessBonus();
        }
        return 0;
    }

    @Override
    public int getHealBonus() {
        if (this.specialty != null && this.isUnderHalfHealth()) {
            return this.specialty.getHealBonus();
        }
        return 0;
    }

    @Override
    public int getSwiftnessBonus() {
        if (this.specialty != null && this.isAboveHalfHealth()) {
            return this.specialty.getSwiftnessBonus();
        }
        return 0;
    }

    @Override
    public void addSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    protected void activateSpeciality() {
        if (this.specialty != null) {
            this.specialty.activate(this.getIntelligence());

            if (!this.healthBonusGiven && this.specialty instanceof Toughness &&
                    (this.getMaxHealth() - this.getIntelligence() * Config.HERO_HEALTH_MULTIPLIER) * 0.5 <= this.getHealth()) {
                this.setHealth(this.getHealth() + this.getIntelligence() * Config.HERO_HEALTH_MULTIPLIER);
                this.healthBonusGiven = true;
            }

            this.setHealth(this.getHealth() + this.getHealBonus());
        }
    }

    private double getMaxHealth() {
        if (!this.healthBonusGiven) {
            return (long) this.strength * Config.HERO_HEALTH_MULTIPLIER;
        } else {
            return ((long) this.strength + this.getIntelligence()) * Config.HERO_HEALTH_MULTIPLIER;
        }
    }

    private boolean isUnderHalfHealth() {
        return this.getHealth() <= this.getMaxHealth() * 0.5;
    }

    private boolean isAboveHalfHealth() {
        return this.getHealth() >= this.getMaxHealth() * 0.5;
    }
}
