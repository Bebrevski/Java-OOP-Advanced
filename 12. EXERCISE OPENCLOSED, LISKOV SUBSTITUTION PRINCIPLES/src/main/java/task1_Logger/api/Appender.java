package task1_Logger.api;

import task1_Logger.enums.ReportLevel;

public interface Appender {

    void append(String time, String message, ReportLevel reportLevel);

    void setReportLevel(ReportLevel reportLevel);
}
