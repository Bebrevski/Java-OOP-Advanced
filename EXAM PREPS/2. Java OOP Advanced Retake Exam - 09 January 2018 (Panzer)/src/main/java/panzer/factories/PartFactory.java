package panzer.factories;

import panzer.contracts.Part;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

public final class PartFactory {
    private static final String PATH = "panzer.models.parts.";
    private static final String SUFFIX = "Part";

    private PartFactory() {
    }

    public static Part create(List<String> arguments) {

        String partType = arguments.get(2);
        String model = arguments.get(3);
        double weight = Double.parseDouble(arguments.get(4));
        BigDecimal price = new BigDecimal(arguments.get(5));
        int additionalParameter = Integer.parseInt(arguments.get(6));

        Part clazz = null;
        try {
            clazz = (Part) Class.
                    forName(PATH + partType + SUFFIX)
                    .getDeclaredConstructor(
                            String.class,
                            double.class,
                            BigDecimal.class,
                            int.class)
                    .newInstance(model, weight, price, additionalParameter);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("*****ERROR*****PartFactory class, create");
        }

        return clazz;
    }
}
