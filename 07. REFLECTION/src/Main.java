import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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

        
    }
}
