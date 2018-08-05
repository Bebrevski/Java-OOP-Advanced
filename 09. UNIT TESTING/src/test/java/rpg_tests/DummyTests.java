package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {

    private static final int ATTACK_DAMAGE = 5;
    private static final int DURABILITY = 10;
    private static final int HEALTH = 10;
    private static final int XP = 10;
    private static final int EXPECTED_HEALTH = HEALTH - ATTACK_DAMAGE;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void getInstance() {
        this.axe = new Axe(ATTACK_DAMAGE, DURABILITY);
        this.dummy = new Dummy(HEALTH, XP);
    }

    @Test
    public void testIfDummyLosesHealth() {
        this.axe.attack(this.dummy);
        Assert.assertEquals(
                "Dummy does not lose health",
                EXPECTED_HEALTH,
                this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }

    @Test
    public void deadDummyCanGiveXP() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        Assert.assertEquals(
                "Must give XP",
                XP,
                this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNotGiveXP() {
        this.dummy.giveExperience();
    }
}
