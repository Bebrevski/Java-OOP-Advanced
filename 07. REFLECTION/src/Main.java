import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // task 1 - Reflection

//        Class<Reflection> currentClass = Reflection.class;
//        System.out.println(currentClass);
//        System.out.println(currentClass.getSuperclass());
//
//        Class[] interfaces = currentClass.getInterfaces();
//        for (Class anInterface : interfaces) {
//            System.out.println(anInterface);
//        }
//
//        Reflection ref = currentClass.getDeclaredConstructor().newInstance();
//        System.out.println(ref);

        // task 2 - Getters and Setters

//        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
//        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));
//
//        Method[] methods = Reflection.class.getDeclaredMethods();
//        for (Method method : methods) {
//
//            boolean isGetter = method.getName().startsWith("get") && !method.getReturnType().equals(void.class) && method.getParameterCount() == 0;
//            boolean isSetter = method.getName().startsWith("set") && method.getReturnType().equals(void.class) && method.getParameterCount() == 1;
//
//            if (isGetter) {
//                getters.add(method);
//            } else if (isSetter) {
//                setters.add(method);
//            }
//        }
//
//        getters.forEach(m -> System.out.println(String.format("%s will return %s"
//                , m.getName()
//                , m.getReturnType())));
//        setters.forEach(m -> System.out.println(String.format("%s and will set field of %s"
//                , m.getName()
//                , m.getParameterTypes()[0])));

        // task 3 - High Quality Mistakes

        Arrays.stream(Reflection.class.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(String.format("%s must be private!"
                        , f.getName())));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get"))
                .filter(m -> !m.getReturnType().equals(void.class))
                .filter(m -> m.getParameterCount() == 0)
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s have to be public!"
                        , m.getName())));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set"))
                .filter(m -> m.getReturnType().equals(void.class))
                .filter(m -> m.getParameterCount() == 1)
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s have to be private!"
                        , m.getName())));
    }
}
