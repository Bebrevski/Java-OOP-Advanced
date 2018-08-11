package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class VehicleAssemblerTest {

    private Assembler vehicleAssembler;

    private Part attackModifyingPart;
    private Part defenseModifyingPart;
    private Part hitPointsModifyingPart;


    @Before
    public void setUp() {
        this.vehicleAssembler = new VehicleAssembler();

        this.attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);

        this.vehicleAssembler.addArsenalPart(this.attackModifyingPart);
        this.vehicleAssembler.addShellPart(this.defenseModifyingPart);
        this.vehicleAssembler.addEndurancePart(this.hitPointsModifyingPart);
    }

    @Test
    public void getTotalWeight() {
        //Arrange
        Mockito.when(this.attackModifyingPart.getWeight()).thenReturn(10D);
        Mockito.when(this.defenseModifyingPart.getWeight()).thenReturn(20D);
        Mockito.when(this.hitPointsModifyingPart.getWeight()).thenReturn(30D);

        //Act
        double actualWeight = this.vehicleAssembler.getTotalWeight();
        double expectedWeight = 60D;

        //Assert

        Assert.assertEquals(actualWeight, expectedWeight, 0.0001);
    }

    @Test
    public void getTotalPrice() {
        //Arrange
        Mockito.when(this.attackModifyingPart.getPrice()).thenReturn(new BigDecimal(10));
        Mockito.when(this.defenseModifyingPart.getPrice()).thenReturn(new BigDecimal(20));
        Mockito.when(this.hitPointsModifyingPart.getPrice()).thenReturn(new BigDecimal(30));

        //Act
        BigDecimal actualPrice = this.vehicleAssembler.getTotalPrice();
        BigDecimal expectedPrice = new BigDecimal(60);

        //Assert

        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @Test
    public void getTotalAttackModification() {
        //Arrange
        Part additionalAttackPart = Mockito.mock(AttackModifyingPart.class);
        this.vehicleAssembler.addArsenalPart(additionalAttackPart);

        Mockito.when(((AttackModifyingPart) this.attackModifyingPart).getAttackModifier()).thenReturn(200);
        Mockito.when(((AttackModifyingPart) additionalAttackPart).getAttackModifier()).thenReturn(100);

        //Act
        long actual = this.vehicleAssembler.getTotalAttackModification();
        long expected = 300L;

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalDefenseModification() {
        //Arrange
        Part additionalDefensePart = Mockito.mock(DefenseModifyingPart.class);
        this.vehicleAssembler.addShellPart(additionalDefensePart);

        Mockito.when(((DefenseModifyingPart) this.defenseModifyingPart).getDefenseModifier()).thenReturn(200);
        Mockito.when(((DefenseModifyingPart) additionalDefensePart).getDefenseModifier()).thenReturn(100);

        //Act
        long actual = this.vehicleAssembler.getTotalDefenseModification();
        long expected = 300L;

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalHitPointModification() {
        //Arrange
        Part additionalHitPointsPart = Mockito.mock(HitPointsModifyingPart.class);
        this.vehicleAssembler.addEndurancePart(additionalHitPointsPart);

        Mockito.when(((HitPointsModifyingPart) this.hitPointsModifyingPart).getHitPointsModifier()).thenReturn(200);
        Mockito.when(((HitPointsModifyingPart) additionalHitPointsPart).getHitPointsModifier()).thenReturn(100);

        //Act
        long actual = this.vehicleAssembler.getTotalHitPointModification();
        long expected = 300L;

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addArsenalPartListSize() throws NoSuchFieldException, IllegalAccessException {
        //Arrange
        Assembler assembler = new VehicleAssembler();
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part3 = Mockito.mock(AttackModifyingPart.class);

        //Act
        assembler.addArsenalPart(part1);
        assembler.addArsenalPart(part2);
        assembler.addArsenalPart(part3);

        Field field = assembler.getClass().getDeclaredField("arsenalParts");
        field.setAccessible(true);
        List<AttackModifyingPart> value = (List<AttackModifyingPart>) field.get(assembler);

        int actualSize = value.size();
        int expectedSize = 3;

        //Assert
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addArsenalPartAndGetReturnResult() {
        //Arrange
        Assembler assembler = new VehicleAssembler();
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part3 = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(part1.getAttackModifier()).thenReturn(10);
        Mockito.when(part2.getAttackModifier()).thenReturn(20);
        Mockito.when(part3.getAttackModifier()).thenReturn(30);

        assembler.addArsenalPart(part1);
        assembler.addArsenalPart(part2);
        assembler.addArsenalPart(part3);

        //Act
        long actual = assembler.getTotalAttackModification();
        long expected = 60;

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addArsenalPart() {
        //Arrange
        Assembler assembler = new VehicleAssembler();
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(part1.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        assembler.addArsenalPart(part1);
        assembler.addArsenalPart(part2);

        //Act
        long actual = assembler.getTotalAttackModification();
        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addShellPart() {
        //Arrange
        Assembler assembler = new VehicleAssembler();
        DefenseModifyingPart part1 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part2 = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(part1.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        assembler.addShellPart(part1);
        assembler.addShellPart(part2);

        //Act
        long actual = assembler.getTotalDefenseModification();
        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addEndurancePart() {
        //Arrange
        Assembler assembler = new VehicleAssembler();
        HitPointsModifyingPart part1 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part2 = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(part1.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(part2.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        assembler.addEndurancePart(part1);
        assembler.addEndurancePart(part2);

        //Act
        long actual = assembler.getTotalHitPointModification();
        long expected = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expected, actual);
    }
}
