package onehitdungeon.commands;
import onehitdungeon.annotations.Inject;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.Executable;

import java.util.Arrays;

public class FightCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private DungeonManager manager;

    @Override
    public String execute() {
     return this.manager.fight(Arrays.asList(this.data));
    }
}
