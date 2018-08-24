package task1_Logger.api;

public interface Logger {

    void logError(String time, String message);

    void logInfo(String time, String message);

    void logWarning(String name, String message);

    void logCritical(String time, String message);

    void logFatal(String time, String message);
}
