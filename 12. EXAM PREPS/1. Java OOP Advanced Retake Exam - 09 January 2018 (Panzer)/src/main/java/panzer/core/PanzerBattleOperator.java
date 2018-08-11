package panzer.core;

import panzer.contracts.BattleOperator;
import panzer.contracts.Vehicle;

public class PanzerBattleOperator implements BattleOperator {
    @Override
    public String battle(Vehicle attacker, Vehicle target) {
        double attackerWeight = attacker.getTotalWeight();
        long attackerAttack = attacker.getTotalAttack();
        long attackerDefense = attacker.getTotalDefense();
        long attackerHitPoints = attacker.getTotalHitPoints();

        double targetWeight = target.getTotalWeight();
        long targetAttack = target.getTotalAttack();
        long targetDefense = target.getTotalDefense();
        long targetHitPoints = target.getTotalHitPoints();

        boolean isAttackerTurn = true;
        boolean isSomeoneDead = isDead(attackerHitPoints) || isDead(targetHitPoints);

        while(!isSomeoneDead) {
            if(isAttackerTurn) {
                targetHitPoints -= (long)Math.max(0, Math.ceil(attackerAttack - (targetDefense + (targetWeight / 2))));
                isAttackerTurn = false;
            } else {
                attackerHitPoints -= (long)Math.max(0, Math.ceil(targetAttack - (attackerDefense + (attackerWeight / 2))));
                isAttackerTurn = true;
            }

            isSomeoneDead = isDead(attackerHitPoints) || isDead(targetHitPoints);
        }

        String result = null;

        if(isDead(attackerHitPoints)) {
            result = target.getModel();
        } else {
            result = attacker.getModel();
        }

        return result;
    }

    private boolean isDead(Long hitPoints) {
        return hitPoints <= 0;
    }
}
