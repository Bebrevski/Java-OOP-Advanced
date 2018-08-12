package task2_GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m ->
                        m.getName().startsWith("get") &&
                        !m.getReturnType().equals(void.class) &&
                        m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s will return %s"
                        , m.getName()
                        , m.getReturnType().getSimpleName())));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m ->
                        m.getName().startsWith("set") &&
                        m.getReturnType().equals(void.class) &&
                        m.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s and will set field of %s"
                        , m.getName()
                        , m.getParameterTypes()[0].getSimpleName())));
    }
}
