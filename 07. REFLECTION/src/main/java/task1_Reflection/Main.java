package task1_Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> ref = Reflection.class;
        System.out.println(ref);
        System.out.println(ref.getSuperclass());

        Class[] interfaces = ref.getInterfaces();
        for (Class contract : interfaces) {
            System.out.println(contract);
        }

        Reflection instance = ref.getDeclaredConstructor().newInstance();
        System.out.println(instance);
    }
}
