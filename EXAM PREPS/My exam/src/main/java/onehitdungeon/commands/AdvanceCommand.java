package onehitdungeon.commands;
import onehitdungeon.annotations.Inject;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.Executable;

import java.util.Arrays;

public class AdvanceCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private DungeonManager manager;

    @Override
    public String execute() {
     return this.manager.advance(Arrays.asList(this.data));
    }
}
