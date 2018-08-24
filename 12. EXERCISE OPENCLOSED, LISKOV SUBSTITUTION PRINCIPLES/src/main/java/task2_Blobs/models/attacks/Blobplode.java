package task2_Blobs.models.attacks;

import task2_Blobs.interfaces.Attack;
import task2_Blobs.models.Blob;

public class Blobplode implements Attack {

    @Override
    public void execute(Blob source, Blob target) {

        int sourceHealthAfterAttack = source.getHealth() - source.getHealth() / 2;

        if (sourceHealthAfterAttack >= 1) {
            source.setHealth(sourceHealthAfterAttack);
        }

        target.setHealth(target.getHealth() - source.getDamage() * 2);
    }
}
