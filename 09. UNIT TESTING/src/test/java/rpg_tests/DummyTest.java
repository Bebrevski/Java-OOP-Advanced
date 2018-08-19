package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int ATTACK = 10;
    private static final int HEALTH = 15;
    private static final int EXPERIENCE = 10;

    private Dummy dummy;
    private Axe axe;

    @Before
    public void setUp() {
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void loseHealthAfterAttack() {
        //Arrange

        //Act
        dummy.takeAttack(ATTACK);

        //Assert
        int expected = 5;
        int actual = dummy.getHealth();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyCanNotBeAttacked() {
        //Arrange

        //Act
        dummy.takeAttack(ATTACK);
        dummy.takeAttack(ATTACK);
        dummy.takeAttack(ATTACK);

        //Assert
    }

    @Test
    public void deadDummyCanGiveExp() {
        //Arrange

        //Act
        dummy.takeAttack(ATTACK);
        dummy.takeAttack(ATTACK);

        //Assert
        int expected = EXPERIENCE;
        int actual = dummy.giveExperience();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNotGiveExp() {
        //Arrange

        //Act
        dummy.takeAttack(ATTACK);
        dummy.giveExperience();

        //Assert
    }
}