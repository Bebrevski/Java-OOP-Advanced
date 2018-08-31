package onehitdungeon.factories;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class HeroFactory {

    private static final String HERO_PATH = "onehitdungeon.models.heroes.";

    private HeroFactory() {
    }

    public static Hero create(List<String> arguments){
        String type = arguments.get(1);
        String name = arguments.get(2);

        WeaponItem weaponItem = WeaponFactory.createWeaponItem(arguments);
        OffhandItem offhandItem = WeaponFactory.createOffhandItem(arguments);
        ArmorItem armorItem = WeaponFactory.createArmorItem(arguments);

        try {
            return (Hero) Class.forName(HERO_PATH + type)
                    .getDeclaredConstructor(String.class, WeaponItem.class, OffhandItem.class, ArmorItem.class)
                    .newInstance(name, weaponItem, offhandItem, armorItem);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("****ERROR****HeroFactory, create");
        }

        return null;
    }
}
