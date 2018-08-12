package ExamArrPerGee.app.models.participants;

import ExamArrPerGee.app.constants.Texts;
import ExamArrPerGee.app.contracts.Targetable;
import ExamArrPerGee.app.factory.BaseStructureFactory;

public abstract class AbstractActor implements Targetable {

    private String name;
    private double health;
    private double gold;
    private boolean isAlive;

    protected AbstractActor(double gold) {
        this.gold = gold;
        this.isAlive = true;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    public void addGold(double gold) {
        this.gold += gold;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
    }

    @Override
    public String attack(Targetable target) {
        StringBuilder sb = BaseStructureFactory.createStringBuilder();

        if (!this.isAlive) {
            sb.append(String.format(Texts.DEAD_CANNOT_ATTACK, this.name));
        } else if (!target.isAlive()) {
            sb.append(String.format(Texts.DEAD_CANNOT_BE_ATTACKED, target.getName()));
        } else {
            sb.append(String.format(Texts.TARGETABLE_ATTACKS, this.name));
            target.takeDamage(this.getDamage());
            if (!target.isAlive()) {
                sb.append(String.format(Texts.TARGETABLE_HAS_BEEN_SLAIN, target.getName(), this.getName()));
                target.giveReward(this);
            } else {
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    @Override
    public void takeDamage(double damage) {
        this.health -= damage;
        if (this.health <= 0d) {
            this.isAlive = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = BaseStructureFactory.createStringBuilder();

        sb.append(String.format(Texts.TARGETABLE_NAME_AND_CLASS, this.getName(), this.getClass().getSimpleName()))
                .append(String.format(Texts.TARGETABLE_HEALTH_AND_DAMAGE, this.getHealth(), this.getDamage()));

        return sb.toString();
    }
}
