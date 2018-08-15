package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class FightCommand extends BaseCommand {

    private static final String FIGHT = "fight";

    public FightCommand(String[] data, UnitFactory unitFactory, Repository repository) {
        super(data, unitFactory, repository);
    }

    @Override
    public String execute()  {
        return FIGHT;
    }
}
