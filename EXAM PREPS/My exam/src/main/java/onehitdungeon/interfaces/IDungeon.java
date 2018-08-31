package onehitdungeon.interfaces;

public interface IDungeon {

    Integer getDungeonLevel();

    Integer getBattlePower();

    Double getGold();

    void updateDungeon();

    void decreaseDungeonLevel();
}
