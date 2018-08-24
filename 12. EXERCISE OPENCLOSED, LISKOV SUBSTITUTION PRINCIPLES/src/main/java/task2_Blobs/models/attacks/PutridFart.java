package task2_Blobs.models.attacks;

import task2_Blobs.interfaces.Attack;
import task2_Blobs.models.Blob;

public class PutridFart implements Attack {

    @Override
    public void execute(Blob source, Blob target) {
        int currentHealth = target.getHealth();
        currentHealth -= source.getDamage();
        target.setHealth(currentHealth);
    }
}
