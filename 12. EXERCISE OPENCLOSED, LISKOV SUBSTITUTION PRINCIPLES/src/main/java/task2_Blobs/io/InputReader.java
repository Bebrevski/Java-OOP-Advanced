package task2_Blobs.io;

import task2_Blobs.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader implements Reader {

    private BufferedReader input;

    public InputReader() {
        this.input = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        // String result = null;

        try {
            return input.readLine();
        } catch (IOException ignored) {
            ;
        }

        //return null;
        return "Error in InputReader Class";
    }
}
