package callofduty.engine;

import callofduty.annotations.Inject;
import callofduty.interfaces.*;
import callofduty.interfaces.Runnable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMAND_PATH = "callofduty.commands.";
    private static final String COMMAND_SUFFIX_NAME = "Command";
    private static final String TERMINATE_LINE = "Over";

    private InputReader reader;
    private OutputWriter writer;
    private MissionControl missionControl;
    private MissionManager missionManager;

    private String[] data;

    public Engine(InputReader reader, OutputWriter writer, MissionControl missionControl, MissionManager missionManager) {
        this.reader = reader;
        this.writer = writer;
        this.missionControl = missionControl;
        this.missionManager = missionManager;
    }

    @Override
    public void run() {
        while (true) {
            String userInput = reader.readLine();

            String[] args = userInput.split("\\s+");

            this.interpredCommand(args, args[0]);

            if (TERMINATE_LINE.equals(userInput)) {
                break;
            }
        }
    }

    private void interpredCommand(String[] data, String commandName) {

        //this.data = Arrays.stream(data).skip(1).toArray(String[]::new);
        this.data = data;

        try {
            String commandClassName = this.parseCommandName(commandName);

            Class<?> commandClass = Class.forName(
                    COMMAND_PATH +
                            commandClassName +
                            COMMAND_SUFFIX_NAME);

            Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor();

            Executable command = (Executable) declaredConstructor.newInstance();

            this.injectDependencies(command);

           this.writer.println(command.execute());

        } catch (ClassNotFoundException |
                NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException |
                InstantiationException e) {

            System.out.println("ERROR....Engine line 73");
        }
    }

    private String parseCommandName(String commandName) {
        return String.valueOf(commandName.charAt(0)).toUpperCase()
                + commandName.substring(1);
    }

    private <T> void injectDependencies(T command) throws IllegalAccessException {
        Field[] commandFields = command.getClass()
                .getDeclaredFields();

        Field[] engineFields = this.getClass()
                .getDeclaredFields();

        for (Field commandField : commandFields) {
            commandField.setAccessible(true);

            if (commandField.isAnnotationPresent(Inject.class)) {

                for (Field engineField : engineFields) {

                    boolean commandClassNameEqualsEngineClassName =
                            commandField.getType().getSimpleName()
                                    .equals(engineField.getType().getSimpleName());

                    boolean commandTypeEqualsEngineType =
                            commandField.getType()
                                    .equals(engineField.getType());

                    if (commandClassNameEqualsEngineClassName && commandTypeEqualsEngineType) {
                        commandField.set(command, engineField.get(this));
                    }
                }
            }
        }
    }
}
