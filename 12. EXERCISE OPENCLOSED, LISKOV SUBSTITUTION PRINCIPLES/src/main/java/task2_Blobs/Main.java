package task2_Blobs;

import task2_Blobs.core.Engine;
import task2_Blobs.interfaces.Reader;
import task2_Blobs.interfaces.Repository;
import task2_Blobs.interfaces.Runnable;
import task2_Blobs.interfaces.Writer;
import task2_Blobs.io.InputReader;
import task2_Blobs.io.OutputWriter;
import task2_Blobs.models.Blob;
import task2_Blobs.observers.Subject;
import task2_Blobs.repositories.BlobRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Reader reader = new InputReader();
        Writer writer = new OutputWriter();
        Repository<Blob> repo = new BlobRepository();
        Subject subject = new Subject();

        Runnable engine = new Engine(reader, writer, repo, subject);

        engine.run();
    }
}
