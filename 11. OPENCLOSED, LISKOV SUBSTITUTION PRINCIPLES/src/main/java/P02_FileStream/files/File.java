package P02_FileStream.files;

public class File extends AbstractStreamable {

    private String name;

    public File(int length, int bytesSent, String name) {
        super(length, bytesSent);
        this.name = name;
    }
}
