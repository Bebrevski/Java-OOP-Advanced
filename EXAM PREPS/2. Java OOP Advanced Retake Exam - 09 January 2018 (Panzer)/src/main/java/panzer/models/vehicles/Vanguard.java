package panzer.models.vehicles;

import panzer.contracts.Assembler;

import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {
    public Vanguard(String model, double weight, BigDecimal price,
            long attack, long defense, long hitPoints, Assembler assembler) {

        super(model,weight * 2, price, (int)(attack * 0.75),
                (int)(defense * 1.5), (int)(hitPoints * 1.75), assembler);
    }
}
