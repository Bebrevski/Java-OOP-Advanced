package onehitdungeon.models.items;

import onehitdungeon.interfaces.Item;

public abstract class BaseItem implements Item {
    private Integer battlePower;
    private Double priceForUpgrade;

    protected BaseItem(Integer battlePower, Double priceForUpgrade) {
        this.battlePower = battlePower;
        this.priceForUpgrade = priceForUpgrade;
    }

    @Override
    public Integer getBattlePower() {
        return this.battlePower;
    }

    @Override
    public Double getPriceForUpgrade() {
        return this.priceForUpgrade;
    }
}
