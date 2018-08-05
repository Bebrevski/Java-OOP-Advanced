package rpg_tests;

import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;

public class HeroTests {

    private static final String HERO_NAME = "Pesho";
    private static final int TARGET_XP = 10;

    private Hero hero;
    private Target dummy;
    private Weapon weapon;

    @Before
    public void getInstance() {
        this.dummy = Mockito.mock(Dummy.class);
        this.weapon = Mockito.mock(Axe.class);

        this.hero = new Hero(HERO_NAME, this.weapon);
    }

    @Test
    public void testIfHeroGainsXPAfterTargetDies() {
        Mockito.when(this.dummy.isDead()).thenReturn(true);
        Mockito.when(this.dummy.giveExperience()).thenReturn(TARGET_XP);

        this.hero.attack(this.dummy);

        Assert.assertEquals("Hero does not take XP", TARGET_XP, this.hero.getExperience());
    }
}
