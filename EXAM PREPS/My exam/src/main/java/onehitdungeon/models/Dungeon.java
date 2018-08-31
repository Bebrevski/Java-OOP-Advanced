package onehitdungeon.models;

import onehitdungeon.interfaces.IDungeon;

public class Dungeon implements IDungeon {

    private Integer dungeonLevel;
    private Integer battlePower;
    private Double gold;

    public Dungeon() {
        this.dungeonLevel = 1;
        this.battlePower = 20;
        this.gold = 15D;
    }

    @Override
    public Integer getDungeonLevel() {
        return this.dungeonLevel;
    }

    @Override
    public Integer getBattlePower() {
        return this.battlePower;
    }

    @Override
    public Double getGold() {
        return this.gold;
    }

    @Override
    public void updateDungeon() {
        this.dungeonLevel++;
        this.battlePower *= 2;
        this.gold *= 2;
    }

    @Override
    public void decreaseDungeonLevel(){
        this.dungeonLevel--;
        this.battlePower /= 2;
        this.gold /= 2;
    }
}
