package task1_Logger.factories;

import task1_Logger.api.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class LayoutFactory {

    private static final String PATH = "task1_Logger.impl.layouts.";
    private static final String CLASS_IS_MISSING = "Class is missing";

    private LayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    public static Layout create(String name) {
        try {
            Class<Layout> layoutClass = (Class<Layout>) Class.forName(PATH + name);
            Constructor<Layout> layoutConstructor = layoutClass.getDeclaredConstructor();

            return layoutConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException(CLASS_IS_MISSING);
    }
}
