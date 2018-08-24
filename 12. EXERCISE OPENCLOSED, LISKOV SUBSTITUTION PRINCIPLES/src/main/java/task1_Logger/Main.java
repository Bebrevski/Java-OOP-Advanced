package task1_Logger;

import task1_Logger.controllers.Controller;
import task1_Logger.io.impl.InputReaderImpl;
import task1_Logger.io.interfaces.InputReader;

public class Main {

    public static void main(String[] args) {
        InputReader inputReader = new InputReaderImpl();
        Controller controller = new Controller(inputReader);

        controller.run();
    }
}
