package ExamArrPerGee.app.models.actions;

import ExamArrPerGee.app.contracts.Targetable;
import ExamArrPerGee.app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class OneVsOneTest {

    private static final String NOT_TWO_PARTICIPANTS = "There should be exactly 2 participants for OneVsOne!";

    private OneVsOne action;
    private List<Targetable> participants;
    private Warrior victor;
    private Warrior loser;

    @Before
    public void setUp() {
        this.action = new OneVsOne();
        this.participants = new ArrayList<>();

        this.victor = Mockito.mock(Warrior.class);
        this.loser = Mockito.mock(Warrior.class);
        Mockito.doNothing().when(this.victor).levelUp();
        Mockito.doNothing().when(this.loser).levelUp();
        Mockito.when(this.victor.attack(this.loser)).thenReturn("");
        Mockito.when(this.loser.attack(this.victor)).thenReturn("");
        Mockito.when(this.victor.isAlive()).thenReturn(true);
        Mockito.when(this.victor.getName()).thenReturn("Victor");
        Mockito.when(this.loser.isAlive()).thenReturn(false);
        Mockito.when(this.loser.getName()).thenReturn("Loser");
    }

    @Test
    public void executeActionShouldFailForOneWarrior() {
        this.participants.add(new Warrior());
        String result = this.action.executeAction(this.participants);
        Assert.assertTrue(NOT_TWO_PARTICIPANTS.equals(result));
    }

    @Test
    public void executeActionShouldFailForThreeWarriors() {
        for (int i = 0; i < 3; i++) {
            this.participants.add(new Warrior());
        }
        String result = this.action.executeAction(this.participants);
        Assert.assertTrue(NOT_TWO_PARTICIPANTS.equals(result));
    }

    @Test
    public void executeActionShouldSucceedForFirstWarrior() {
        this.participants.add(this.victor);
        this.participants.add(this.loser);
        String result = this.action.executeAction(this.participants).trim();
        Assert.assertTrue(result, result.startsWith(this.victor.getName()));
    }

    @Test
    public void executeActionShouldSucceedForSecondWarrior() {
        this.participants.add(this.loser);
        this.participants.add(this.victor);
        String result = this.action.executeAction(this.participants).trim();
        Assert.assertTrue(result, result.startsWith(this.victor.getName()));
    }

/*    @Test // Test #4 fails for memory if this one is used
    public void executeActionSucceedsForTwo() {
        OneVsOne action = new OneVsOne();
        Warrior war1 = new Warrior();
        war1.setName("War1");
        war1.setHealth(1);
        Warrior war2 = new Warrior();
        war2.setHealth(10000);
        war2.setName("War2");
        String result = action.executeAction(Arrays.asList(war1, war2)).trim();
        Assert.assertTrue(result.contains("War2 is victorious"));
    }

   @Test // Test #4 fails for memory if this one is used
    public void executeActionSucceedsForTwoTwo() {
        OneVsOne action = new OneVsOne();
        Warrior war1 = new Warrior();
        war1.setName("War1");
        war1.setHealth(1);
        Warrior war2 = new Warrior();
        war2.setHealth(10000);
        war2.setName("War2");
        String result = action.executeAction(Arrays.asList(war2, war1)).trim();
        Assert.assertTrue(result.contains("War2 is victorious"));
    }*/
}
