package panzer.contracts;

import java.math.BigDecimal;

public interface Vehicle extends Modelable {
    double getTotalWeight();

    BigDecimal getTotalPrice();

    long getTotalAttack();

    long getTotalDefense();

    long getTotalHitPoints();

    void addArsenalPart(Part arsenalPart);

    void addShellPart(Part shellPart);

    void addEndurancePart(Part endurancePart);

    Iterable<Part> getParts();
}
