package panzer.contracts;

import java.util.List;

public interface Manager {
    String addVehicle(List<String> arguments);

    String addPart(List<String> arguments);

    String inspect(List<String> arguments);

    String battle(List<String> arguments);

    String terminate(List<String> arguments);
}
