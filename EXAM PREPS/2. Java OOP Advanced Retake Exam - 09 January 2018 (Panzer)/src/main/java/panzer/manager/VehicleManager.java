package panzer.manager;

import panzer.contracts.*;
import panzer.core.PanzerBattleOperator;
import panzer.factories.PartFactory;
import panzer.factories.VehicleFactory;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.ShellPart;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleManager implements Manager {

    private Map<String, Vehicle> vehicles;
    private Map<String, Vehicle> defeatedVehicles;
    private Map<String, Part> parts;
    private BattleOperator battleOperator;

    public VehicleManager() {
        this.vehicles = new LinkedHashMap<>();
        this.defeatedVehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
        this.battleOperator = new PanzerBattleOperator();
    }

    @Override
    public String addVehicle(List<String> arguments) {

        Vehicle vehicle = VehicleFactory.create(arguments);

        this.vehicles.put(vehicle.getModel(), vehicle);

        return String.format("Created %s Vehicle - %s"
                , vehicle.getClass().getSimpleName()
                , vehicle.getModel());
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel = arguments.get(1);

        Part part = PartFactory.create(arguments);

        this.parts.put(part.getModel(), part);

        String type;
        if (part instanceof ArsenalPart) {
            this.vehicles.get(vehicleModel).addArsenalPart(part);
            type = "Arsenal";
        } else if (part instanceof ShellPart) {
            this.vehicles.get(vehicleModel).addShellPart(part);
            type = "Shell";
        } else {
            this.vehicles.get(vehicleModel).addEndurancePart(part);
            type = "Endurance";
        }

        return String.format("Added %s - %s to Vehicle - %s",
                type, part.getModel(), vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        String model = arguments.get(1);

        Modelable subject;
        if (this.vehicles.containsKey(model)) {
            subject = this.vehicles.get(model);
        } else {
            subject = this.parts.get(model);
        }

        return subject.toString();
    }

    @Override
    public String battle(List<String> arguments) {
        Vehicle v1 = this.vehicles.get(arguments.get(1));
        Vehicle v2 = this.vehicles.get(arguments.get(2));

        String winner = this.battleOperator.battle(v1, v2);

        if (v1.getModel().equals(winner)) {
            this.vehicles.remove(v2.getModel());
            this.defeatedVehicles.put(v2.getModel(), v2);
        } else {
            this.vehicles.remove(v1.getModel());
            this.defeatedVehicles.put(v1.getModel(), v1);
        }

        return String.format("%s versus %s -> %s Wins! Flawless Victory!",
                v1.getModel(), v2.getModel(), winner);
    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("Remaining Vehicles: %s"
                ,this.vehicles.size() == 0 ?
                                "None" :
                                String.join(", ", this.vehicles
                                        .values()
                                        .stream()
                                        .map(Modelable::getModel)
                                        .collect(Collectors.toList()))))
                .append(System.lineSeparator())
                .append(String.format("Defeated Vehicles: %s"
                        ,this.defeatedVehicles.size() == 0 ?
                                "None" :
                                String.join(", ", this.defeatedVehicles
                                        .values()
                                        .stream()
                                        .map(Modelable::getModel)
                                        .collect(Collectors.toList()))))
                .append(System.lineSeparator())
                .append(String.format("Currently Used Parts: %d"
                ,this.getUsedParts()));

        return sb.toString();
    }

    private int getUsedParts() {
        int count = 0;

        for (Vehicle vehicle : vehicles.values()) {
            for (Part part : vehicle.getParts()) {
                count++;
            }
        }

        return count;
    }
}
