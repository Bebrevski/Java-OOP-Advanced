package callofduty.commands;

import callofduty.annotations.Inject;
import callofduty.interfaces.Executable;
import callofduty.interfaces.MissionManager;

import java.util.Arrays;

public class StatusCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private MissionManager missionManager;

    @Override
    public String execute() {
        return this.missionManager.status(Arrays.asList(this.data));
    }
}
