package panzer.commands;

import panzer.annotations.Inject;
import panzer.contracts.Executable;
import panzer.contracts.Manager;

import java.util.Arrays;

public class BattleCommand implements Executable {

    @Inject
    private Manager manager;

    @Inject
    private String[] data;

    @Override
    public String execute() {
        return this.manager.battle(Arrays.asList(this.data));
    }
}
