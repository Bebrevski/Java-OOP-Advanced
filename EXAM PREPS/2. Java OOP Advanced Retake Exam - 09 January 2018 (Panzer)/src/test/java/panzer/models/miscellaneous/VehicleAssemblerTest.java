package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class VehicleAssemblerTest {

    private VehicleAssembler assembler;

    private AttackModifyingPart attackModifyingPart;
    private HitPointsModifyingPart hitPointsModifyingPart;
    private DefenseModifyingPart defenseModifyingPart;

    @Before
    public void init() {
        this.assembler = new VehicleAssembler();
        this.attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        this.defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);

        this.assembler.addArsenalPart(this.attackModifyingPart);
        this.assembler.addEndurancePart(this.hitPointsModifyingPart);
        this.assembler.addShellPart(this.defenseModifyingPart);
    }

    // Returns the summed up weights of all parts in the assembler
    @Test
    public void testGetTotalWeight() {
        Mockito.when(this.attackModifyingPart.getWeight()).thenReturn(20D);
        Mockito.when(this.hitPointsModifyingPart.getWeight()).thenReturn(20D);
        Mockito.when(this.defenseModifyingPart.getWeight()).thenReturn(20D);

        double expected = 60;

        Assert.assertEquals(expected, this.assembler.getTotalWeight(), 0.0001);
    }

    // Returns the summed up prices of all parts in the assembler
    @Test
    public void testGetTotalPrice() {
        Mockito.when(this.attackModifyingPart.getPrice()).thenReturn(BigDecimal.ONE);
        Mockito.when(this.hitPointsModifyingPart.getPrice()).thenReturn(BigDecimal.ONE);
        Mockito.when(this.defenseModifyingPart.getPrice()).thenReturn(BigDecimal.ONE);

        BigDecimal expected = new BigDecimal(3);

        Assert.assertEquals(expected, this.assembler.getTotalPrice());
    }

    // Returns the summed up attackModifiers of all arsenal parts in the assembler
    @Test
    public void testGetTotalAttackModification() {
        Mockito.when(this.attackModifyingPart.getAttackModifier()).thenReturn(1);

        int expected = 1;

        Assert.assertEquals(expected, this.assembler.getTotalAttackModification());
    }

    // Returns the summed up defenseModifiers of all shell parts in the assembler
    @Test
    public void testGetTotalDefenseModification() {
        Mockito.when(this.defenseModifyingPart.getDefenseModifier()).thenReturn(1);

        int expected = 1;

        Assert.assertEquals(expected, this.assembler.getTotalDefenseModification());
    }

    // Returns the summed up hitPointsModifiers of all endurance parts in the assembler
    @Test
    public void testGetTotalHitPointModification() {
        Mockito.when(this.hitPointsModifyingPart.getHitPointsModifier()).thenReturn(1);

        int expected = 1;

        Assert.assertEquals(expected, this.assembler.getTotalHitPointModification());
    }

    // Adds an arsenal part to the assembler
    @Test
    public void testAddArsenalPart() {
        Assembler assembler = new VehicleAssembler();
        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart attackModifyingPart1 = Mockito.mock(AttackModifyingPart.class);

        assembler.addArsenalPart(attackModifyingPart);
        assembler.addArsenalPart(attackModifyingPart1);

        Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(attackModifyingPart1.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(expected, assembler.getTotalAttackModification());
    }

    // Adds a shell part to the assembler
    @Test
    public void testAddShellPart() {
        Assembler assembler = new VehicleAssembler();
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart defenseModifyingPart1 = Mockito.mock(DefenseModifyingPart.class);

        assembler.addShellPart(defenseModifyingPart);
        assembler.addShellPart(defenseModifyingPart1);

        Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(defenseModifyingPart1.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(expected, assembler.getTotalDefenseModification());
    }

    // Adds an endurance part to the assembler
    @Test
    public void testAddEndurancePart() {
        Assembler assembler = new VehicleAssembler();
        HitPointsModifyingPart e = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart e1 = Mockito.mock(HitPointsModifyingPart.class);

        assembler.addEndurancePart(e);
        assembler.addEndurancePart(e1);

        Mockito.when(e.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(e1.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(expected, assembler.getTotalHitPointModification());
    }
}
