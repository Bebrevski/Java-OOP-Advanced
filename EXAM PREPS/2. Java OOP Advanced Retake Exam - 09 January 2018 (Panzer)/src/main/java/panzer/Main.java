package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.contracts.Runnable;
import panzer.engine.Engine;
import panzer.io.ConsoleReader;
import panzer.io.ConsoleWriter;
import panzer.manager.VehicleManager;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Manager manager = new VehicleManager();

        Runnable engine = new Engine(reader, writer, manager);

        engine.run();
    }
}
