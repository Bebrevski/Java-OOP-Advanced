package onehitdungeon.commands;
import onehitdungeon.annotations.Inject;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.Executable;

import java.util.Arrays;

public class QuitCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private DungeonManager manager;

    @Override
    public String execute() {
     return this.manager.quit(Arrays.asList(this.data));
    }
}
