package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {

    private static final int ATTACK_DAMAGE = 10;
    private static final int DURABILITY = 1;
    private static final int HEALTH = 10;
    private static final int XP = 10;
    private static final int EXPECTED_DURABILITY = DURABILITY - 1;


    private Axe axe;
    private Dummy dummy;

    @Before
    public void getInstance() {
        this.axe = new Axe(ATTACK_DAMAGE, DURABILITY);
        this.dummy = new Dummy(HEALTH, XP);
    }

    @Test
    public void testIfWeaponLosesDurability() {
        Dummy dummy = new Dummy(HEALTH, XP);
        axe.attack(this.dummy);

        Assert.assertEquals("Durability does not decrease"
                , EXPECTED_DURABILITY, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithBrokenWeapon() {
        axe.attack(this.dummy);
        axe.attack(this.dummy);
    }
}
