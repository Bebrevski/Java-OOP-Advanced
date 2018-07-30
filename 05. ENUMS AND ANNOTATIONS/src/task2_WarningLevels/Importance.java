package task2_WarningLevels;

public enum Importance {

    LOW, NORMAL, MEDIUM, HIGH;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
