package task2_Blobs.interfaces;

import task2_Blobs.models.Blob;

public interface Behaviour {

    void trigger(Blob source);

    void applyRecurrentEffect(Blob source);

    boolean isTriggered();
}
