package ExamArrPerGee.app.models.specialties;

import ExamArrPerGee.app.contracts.Specialty;

public abstract class AbstractSpecialty implements Specialty {

    private int bonus;

    protected int getBonus() {
        return this.bonus;
    }

    @Override
    public void activate(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void deactivate() {
        this.bonus = 0;
    }

    @Override
    public int getToughnessBonus() {
        return 0;
    }

    @Override
    public int getHealBonus() {
        return 0;
    }

    @Override
    public int getSwiftnessBonus() {
        return 0;
    }
}
