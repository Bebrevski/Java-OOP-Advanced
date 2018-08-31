package onehitdungeon.factories;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class WeaponFactory {

    private static final String ARMOR_ITEM_PATH = "onehitdungeon.models.items.ArmorItem";
    private static final String OFFHAND_ITEM_PATH = "onehitdungeon.models.items.OffhandItem";
    private static final String WEAPON_ITEM_PATH = "onehitdungeon.models.items.WeaponItem";

    private WeaponFactory() {
    }

    public static ArmorItem createArmorItem(List<String> arguments) {
        Integer battlePower;
        Double priceForUpdate;

        String type = arguments.get(1);

        if (type.equals("Paladin")) {
            battlePower = 25;
            priceForUpdate = 20D;
        } else {
            battlePower = 10;
            priceForUpdate = 25D;
        }

        try {
            return (ArmorItem) Class.forName(ARMOR_ITEM_PATH)
                    .getDeclaredConstructor(Integer.class, Double.class)
                    .newInstance(battlePower, priceForUpdate);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            System.out.println("****ERROR****WeaponFactory, createArmorItem");
            e.printStackTrace();
        }

        return null;
    }

    public static OffhandItem createOffhandItem(List<String> arguments) {

        Integer battlePower;
        Double priceForUpdate;

        String type = arguments.get(1);

        if (type.equals("Paladin")) {
            battlePower = 10;
            priceForUpdate = 10D;
        } else {
            battlePower = 25;
            priceForUpdate = 20D;
        }

        try {
            return (OffhandItem) Class.forName(OFFHAND_ITEM_PATH)
                    .getDeclaredConstructor(Integer.class, Double.class)
                    .newInstance(battlePower, priceForUpdate);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            System.out.println("****ERROR****WeaponFactory, createOffhandItem");
            e.printStackTrace();
        }

        return null;
    }

    public static WeaponItem createWeaponItem(List<String> arguments) {

        Integer battlePower;
        Double priceForUpdate;

        String type = arguments.get(1);

        if (type.equals("Paladin")) {
            battlePower = 20;
            priceForUpdate = 10D;
        } else {
            battlePower = 45;
            priceForUpdate = 15D;
        }

        try {
            return (WeaponItem) Class.forName(WEAPON_ITEM_PATH)
                    .getDeclaredConstructor(Integer.class, Double.class)
                    .newInstance(battlePower, priceForUpdate);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            System.out.println("****ERROR****WeaponFactory, createWeaponItem");
            e.printStackTrace();
        }

        return null;
    }
}
