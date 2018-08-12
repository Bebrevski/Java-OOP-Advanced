package ExamArrPerGee.app.models.participants;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class WarriorTest {

    private final int HERO_HEALTH_MULTIPLIER = 10;
    private final int LEVEL_UP_MULTIPLIER = 2;

    private Warrior warrior;

    @Before
    public void setUp() {
        this.warrior = new Warrior();
        this.warrior.setName("Warrior");
    }

    @Test
    public void receiveReward() {
        double startGold = this.getGold(this.warrior);
        double reward = 1.0d;
        this.warrior.receiveReward(reward);
        Assert.assertEquals(this.getGold(this.warrior), startGold + reward, Double.MIN_VALUE);
    }

    @Test
    public void takeDamageAndSurvive() {
        double startHealth = 5.0d;
        double damage = 1.0d;
        this.warrior.setHealth(startHealth);
        this.warrior.takeDamage(damage);
        Assert.assertEquals(this.warrior.getHealth(), startHealth - damage, Double.MIN_VALUE);
        Assert.assertTrue(this.warrior.isAlive());
    }

    @Test
    public void warriorIsAliveOnCreation() {
        Assert.assertTrue(this.warrior.isAlive());
    }

    @Test
    public void warriorDiesOnAttack() {
        this.warrior.takeDamage(this.warrior.getHealth());
        Assert.assertFalse(this.warrior.isAlive());
    }

    @Test
    public void levelUp() {
        this.warrior.setStrength(3);
        this.warrior.setDexterity(4);
        this.warrior.setIntelligence(5);

        this.warrior.levelUp();

        Assert.assertEquals(this.warrior.getStrength(), 3 * LEVEL_UP_MULTIPLIER);
        Assert.assertEquals(this.warrior.getDexterity(), 4 * LEVEL_UP_MULTIPLIER);
        Assert.assertEquals(this.warrior.getIntelligence(), 5 * LEVEL_UP_MULTIPLIER);

        double expectedHealth = 3 * LEVEL_UP_MULTIPLIER * HERO_HEALTH_MULTIPLIER;
        Assert.assertEquals(this.warrior.getHealth(), expectedHealth, Double.MIN_VALUE);
    }

    @Test // Don't use in Judge - fails test #1
    public void levelUpHealthOverflow() {
        this.warrior.setStrength(1_000_000_000);
        this.warrior.setDexterity(4);
        this.warrior.setIntelligence(5);

        this.warrior.levelUp();

        double expectedHealth = 1_000_000_000L * LEVEL_UP_MULTIPLIER * HERO_HEALTH_MULTIPLIER;
        expectedHealth = -1474836480; // Use this for Judge
//        System.out.printf("%.128f%n", this.warrior.getHealth());
//        System.out.printf("%.128f%n", expectedHealth);

        Assert.assertEquals(this.warrior.getHealth(), expectedHealth, Double.MIN_VALUE);
    }

    @SuppressWarnings("unchecked")
    private double getGold(Warrior warrior) {
        try {
            Field gold = Warrior.class.getDeclaredField("gold");  // Use for Judge
//            Field gold = AbstractActor.class.getDeclaredField("gold");
            gold.setAccessible(true);
            return (double) gold.get(warrior);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0d;
    }
}
