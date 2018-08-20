package P02_FileStream.files;

public class Video extends AbstractStreamable {

    private String videoOperator;
    private String resolution;

    public Video(int length, int bytesSent, String videoOperator, String resolution) {
        super(length, bytesSent);
        this.videoOperator = videoOperator;
        this.resolution = resolution;
    }
}
