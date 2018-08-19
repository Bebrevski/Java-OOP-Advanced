package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {

    private static final int DURABILITY = 10;
    private static final int ZERO_DURABILITY = 0;
    private static final int ATTACK = 10;
    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void arrangeInstances() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void axeLosesDurabilityAfterAttack() {
        //Arrange

        //Act
        axe.attack(dummy);

        //Assert
        int expected = 9;
        int actual = axe.getDurabilityPoints();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void attackWithBrokenWeapon() {
        //Arrange
        this.axe = new Axe(ATTACK, ZERO_DURABILITY);

        //Act
        axe.attack(dummy);

        //Assert
    }
}
