package callofduty;

import callofduty.core.MissionControlImpl;
import callofduty.engine.Engine;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;
import callofduty.interfaces.Runnable;
import callofduty.io.ConsoleReader;
import callofduty.io.ConsoleWriter;
import callofduty.manager.MissionManagerImpl;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        MissionControl missionControl = new MissionControlImpl();
        MissionManager missionManager = new MissionManagerImpl();

        Runnable engine = new Engine(reader, writer, missionControl, missionManager);

        engine.run();
    }
}




