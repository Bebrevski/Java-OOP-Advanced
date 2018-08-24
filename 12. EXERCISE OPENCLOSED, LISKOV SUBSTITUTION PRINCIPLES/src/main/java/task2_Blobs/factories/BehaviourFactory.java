package task2_Blobs.factories;

import task2_Blobs.interfaces.Behaviour;

import java.lang.reflect.InvocationTargetException;

public final class BehaviourFactory {
    private static final String BEHAVIOUR_PATH = "task2_Blobs.models.behaviors.";

    private BehaviourFactory() {
    }

    public static Behaviour createBehaviour(String type){

        Behaviour behaviour = null;

        try {
            Class<?> clazz = Class.forName(BEHAVIOUR_PATH + type);
            behaviour = (Behaviour) clazz.getDeclaredConstructor().newInstance();

        } catch (ClassNotFoundException |
                IllegalAccessException |
                NoSuchMethodException |
                InstantiationException |
                InvocationTargetException e) {

            e.printStackTrace();
        }

        return behaviour;
    }
}
