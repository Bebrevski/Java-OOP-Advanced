package task1_Logger.file;

import task1_Logger.api.File;

public class LogFile implements File {

    private StringBuilder messages;

    public LogFile() {
        this.messages = new StringBuilder();
    }

    @Override
    public void write(String text) {
        this.messages.append(text).append('\n');
    }

    @Override
    public long size() {
        return this.messages.codePoints().filter(x -> (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')).sum();
    }
}
