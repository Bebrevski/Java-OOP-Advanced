package onehitdungeon.interfaces;

import java.util.List;

public interface DungeonManager {
    String hero(List<String> arguments);

    String select(List<String> arguments);

    String status(List<String> arguments);

    String fight(List<String> arguments);

    String advance(List<String> arguments);

    String train(List<String> arguments);

    String quit(List<String> arguments);
}
