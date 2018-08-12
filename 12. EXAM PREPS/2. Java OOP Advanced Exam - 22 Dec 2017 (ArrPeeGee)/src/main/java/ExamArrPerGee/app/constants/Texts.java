package ExamArrPerGee.app.constants;

public final class Texts {

    public static final String ACTION_DOES_NOT_EXIST = "Action does not exist.";
    public static final String PARTICIPANT_IS_NOT_FOUND = "%s is not on the battlefield. %s failed.";
    public static final String BOSS_NOT_FOUND = "Invalid boss.";
    public static final String PARTICIPANT_ALREADY_EXISTS = "Participant with that name already exists.";
    public static final String PARTICIPANT_CREATED = "%s %s entered the battlefield.";
    public static final String INVALID_PARTICIPANT_CLASS = "Participant class does not exist.";
    public static final String NO_PARTICIPANTS_FOUND = "There are no participants on the battlefield.";
    public static final String PARTICIPANTS_LINE_SEPARATOR = "* * * * * * * * * * * * * * * * * * * *";
    public static final String NO_ACTIONS_FOUND = "There are no actions on the battlefield.";
    public static final String PARTICIPANT_REMOVED = "%s has been removed from the battlefield.";
    public static final String INVALID_COMMAND = "Invalid command";
    public static final String HERO_IS_VICTORIOUS = "%s is victorious!%n%s";
    public static final String INVALID_PARTICIPANTS_FOR_ONE_VS_ONE = "There should be exactly 2 participants for OneVsOne!";
    public static final String INVALID_PARTICIPANTS_FOR_BOSS_FIGHT = "There should be at least 1 participant for boss fight!";
    public static final String BOSS_HAS_BEEN_SLAIN = "Boss has been slain by:";
    public static final String BOSS_HAS_SLAIN_THEM_ALL = "Boss has slain them all!";
    public static final String DEAD_CANNOT_ATTACK = "%s is dead! Cannot attack.";
    public static final String DEAD_CANNOT_BE_ATTACKED = "%s is dead! Cannot be attacked.";
    public static final String TARGETABLE_ATTACKS = "%s attacked!";
    public static final String TARGETABLE_HAS_BEEN_SLAIN = " %s has been slain by %s.%n";
    public static final String TARGETABLE_NAME_AND_CLASS = "  Name: %s | Class: %s%n";
    public static final String TARGETABLE_HEALTH_AND_DAMAGE = "  Health: %.2f | Damage: %.2f";
    public static final String HERO_STATS = "%n  %d STR | %d DEX | %d INT | %.2f Gold";
    public static final String BOSS_STATS = " | Gold: %.2f";    //" | %.2f Gold";
    public static final String SPECIALTY_HEAL = "Heal";
    public static final String SPECIALTY_TOUGHNESS = "Toughness";
    public static final String SPECIALTY_SWIFTNESS = "Swiftness";

    private Texts() {
    }
}
