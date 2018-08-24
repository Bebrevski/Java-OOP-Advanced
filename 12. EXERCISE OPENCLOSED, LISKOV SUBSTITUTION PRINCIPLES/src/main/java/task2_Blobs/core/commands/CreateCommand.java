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
import task2_Blobs.observers.Subject;

public class CreateCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Subject subject;

    @Override
    public void execute() {
        String name = this.data[0];
        int health = Integer.parseInt(this.data[1]);
        int damage = Integer.parseInt(this.data[2]);
        String behaviourType = this.data[3];
        String attackType = this.data[4];

        Behaviour behaviour = BehaviourFactory
                .createBehaviour(behaviourType);

        Attack attack = AttackFactory
                .createAttack(attackType);

        Blob blob = BlobFactory.createBlob(
                name,
                health,
                damage,
                behaviour,
                attack,
                this.subject);

        this.blobRepository.add(blob);
    }
}
