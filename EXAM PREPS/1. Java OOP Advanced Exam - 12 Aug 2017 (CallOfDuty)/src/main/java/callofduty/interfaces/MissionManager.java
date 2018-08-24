package callofduty.interfaces;

import java.util.List;

public interface MissionManager {
    String agent(List<String> arguments);

    String request(List<String> arguments);

    String complete(List<String> arguments);

    String status(List<String> arguments);

    String over(List<String> arguments);
}
