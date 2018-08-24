package task1_Logger.impl.аppenders;

import task1_Logger.api.File;
import task1_Logger.api.Layout;
import task1_Logger.enums.ReportLevel;
import task1_Logger.file.LogFile;

public class FileAppender extends BaseAppender {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, File file) {
        this(layout);
        this.file = file;
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (super.getReportLevel().ordinal() <= reportLevel.ordinal()) {
            String log = this.getLayout().format(time, message, reportLevel.name());
            this.messages++;
            this.file.write(log);
        }
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type:" +
                        " %s, Report level: %s, Messages appended: %d, File size: %d", this.getClass().getSimpleName(),
                super.getLayout().getClass().getSimpleName(),
                super.getReportLevel().name(), this.messages,
                this.file.size());
    }
}
