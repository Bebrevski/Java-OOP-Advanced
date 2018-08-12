package ExamArrPerGee.app.factory;

import ExamArrPerGee.app.constants.TargetableNames;
import ExamArrPerGee.app.contracts.Targetable;
import ExamArrPerGee.app.contracts.TargetableFactory;
import ExamArrPerGee.app.models.participants.Boss;
import ExamArrPerGee.app.models.participants.Necromancer;
import ExamArrPerGee.app.models.participants.Warrior;
import ExamArrPerGee.app.models.participants.Wizard;

public class TargetableFactoryImpl implements TargetableFactory {

    @Override
    public Targetable create(String name, String className) throws
            ClassNotFoundException {
        switch (className) {
        case TargetableNames.TARGETABLE_BOSS:
            return new Boss(name);
        case TargetableNames.TARGETABLE_WIZARD:
            return new Wizard(name);
        case TargetableNames.TARGETABLE_WARRIOR:
            return new Warrior(name);
        case TargetableNames.TARGETABLE_NECROMANCER:
            return new Necromancer(name);
        default:
            throw new ClassNotFoundException();
        }
    }
}
