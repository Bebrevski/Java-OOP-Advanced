package ExamArrPerGee.app.factory;

import ExamArrPerGee.app.constants.ActionNames;
import ExamArrPerGee.app.contracts.Action;
import ExamArrPerGee.app.contracts.ActionFactory;
import ExamArrPerGee.app.models.actions.BossFight;
import ExamArrPerGee.app.models.actions.OneVsOne;

public class ActionFactoryImpl implements ActionFactory {

    @Override
    public Action create(String actionName) throws ClassNotFoundException {
        switch (actionName) {
        case ActionNames.ACTION_ONE_VS_ONE:
            return new OneVsOne();
        case ActionNames.ACTION_BOSS_FIGHT:
            return new BossFight();
        default:
            throw new ClassNotFoundException();
        }
    }
}
