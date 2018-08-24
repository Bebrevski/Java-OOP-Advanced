package task2_Blobs.io;

import task2_Blobs.interfaces.Writer;

public class OutputWriter implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
