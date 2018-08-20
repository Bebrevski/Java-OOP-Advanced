package P02_FileStream.files;

import P02_FileStream.constracts.Streamable;

public abstract class AbstractStreamable implements Streamable {

    private int length;
    private int bytesSent;

    public AbstractStreamable(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }
    public int getLength() {
        return this.length;
    }

    public int getBytesSent() {
        return this.bytesSent;
    }
}
