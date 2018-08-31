package onehitdungeon.interfaces;

public interface Hero extends Nameable {
    //<summary>
    // Returns a String with the Hero Type. Example: "Paladin", "Mage".
    //</summary>
    String getHeroClass();
    
    //<summary>
    // Returns the Hero's total gold.
    //</summary>
    Double getGold();

    //<summary>
    // Increases the Hero's gold by the given ammount.
    //</summary>
    void earnGold(Double gold);

    //<summary>
    // Decreases the Hero's gold by the given ammount.
    //</summary>
    void payGold(Double gold);

    //<summary>
    // Returns the Hero's weapon.
    //</summary>
    WeaponItem getWeapon();

    //<summary>
    // Returns the Hero's offhand.
    //</summary>
    OffhandItem getOffhand();

    //<summary>
    // Returns the Hero's armor.
    //</summary>
    ArmorItem getArmor();

    //<summary>
    // Returns the Hero's total battle power, calculated by a formula, depending on the hero.
    //</summary>
    Integer getTotalBattlePower();

    //<summary>
    // Returns the Hero's total price for upgrade.
    //</summary>
    Double getTotalPriceForUpgrade();
}
