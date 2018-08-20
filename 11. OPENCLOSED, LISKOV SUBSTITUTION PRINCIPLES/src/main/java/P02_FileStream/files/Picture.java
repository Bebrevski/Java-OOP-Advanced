package P02_FileStream.files;

public class Picture extends AbstractStreamable {

    private String photographer;

    public Picture(int length, int bytesSent, String photographer) {
        super(length, bytesSent);
        this.photographer = photographer;
    }
}
