package panzer.models.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class ShellPart extends BasePart implements DefenseModifyingPart {

    private int defenseModifier;

    public ShellPart(String model, double weight, BigDecimal price, int defenseModifier) {
        super(model, weight, price);
        this.defenseModifier = defenseModifier;
    }

    @Override
    public String toString() {
        return String.format("%s Part – %s\r\n+%d Defense"
                , this.getClass().getSimpleName()
                , this.getModel()
                , this.defenseModifier);
    }

    @Override
    public int getDefenseModifier() {
        return this.defenseModifier;
    }
}
