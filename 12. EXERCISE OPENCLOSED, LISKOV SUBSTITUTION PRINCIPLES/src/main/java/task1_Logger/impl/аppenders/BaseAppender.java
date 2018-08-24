package task1_Logger.impl.аppenders;

import task1_Logger.api.Appender;
import task1_Logger.api.Layout;
import task1_Logger.enums.ReportLevel;

public abstract class BaseAppender implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    protected int messages;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        if (reportLevel != null) {
            this.reportLevel = reportLevel;
        }
    }

    protected ReportLevel getReportLevel() {
        return this.reportLevel;
    }
}
