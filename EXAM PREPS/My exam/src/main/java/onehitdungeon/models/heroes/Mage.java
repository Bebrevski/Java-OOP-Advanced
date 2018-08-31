package onehitdungeon.models.heroes;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

public class Mage extends BaseHero {
    public Mage(String name, WeaponItem weapon, OffhandItem offhand, ArmorItem armorItem) {
        super(name, weapon, offhand, armorItem);
    }

    @Override
    public Integer getTotalBattlePower() {
        return ((super.getWeapon().getBattlePower() + super.getArmor().getBattlePower() - super.getOffhand().getBattlePower()) * 3) / 4;
    }
}
