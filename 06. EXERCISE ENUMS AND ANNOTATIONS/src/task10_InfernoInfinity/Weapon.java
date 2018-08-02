package task10_InfernoInfinity;

import task10_InfernoInfinity.enums.BaseStats;
import task10_InfernoInfinity.enums.Gems;

import java.util.HashMap;
import java.util.Map;

public abstract class Weapon {
    private String name;
    private BaseStats stats;
    private Map<Integer, Gems> sockets;

    public Weapon(String name, String type) {
        this.name = name;
        this.stats = Enum.valueOf(BaseStats.class, type.toUpperCase());
        this.sockets = new HashMap<>(this.stats.getSockets());
    }

    public void insertGem(int index, String gemType) {
        if (index >= 0 && index <= sockets.size()) {
            this.sockets.put(index, Enum.valueOf(Gems.class, gemType.toUpperCase()));
        }
    }

    protected void upgradeWeapon() {
        for (Gems gem : sockets.values()) {
            this.stats.setMinDamage(this.stats.getMinDamage() + gem.getStrength() * 2 + gem.getAgility());
            this.stats.setMaxDamage(this.stats.getMaxDamage() + gem.getStrength() * 3 + gem.getAgility() * 4);
        }
    }

    public void removeGem(int index) {
        this.sockets.remove(index);
    }

    protected BaseStats getStats() {
        return this.stats;
    }

    protected int getSumStrength(){
        int sum = 0;
        for (Gems gem : sockets.values()) {
            sum += gem.getStrength();
        }
        return sum;
    }

    protected int getSumAgility(){
        int sum = 0;
        for (Gems gem : sockets.values()) {
            sum += gem.getAgility();
        }
        return sum;
    }

    protected int getSumVitality(){
        int sum = 0;
        for (Gems gem : sockets.values()) {
            sum += gem.getVitality();
        }
        return sum;
    }

    @Override
    public String toString() {
        return String.format("%s: ", this.name);
    }
}
