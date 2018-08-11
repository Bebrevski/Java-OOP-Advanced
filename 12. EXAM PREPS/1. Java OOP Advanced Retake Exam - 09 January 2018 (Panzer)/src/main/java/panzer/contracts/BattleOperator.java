package panzer.contracts;

public interface BattleOperator {
    // Performs a turn-based battle between 2 Vehicles
    String battle(Vehicle attacker, Vehicle target);
}
