package task1_Logger.impl.layouts;

import task1_Logger.api.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String time, String message, String level) {
        return time + " - " + level + " - " + message;
    }
}
