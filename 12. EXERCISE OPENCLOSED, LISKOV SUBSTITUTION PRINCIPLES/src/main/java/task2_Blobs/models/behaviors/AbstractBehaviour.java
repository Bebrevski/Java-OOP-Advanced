package task2_Blobs.models.behaviors;

import task2_Blobs.interfaces.Behaviour;

public abstract class AbstractBehaviour implements Behaviour {

    private boolean isTriggered;
    private boolean toDelayRecurrentEffect;

    protected AbstractBehaviour() {
        this.toDelayRecurrentEffect = true;
    }

    protected void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    public boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }
}
