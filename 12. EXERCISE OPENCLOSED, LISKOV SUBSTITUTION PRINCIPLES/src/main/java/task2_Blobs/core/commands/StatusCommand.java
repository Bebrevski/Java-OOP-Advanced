package task2_Blobs.core.commands;

import task2_Blobs.annotations.Inject;
import task2_Blobs.interfaces.Executable;
import task2_Blobs.interfaces.Repository;
import task2_Blobs.interfaces.Writer;
import task2_Blobs.models.Blob;

public class StatusCommand implements Executable {

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Writer writer;

    @Override
    public void execute() {
        this.blobRepository.findAll()
                .forEach(blob -> this.writer.writeLine(blob.toString()));
    }
}
