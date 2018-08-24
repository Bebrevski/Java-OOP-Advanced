package task2_Blobs.models.behaviors;

import task2_Blobs.models.Blob;

public class Aggressive extends AbstractBehaviour {

    private static final int AGGRESSIVE_DAMAGE_MULTIPLY = 2;
    private static final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

    private int sourceInitialDamage;

    public Aggressive() {
        super();
    }

    public void trigger(Blob source) {
        super.setIsTriggered(true);
        this.sourceInitialDamage = source.getDamage();
        source.setDamage(source.getDamage() * AGGRESSIVE_DAMAGE_MULTIPLY);
    }

    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setDamage(source.getDamage() - AGGRESSIVE_DAMAGE_DECREMENT);

            if (source.getDamage() <= this.sourceInitialDamage) {
                source.setDamage(this.sourceInitialDamage);
            }
        }
    }

    public boolean toDelayRecurrentEffect() {
        return super.toDelayRecurrentEffect();
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        super.setToDelayRecurrentEffect(toDelayRecurrentEffect);
    }
}
