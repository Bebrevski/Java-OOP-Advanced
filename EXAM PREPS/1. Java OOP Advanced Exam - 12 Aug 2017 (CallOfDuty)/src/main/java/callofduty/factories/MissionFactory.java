package callofduty.factories;

import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;

public final class MissionFactory {
    private MissionFactory() {
    }

    public static Mission createMission(
            MissionControl missionControl,
            String id,
            Double ration,
            Double bounty){

        return missionControl.generateMission(id, ration, bounty);
    }
}
