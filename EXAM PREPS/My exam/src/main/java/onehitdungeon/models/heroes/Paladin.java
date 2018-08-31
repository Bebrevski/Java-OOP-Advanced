package onehitdungeon.models.heroes;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

public class Paladin extends BaseHero {
    public Paladin(String name, WeaponItem weapon, OffhandItem offhand, ArmorItem armorItem) {
        super(name, weapon, offhand, armorItem);
    }

    @Override
    public Integer getTotalBattlePower() {
        return (( super.getWeapon().getBattlePower() +
                super.getOffhand().getBattlePower() +
                super.getArmor().getBattlePower()) * 4) / 9;
    }
}
