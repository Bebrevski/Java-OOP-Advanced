package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class RetireCommand extends BaseCommand {

    public RetireCommand(String[] data, UnitFactory unitFactory, Repository repository) {
        super(data, unitFactory, repository);
    }

    @Override
    public String execute()  {
        String unitType = super.getData()[1];

        try {
            super.getRepository().removeUnit(unitType);
            return unitType + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
