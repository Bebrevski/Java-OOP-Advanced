package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Dummy;
import rpg_lab.Hero;

public class HeroTests {

    private static final String NAME = "Pesho";
    private static final int EXP = 10;

    private Hero hero;
    private Dummy dummy;

    @Before
    public void arrangeObjects(){
        this.hero = new Hero(NAME);
        this.dummy = Mockito.mock(Dummy.class);
    }

    @Test
    public void heroGainsExp(){
        //Arrange
        Mockito.when(dummy.isDead()).thenReturn(true);
        Mockito.when(dummy.giveExperience()).thenReturn(EXP);

        //Act
        hero.attack(dummy);

        //Assert
        int expected = EXP;
        int actual = hero.getExperience();
        Assert.assertEquals(expected, actual);
    }
}
