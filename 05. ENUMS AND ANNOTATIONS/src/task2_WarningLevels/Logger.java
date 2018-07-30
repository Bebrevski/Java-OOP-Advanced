package task2_WarningLevels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logger {

    private List<Message> messages;
    private Importance importanceLevel;

    public Logger(String importanceLevel) {
        this.importanceLevel = Enum.valueOf(Importance.class, importanceLevel.toUpperCase());
        this.messages = new ArrayList<>();
    }

    public void addMessage(String importance, String message) {
        Importance imp = Enum.valueOf(Importance.class, importance.toUpperCase());

        if(imp.compareTo(this.importanceLevel) >= 0) {
            this.messages.add(new Message(importance, message));
        }
    }

    public Iterable<Message> getMessages(){
        return Collections.unmodifiableList(this.messages);
    }
}
