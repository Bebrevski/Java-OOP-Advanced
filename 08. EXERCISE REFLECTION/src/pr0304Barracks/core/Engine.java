package pr0304Barracks.core;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMAND_PATH = "pr0304Barracks.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpredCommand(data, commandName);
                if (result != null && result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpredCommand(String[] data, String commandName) {

        String output = null;

        String actualCommandName =
                Character.toUpperCase(commandName.charAt(0)) +
                        commandName.substring(1) +
                        "Command";

        try {
            Class<?> commandClass = Class.forName(COMMAND_PATH + actualCommandName);
            Executable command = (Executable) commandClass
                    .getDeclaredConstructor(String[].class, UnitFactory.class, Repository.class)
                    .newInstance(data, this.unitFactory, this.repository);

            output = command.execute();

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | ClassNotFoundException e) {
            return "Invalid Command!";
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }

        return output;
    }
}
