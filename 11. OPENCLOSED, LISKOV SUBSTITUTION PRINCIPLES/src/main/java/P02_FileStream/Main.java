package P02_FileStream;

import P02_FileStream.constracts.Streamable;
import P02_FileStream.core.StreamProgressInfo;
import P02_FileStream.files.File;
import P02_FileStream.files.Music;
import P02_FileStream.files.Picture;
import P02_FileStream.files.Video;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final Streamable folder = new File(100, 5, "Documents");
        final Streamable song = new Music(3200, 1500, "Metallica", "The one");
        final Streamable picture = new Picture(5555, 4444, "Philipoff");
        final Streamable video = new Video(11542, 10000, "Someone", "HD");

        List<Streamable> collection = new ArrayList<Streamable>(){{
            add(folder);
            add(song);
            add(picture);
            add(video);
        }};

        for (Streamable streamable : collection) {
            StreamProgressInfo progressInfo = new StreamProgressInfo(streamable);

            System.out.println(progressInfo.calculateCurrentPercent());

            System.out.println(progressInfo.getFile().getLength());
            System.out.println(progressInfo.getFile().getBytesSent());
            System.out.println("-----");
        }
    }
}
