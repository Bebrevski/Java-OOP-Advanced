package task10_InfernoInfinity;

import task10_InfernoInfinity.enums.BaseStats;
import task10_InfernoInfinity.enums.Gems;

import java.util.HashMap;
import java.util.Map;

public abstract class Weapon {
    private String name;
    private BaseStats stats;
    private int minDamage;
    private int maxDamage;
    private Map<Integer, Gems> sockets;

    public Weapon(String name, String type) {
        this.name = name;
        this.stats = Enum.valueOf(BaseStats.class, type.toUpperCase());
        this.sockets = new HashMap<>(this.stats.getSockets());
    }

    public void insertGem(int index, String gemType) {
        if (index >= 0 && index <= this.stats.getSockets()) {
            this.sockets.put(index, Enum.valueOf(Gems.class, gemType.toUpperCase()));
        }
    }

    protected void upgradeWeapon() {
        this.minDamage = this.stats.getMinDamage();
        this.maxDamage = this.stats.getMaxDamage();

        this.minDamage += getSumStrength() * 2 + getSumAgility();
        this.maxDamage += getSumStrength() * 3 + getSumAgility() * 4;
    }

    public void removeGem(int index) {
        this.sockets.remove(index);
    }

    protected int getSumStrength() {
        int sum = 0;
        for (Gems gem : sockets.values()) {
            sum += gem.getStrength();
        }
        return sum;
    }

    protected int getSumAgility() {
        int sum = 0;
        for (Gems gem : sockets.values()) {
            sum += gem.getAgility();
        }
        return sum;
    }

    protected int getSumVitality() {
        int sum = 0;
        for (Gems gem : sockets.values()) {
            sum += gem.getVitality();
        }
        return sum;
    }

    @Override
    public String toString() {

        this.upgradeWeapon();

        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality"
                , this.name
                , this.minDamage
                , this.maxDamage
                , this.getSumStrength()
                , this.getSumAgility()
                , this.getSumVitality());
    }
}
