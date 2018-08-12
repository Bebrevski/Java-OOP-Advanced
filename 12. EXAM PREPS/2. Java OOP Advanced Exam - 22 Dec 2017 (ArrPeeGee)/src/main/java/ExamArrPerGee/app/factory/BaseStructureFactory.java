package ExamArrPerGee.app.factory;

import ExamArrPerGee.app.contracts.Action;
import ExamArrPerGee.app.contracts.Targetable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BaseStructureFactory {

    public static BufferedReader createBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static Map<String, Targetable> createParticipantsMap() {
        return new TreeMap<>();
    }

    public static List<Action> createActionsList() {
        return new ArrayList<>();
    }

    public static List<Targetable> createTargetableList() {
        return new ArrayList<>();
    }

    public static StringBuilder createStringBuilder() {
        return new StringBuilder();
    }
}
