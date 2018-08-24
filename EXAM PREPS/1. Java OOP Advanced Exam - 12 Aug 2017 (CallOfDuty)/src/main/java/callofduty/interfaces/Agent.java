package callofduty.interfaces;

public interface Agent extends Identifiable, Nameable, Rateable {
    void acceptMission(Mission mission);

    void completeMissions();
}
