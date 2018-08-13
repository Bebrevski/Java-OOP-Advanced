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

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        try {

            Constructor constructor = BlackBoxInt.class.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);

            BlackBoxInt clazz = (BlackBoxInt) constructor.newInstance(0);
            constructor.setAccessible(false);

            while (!"END".equals(line = reader.readLine())) {
                String[] tokens = line.split("_");
                String methodName = tokens[0];
                int value = Integer.parseInt(tokens[1]);

                Method requestedMethod = clazz.getClass().getDeclaredMethod(methodName, int.class);
                requestedMethod.setAccessible(true);

                requestedMethod.invoke(clazz, value);

                Field field = clazz.getClass().getDeclaredField("innerValue");

                field.setAccessible(true);

                System.out.println(field.get(clazz));

                field.setAccessible(false);
                requestedMethod.setAccessible(false);
            }
        } catch (
                IOException |
                        NoSuchMethodException |
                        IllegalAccessException |
                        InvocationTargetException |
                        InstantiationException |
                        NoSuchFieldException ex
                ) {
            ex.printStackTrace();
        }
    }
}
