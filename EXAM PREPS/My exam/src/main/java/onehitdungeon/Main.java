package onehitdungeon;

import onehitdungeon.core.HeroTrainerImpl;
import onehitdungeon.engine.Engine;
import onehitdungeon.interfaces.*;
import onehitdungeon.interfaces.Runnable;
import onehitdungeon.io.ConsoleReader;
import onehitdungeon.io.ConsoleWriter;
import onehitdungeon.manager.Manager;
import onehitdungeon.models.Dungeon;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();

        HeroTrainer heroTrainer = new HeroTrainerImpl();
        IDungeon dungeon = new Dungeon();
        DungeonManager manager = new Manager(heroTrainer, dungeon);

        Runnable engine = new Engine(reader, writer, manager);

        engine.run();
    }
}
