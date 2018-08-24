package task2_Blobs.factories;

import task2_Blobs.interfaces.Attack;
import task2_Blobs.interfaces.Behaviour;
import task2_Blobs.models.Blob;
import task2_Blobs.observers.Subject;

public final class BlobFactory {

    private BlobFactory() {
    }

    public static Blob createBlob(
            String name,
            int health,
            int damage,
            Behaviour behaviour,
            Attack attack,
            Subject subject){

        return new Blob(
                name,
                health,
                damage,
                behaviour,
                attack,
                subject);
    }
}
