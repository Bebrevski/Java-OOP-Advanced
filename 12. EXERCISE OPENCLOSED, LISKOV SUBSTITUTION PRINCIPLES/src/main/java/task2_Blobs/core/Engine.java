package task2_Blobs.core;

import task2_Blobs.annotations.Inject;
import task2_Blobs.interfaces.*;
import task2_Blobs.interfaces.Runnable;
import task2_Blobs.models.Blob;
import task2_Blobs.observers.Subject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Engine implements Runnable {

    private static final String TERMINATE_OUTPUT = "drop";
    private static final String COMMAND_PATH = "task2_Blobs.core.commands.";
    private static final String COMMAND_SUFFIX_NAME = "Command";

    private String[] data;
    private Reader reader;
    private Writer writer;
    private Repository<Blob> blobRepository;
    private Subject subject;

    public Engine(Reader reader, Writer writer, Repository<Blob> repo, Subject subject) {
        this.reader = reader;
        this.writer = writer;
        this.blobRepository = repo;
        this.subject = subject;
    }

    @Override
    public void run() {
        while (true) {
            String userInput = reader.readLine();

            if (userInput.equals(TERMINATE_OUTPUT)) {
                break;
            }

            String[] args = userInput.split("\\s+");

            this.interpredCommand(args, args[0]);

            this.subject.notifyAllObservers();

        }
    }

    private void interpredCommand(String[] data, String commandName) {

        this.data = Arrays.stream(data).skip(1).toArray(String[]::new);

        try {
            String commandClassName = this.parseCommandName(commandName);

            Class<?> commandClass = Class.forName(
                    COMMAND_PATH +
                            commandClassName +
                            COMMAND_SUFFIX_NAME);

            Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor();

            Executable command = (Executable) declaredConstructor.newInstance();

            this.injectDependencies(command);

            command.execute();

        } catch (ClassNotFoundException |
                NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException |
                InstantiationException e) {

            e.printStackTrace();
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
