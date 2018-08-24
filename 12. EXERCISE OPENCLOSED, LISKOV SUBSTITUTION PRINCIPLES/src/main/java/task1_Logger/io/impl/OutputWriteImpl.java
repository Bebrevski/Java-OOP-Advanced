package task1_Logger.io.impl;

import task1_Logger.io.interfaces.OutputWriter;

public class OutputWriteImpl implements OutputWriter {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
