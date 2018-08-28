package panzer.models.parts;

import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class ArsenalPart extends BasePart implements AttackModifyingPart {

    private int attackModifier;

    public ArsenalPart(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public String toString() {
        return String.format("%s Part – %s\r\n+%d Attack"
                , this.getClass().getSimpleName()
                , this.getModel()
                , this.attackModifier);
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }
}
