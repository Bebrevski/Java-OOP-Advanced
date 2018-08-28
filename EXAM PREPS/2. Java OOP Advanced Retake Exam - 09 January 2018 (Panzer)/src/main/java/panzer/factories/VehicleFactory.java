package panzer.factories;

import panzer.contracts.Assembler;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

public final class VehicleFactory {

    private static final String PATH = "panzer.models.vehicles.";

    private VehicleFactory() {
    }

    public static Vehicle create(List<String> arguments) {

        String type = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        long attack = Long.parseLong(arguments.get(5));
        long defense = Long.parseLong(arguments.get(6));
        long hitPoints = Long.parseLong(arguments.get(7));
        Assembler assembler = new VehicleAssembler();

        Vehicle clazz = null;
        try {
            clazz = (Vehicle) Class.forName(PATH + type)
                    .getDeclaredConstructor(
                            String.class,
                            double.class,
                            BigDecimal.class,
                            long.class,
                            long.class,
                            long.class,
                            Assembler.class)
                    .newInstance(
                            model,
                            weight,
                            price,
                            attack,
                            defense,
                            hitPoints,
                            assembler);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("*****ERROR*****VehicleFactory class, create");
        }

        return clazz;
    }
}
