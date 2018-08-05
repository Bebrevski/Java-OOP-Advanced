package panzer.contracts;

import java.math.BigDecimal;

public interface Assembler {
    // Returns the summed up weights of all parts in the assembler
    double getTotalWeight();

    // Returns the summed up prices of all parts in the assembler
    BigDecimal getTotalPrice();

    // Returns the summed up attackModifiers of all arsenal parts in the assembler
    long getTotalAttackModification();

    // Returns the summed up defenseModifiers of all shell parts in the assembler
    long getTotalDefenseModification();

    // Returns the summed up hitPointsModifiers of all endurance parts in the assembler
    long getTotalHitPointModification();

    // Adds an arsenal part to the assembler
    void addArsenalPart(Part arsenalPart);

    // Adds a shell part to the assembler
    void addShellPart(Part shellPart);

    // Adds an endurance part to the assembler
    void addEndurancePart(Part endurancePart);
}
