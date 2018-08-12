package ExamArrPerGee.app.contracts;

public interface Targetable {

    String attack(Targetable target);

    void takeDamage(double damage);

    String getName();

    void setName(String name);

    double getDamage();

    double getHealth();

    void setHealth(double health);

    double getGold();

    void giveReward(Targetable targetable);

    void receiveReward(double reward);

    void levelUp();

    boolean isAlive();

}
