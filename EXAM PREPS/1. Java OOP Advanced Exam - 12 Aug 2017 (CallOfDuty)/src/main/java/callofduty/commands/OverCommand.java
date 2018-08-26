package callofduty.commands;

import callofduty.annotations.Inject;
import callofduty.interfaces.Executable;
import callofduty.interfaces.MissionManager;

import java.util.Arrays;

public class OverCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private MissionManager missionManager;

    @Override
    public String execute() {
        return this.missionManager.over(Arrays.asList(this.data));
    }
}
