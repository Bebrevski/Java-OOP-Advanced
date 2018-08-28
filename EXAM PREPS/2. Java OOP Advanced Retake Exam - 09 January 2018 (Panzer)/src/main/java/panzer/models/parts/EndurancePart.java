package panzer.models.parts;

import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class EndurancePart extends BasePart implements HitPointsModifyingPart {

    private int hitPointModifier;

    public EndurancePart(String model, double weight, BigDecimal price, int hitPointModifier) {
        super(model, weight, price);
        this.hitPointModifier = hitPointModifier;
    }

    @Override
    public String toString() {
        return String.format("%s Part – %s\r\n+%d HitPoints"
                , this.getClass().getSimpleName()
                , this.getModel()
                , this.hitPointModifier);
    }


    @Override
    public int getHitPointsModifier() {
        return this.hitPointModifier;
    }
}
