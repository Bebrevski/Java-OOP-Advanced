package P02_FileStream.core;

import P02_FileStream.constracts.Streamable;

public class StreamProgressInfo {

    private Streamable file;

    public StreamProgressInfo(Streamable file) {
        this.file = file;
    }

    public int calculateCurrentPercent() {
        return (this.file.getBytesSent() * 100) / this.file.getLength();
    }

    public Streamable getFile() {
        return this.file;
    }
}
