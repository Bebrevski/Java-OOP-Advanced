package task1_Logger.impl.loggers;

import task1_Logger.api.Appender;
import task1_Logger.api.Logger;
import task1_Logger.enums.ReportLevel;

public class MessageLogger implements Logger {

    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logError(String time, String message) {
        this.traverseAndAppend(time, message, ReportLevel.ERROR);
    }

    @Override
    public void logInfo(String time, String message) {
        this.traverseAndAppend(time, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String time, String message) {
        this.traverseAndAppend(time, message, ReportLevel.WARNING);
    }

    @Override
    public void logCritical(String time, String message) {
        this.traverseAndAppend(time, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String time, String message) {
        this.traverseAndAppend(time, message, ReportLevel.FATAL);
    }

    private void traverseAndAppend(String time, String message, ReportLevel reportLevel) {
        for (Appender appender : this.appenders) {
            appender.append(time, message, reportLevel);
        }
    }
}
