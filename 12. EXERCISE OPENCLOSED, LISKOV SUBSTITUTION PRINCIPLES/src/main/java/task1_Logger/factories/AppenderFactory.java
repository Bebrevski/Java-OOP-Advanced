package task1_Logger.factories;

import task1_Logger.api.Appender;
import task1_Logger.api.Layout;
import task1_Logger.enums.ReportLevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AppenderFactory {

    private static final String PATH = "task1_Logger.impl.аppenders.";
    private static final String CLASS_IS_MISSING = "Class is missing";

    private AppenderFactory() {

    }

    @SuppressWarnings("unchecked")
    public static Appender create(String appenderType, String layoutType, ReportLevel reportLevel) {
        Layout layout = LayoutFactory.create(layoutType);

        try {
            Class<Appender> appenderClass = (Class<Appender>) Class.forName(PATH + appenderType);

            Constructor<Appender> appenderConstructor = appenderClass.getDeclaredConstructor(Layout.class);

            Appender appender = appenderConstructor.newInstance(layout);
            appender.setReportLevel(reportLevel);

            return appender;

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException(CLASS_IS_MISSING);
    }
}
