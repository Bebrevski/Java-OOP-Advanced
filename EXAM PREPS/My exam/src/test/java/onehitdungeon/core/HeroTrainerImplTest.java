package onehitdungeon.core;

import onehitdungeon.interfaces.*;
import onehitdungeon.models.heroes.Mage;
import onehitdungeon.models.heroes.Paladin;
import onehitdungeon.models.heroes.BaseHero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HeroTrainerImplTest {

    private HeroTrainer heroTrainer;

    private Hero heroPaladin;
    private Hero heroMage;

    private ArmorItem armorItem;
    private OffhandItem offhandItem;
    private WeaponItem weaponItem;

    @Before
    public void setUp() throws Exception {
        this.heroTrainer = new HeroTrainerImpl();

        this.weaponItem = Mockito.mock(WeaponItem.class);
        this.offhandItem = Mockito.mock(OffhandItem.class);
        this.armorItem = Mockito.mock(ArmorItem.class);

        this.heroPaladin = new Paladin("Pesho", this.weaponItem, this.offhandItem, this.armorItem);
        this.heroMage = new Mage("Gosho", this.weaponItem, this.offhandItem, this.armorItem);
    }

    @Test
    public void trainHero() {

    }
}