package P02_FileStream.files;

import P02_FileStream.files.AbstractStreamable;

public class Music extends AbstractStreamable {

    private String artist;
    private String album;

    public Music(int length, int bytesSent, String artist, String album) {
        super(length, bytesSent);
        this.artist = artist;
        this.album = album;
    }
}
