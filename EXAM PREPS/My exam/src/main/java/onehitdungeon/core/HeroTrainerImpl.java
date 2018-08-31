package onehitdungeon.core;

import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.HeroTrainer;
import onehitdungeon.interfaces.Item;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HeroTrainerImpl implements HeroTrainer {
    private Map<String, Integer> itemTrainProperties = new HashMap<>() {{
        put("onehitdungeon.models.heroes.paladin-weapon-battlepower", 60);
        put("onehitdungeon.models.heroes.paladin-weapon-priceforupgrade", 50);
        put("onehitdungeon.models.heroes.paladin-offhand-battlepower", 50);
        put("onehitdungeon.models.heroes.paladin-offhand-priceforupgrade", 100);
        put("onehitdungeon.models.heroes.paladin-armor-battlepower", 20);
        put("onehitdungeon.models.heroes.paladin-armor-priceforupgrade", 75);
        put("onehitdungeon.models.heroes.mage-weapon-battlepower", 20);
        put("onehitdungeon.models.heroes.mage-weapon-priceforupgrade", 67);
        put("onehitdungeon.models.heroes.mage-offhand-battlepower", 20);
        put("onehitdungeon.models.heroes.mage-offhand-priceforupgrade", 100);
        put("onehitdungeon.models.heroes.mage-armor-battlepower", 100);
        put("onehitdungeon.models.heroes.mage-armor-priceforupgrade", 100);
    }};

    private void increaseBattlePower(Field battlePowerField, Item itemObject, String property) throws IllegalAccessException {
        Integer oldBattlePower = (Integer) battlePowerField.get(itemObject);
        Integer modification = this.itemTrainProperties.get(property);
        Integer newBattlePower = (oldBattlePower * (modification + 100)) / 100;

        battlePowerField.set(itemObject, newBattlePower);
    }

    private void increasePriceForUpgrade(Field priceForUpgradeField, Item itemObject, String property) throws IllegalAccessException {
        Double oldPriceForUpgrade = (Double) priceForUpgradeField.get(itemObject);
        Integer modification = this.itemTrainProperties.get(property);
        Double newPriceForUpgrade = (oldPriceForUpgrade * (modification + 100)) / 100;

        priceForUpgradeField.set(itemObject, newPriceForUpgrade);
    }

    private String getItemType(String itemName) {
        if (itemName.contains("weapon")) return "weapon";
        else if (itemName.contains("offhand")) return "offhand";
        else if (itemName.contains("armor")) return "armor";
        return null;
    }

    private void trainItemBattlePower(String itemType, Item itemObject, Hero hero) throws NoSuchFieldException, IllegalAccessException {
        Field battlePowerField = itemObject
                .getClass()
                .getSuperclass()
                .getDeclaredField("battlePower");

        battlePowerField.setAccessible(true);

        String propertyBattlePower = String.format("%s-%s-battlepower", hero
                .getHeroClass().toLowerCase(), itemType);

        this.increaseBattlePower(battlePowerField, itemObject, propertyBattlePower);
    }

    private void trainItemPriceForUpgrade(String itemType, Item itemObject, Hero hero) throws NoSuchFieldException, IllegalAccessException {
        Field priceForUpgradeField = itemObject
                .getClass()
                .getSuperclass()
                .getDeclaredField("priceForUpgrade");

        priceForUpgradeField.setAccessible(true);

        String propertyPriceForUpgrade = String.format("%s-%s-priceforupgrade", hero
                .getHeroClass().toLowerCase(), itemType);

        this.increasePriceForUpgrade(priceForUpgradeField, itemObject, propertyPriceForUpgrade);
    }

    private void trainItem(Item item, Hero hero) throws IllegalAccessException, NoSuchFieldException {
        String itemType = this.getItemType(item.getClass().getSimpleName().toLowerCase());

        this.trainItemBattlePower(itemType, item, hero);
        this.trainItemPriceForUpgrade(itemType, item, hero);
    }

    public void trainHero(Hero hero) {
        try {
            this.trainItem(hero.getWeapon(), hero);
            this.trainItem(hero.getOffhand(), hero);
            this.trainItem(hero.getArmor(), hero);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}