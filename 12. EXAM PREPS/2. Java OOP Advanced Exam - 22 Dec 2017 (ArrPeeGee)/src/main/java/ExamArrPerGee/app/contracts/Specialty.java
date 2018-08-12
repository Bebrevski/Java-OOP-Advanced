package ExamArrPerGee.app.contracts;

public interface Specialty extends SpecialtyBonuses {

    void activate(int bonus);

    void deactivate();
}
