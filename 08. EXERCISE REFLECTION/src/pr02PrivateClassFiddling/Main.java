package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    private static final String FIELD_NAME = "innerValue";

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBox = constructor.newInstance();

        Method[] methods = blackBox.getClass().getDeclaredMethods();

        String input;
        while (!"END".equals(input = reader.readLine())) {

            String[] methodArgs = input.split("_");
            String methodName = methodArgs[0];
            Integer value = Integer.parseInt(methodArgs[1]);

            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    method.setAccessible(true);
                    method.invoke(blackBox, value);

                    Field field = blackBox.getClass().getDeclaredField(FIELD_NAME);
                    field.setAccessible(true);
                    System.out.println(field.get(blackBox));

                    field.setAccessible(false);
                    method.setAccessible(false);
                }
            }
        }

        constructor.setAccessible(false);
    }
}
