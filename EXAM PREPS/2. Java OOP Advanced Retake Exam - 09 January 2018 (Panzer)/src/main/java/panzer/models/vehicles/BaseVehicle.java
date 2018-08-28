package panzer.models.vehicles;

import panzer.contracts.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseVehicle implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private long attack;
    private long defense;
    private long hitPoints;
    private Assembler assembler;

    protected BaseVehicle(
            String model,
            double weight,
            BigDecimal price,
            long attack,
            long defense,
            long hitPoints,
            Assembler assembler) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler = assembler;
    }

    private String getPartsInfo() {
        StringBuilder sb = new StringBuilder();
        for (Part part : this.getParts()) {
            sb.append(part.getModel()).append(", ");
        }

        if (sb.toString().equals("")) {
            sb.append("None");
        } else {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.toString();
    }

    @Override
    public double getTotalWeight() {
        return this.assembler.getTotalWeight() + this.weight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.assembler.getTotalPrice().add(this.price);
    }

    @Override
    public long getTotalAttack() {
        return this.assembler.getTotalAttackModification() + this.attack;
    }

    @Override
    public long getTotalDefense() {
        return this.assembler.getTotalDefenseModification() + this.defense;
    }

    @Override
    public long getTotalHitPoints() {
        return this.hitPoints + this.assembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        try {
            Field arsenalPartsField = this.assembler.getClass().getDeclaredField("arsenalParts");
            arsenalPartsField.setAccessible(true);
            List<AttackModifyingPart> attackModifyingParts = (List<AttackModifyingPart>) arsenalPartsField.get(this.assembler);

            Field shellPartsField = this.assembler.getClass().getDeclaredField("shellParts");
            shellPartsField.setAccessible(true);
            List<DefenseModifyingPart> defenseModifyingParts = (List<DefenseModifyingPart>) shellPartsField.get(this.assembler);

            Field endurancePartsField = this.assembler.getClass().getDeclaredField("enduranceParts");
            endurancePartsField.setAccessible(true);
            List<HitPointsModifyingPart> hitPointsModifyingParts = (List<HitPointsModifyingPart>) endurancePartsField.get(this.assembler);

            List<Part> parts = new ArrayList<>();
            parts.addAll(attackModifyingParts);
            parts.addAll(defenseModifyingParts);
            parts.addAll(hitPointsModifyingParts);

            return parts;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("*****ERROR*****BaseVehicle class, getParts");
        }

        return null;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(String.format("%s - %s"
                        , this.getClass().getSimpleName()
                        , this.getModel()))
                .append(System.lineSeparator())
                .append(String.format("Total Weight: %.3f"
                        , this.getTotalWeight()))
                .append(System.lineSeparator())
                .append(String.format("Total Price: %.3f"
                        , this.getTotalPrice()))
                .append(System.lineSeparator())
                .append(String.format("Attack: %d"
                        , this.getTotalAttack()))
                .append(System.lineSeparator())
                .append(String.format("Defense: %d"
                        , this.getTotalDefense()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d"
                        , this.getTotalHitPoints()))
                .append(System.lineSeparator())
                .append(String.format("Parts: %s"
                        , this.getPartsInfo()));

        return sb.toString();
    }
}
