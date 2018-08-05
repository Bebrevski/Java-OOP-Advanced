package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractVehicle implements Vehicle {
    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler vehicleAssembler;
    private List<Part> parts;

    AbstractVehicle(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.vehicleAssembler=new VehicleAssembler();
        this.parts=new LinkedList<>();
    }

    @Override
    public double getTotalWeight() {
        return this.vehicleAssembler.getTotalWeight()+this.weight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.vehicleAssembler.getTotalPrice().add(this.price);
    }

    @Override
    public long getTotalAttack() {
        return this.vehicleAssembler.getTotalAttackModification()+this.attack;
    }

    @Override
    public long getTotalDefense() {
        return this.vehicleAssembler.getTotalDefenseModification()+this.defense;
    }

    @Override
    public long getTotalHitPoints() {
        return this.vehicleAssembler.getTotalHitPointModification()+this.hitPoints;
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.vehicleAssembler.addArsenalPart(arsenalPart);
        this.parts.add(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.vehicleAssembler.addShellPart(shellPart);
        this.parts.add(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.vehicleAssembler.addEndurancePart(endurancePart);
        this.parts.add(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return this.parts;
    }

    @Override
    public String getModel() {
        return this.model;
    }

}
