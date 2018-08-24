package task2_Blobs.core.commands;

import task2_Blobs.annotations.Inject;
import task2_Blobs.factories.AttackFactory;
import task2_Blobs.factories.BehaviourFactory;
import task2_Blobs.factories.BlobFactory;
import task2_Blobs.interfaces.Attack;
import task2_Blobs.interfaces.Behaviour;
import task2_Blobs.interfaces.Executable;
import task2_Blobs.interfaces.Repository;
import task2_Blobs.models.Blob;

public class AttackCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Override
    public void execute() {
        String sourceName = this.data[0];
        String targetName = this.data[1];

        Blob source = this.blobRepository.getByName(sourceName);
        Blob target = this.blobRepository.getByName(targetName);

        source.attack(target);
    }
}
