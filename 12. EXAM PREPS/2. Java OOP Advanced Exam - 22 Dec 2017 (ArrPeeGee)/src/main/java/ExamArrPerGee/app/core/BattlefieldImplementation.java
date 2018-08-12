package ExamArrPerGee.app.core;

import ExamArrPerGee.app.constants.ActionNames;
import ExamArrPerGee.app.constants.Texts;
import ExamArrPerGee.app.contracts.*;
import ExamArrPerGee.app.factory.BaseStructureFactory;
import ExamArrPerGee.app.models.participants.Boss;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class BattlefieldImplementation implements Battlefield {

    private Writer writer;
    private TargetableFactory targetableFactory;
    private ActionFactory actionFactory;
    private SpecialityFactory specialityFactory;
    private Map<String, Targetable> participants;
    private List<Action> executedActions;

    public BattlefieldImplementation(Writer writer, TargetableFactory targetableFactory, ActionFactory actionFactory, SpecialityFactory specialityFactory) {
        this.executedActions = BaseStructureFactory.createActionsList();
        this.participants = BaseStructureFactory.createParticipantsMap();
        this.writer = writer;
        this.targetableFactory = targetableFactory;
        this.actionFactory = actionFactory;
        this.specialityFactory = specialityFactory;
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        Action action;
        try {
            action = this.actionFactory.create(actionName);
        } catch (ClassNotFoundException e) {
            this.writer.writeLine(Texts.ACTION_DOES_NOT_EXIST);
            return;
        }

        List<Targetable> actionParticipants = BaseStructureFactory.createTargetableList();
        for (String name : participantNames) {
            if (this.participants.containsKey(name)) {
                actionParticipants.add(this.participants.get(name));
            } else {
                this.writer.writeLine(String.format(Texts.PARTICIPANT_IS_NOT_FOUND, name, actionName));
                return;
            }
        }

        if (actionName.equals(ActionNames.ACTION_BOSS_FIGHT) && !actionParticipants.isEmpty()) {
            if (!(actionParticipants.get(0) instanceof Boss)) {
                this.writer.writeLine(Texts.BOSS_NOT_FOUND);
                return;
            }
        }

        if (action != null) {
            this.writer.writeLine(action.executeAction(actionParticipants));
            checkForDeadParticipants();
            this.executedActions.add(action);
        }
    }

    @Override
    public void createParticipant(String name, String className) {
        if (this.participants.containsKey(name)) {
            this.writer.writeLine(Texts.PARTICIPANT_ALREADY_EXISTS);
            return;
        }

        try {
            Targetable targetable = this.targetableFactory.create(name, className);
            this.participants.put(targetable.getName(), targetable);
            this.writer.writeLine(
                    String.format(Texts.PARTICIPANT_CREATED,
                            targetable.getClass().getSimpleName(),
                            targetable.getName()));
        } catch (ClassNotFoundException e) {
            this.writer.writeLine(Texts.INVALID_PARTICIPANT_CLASS);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createSpecial(String name, String specialName) {
        if (this.participants.containsKey(name) &&
                this.participants.get(name) instanceof SuperHero) {
            try {
                Specialty speciality = specialityFactory.create(specialName);
                ((SuperHero) this.participants.get(name)).addSpecialty(speciality);
            } catch (ClassNotFoundException e) {

            }
        }
    }

    @Override
    public void reportParticipants() {
        if (this.participants.size() < 1) {
            this.writer.writeLine(Texts.NO_PARTICIPANTS_FOUND);
            return;
        }

        for (String name : this.participants.keySet()) {
            this.writer.writeLine(this.participants.get(name).toString());
            this.writer.writeLine(Texts.PARTICIPANTS_LINE_SEPARATOR);
        }
    }

    @Override
    public void reportActions() {
        if (this.executedActions.size() < 1) {
            this.writer.writeLine(Texts.NO_ACTIONS_FOUND);
            return;
        }

        for (Action executedAction : executedActions) {
            this.writer.writeLine(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants() {
        Map<String, Targetable> aliveParticipants = BaseStructureFactory.createParticipantsMap();

        for (String name : this.participants.keySet()) {
            if (!this.participants.get(name).isAlive()) {
                this.writer.writeLine(String.format(Texts.PARTICIPANT_REMOVED, name));
            } else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}
