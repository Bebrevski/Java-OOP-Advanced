package task10_InfernoInfinity.weapons;

import task10_InfernoInfinity.Weapon;

public class Axe extends Weapon {
    public Axe(String name, String type) {
        super(name, type);
    }

    @Override
    public String toString() {

        super.upgradeWeapon();

        return String.format("%s%d-%d Damage, +%d Strength, +%d Agility, +%d Vitality"
                , super.toString()
                , super.getStats().getMinDamage()
                , super.getStats().getMaxDamage()
                , super.getSumStrength()
                , super.getSumAgility()
                , super.getSumVitality());
    }
}
