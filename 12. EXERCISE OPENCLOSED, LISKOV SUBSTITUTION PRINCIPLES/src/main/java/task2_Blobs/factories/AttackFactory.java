package task2_Blobs.factories;

import task2_Blobs.interfaces.Attack;

import java.lang.reflect.InvocationTargetException;

public final class AttackFactory {
    private static final String ATTACK_PATH = "task2_Blobs.models.attacks.";

    private AttackFactory() {
    }

    public static Attack createAttack(String type){
        Attack attack = null;

        try {
            Class<?> clazz = Class.forName(ATTACK_PATH + type);
            attack = (Attack) clazz.getDeclaredConstructor().newInstance();

        } catch (ClassNotFoundException |
                IllegalAccessException |
                NoSuchMethodException |
                InstantiationException |
                InvocationTargetException e) {

            e.printStackTrace();
        }

        return attack;
    }
}
