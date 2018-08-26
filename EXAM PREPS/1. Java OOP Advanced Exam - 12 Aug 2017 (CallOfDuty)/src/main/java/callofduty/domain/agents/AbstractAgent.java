package callofduty.domain.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAgent implements Agent {

    private String id;
    private String name;
    private Double rating;
    private List<Mission> completedMissions;
    private List<Mission> notCompletedMissions;

    protected AbstractAgent(String id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.completedMissions = new ArrayList<>();
        this.notCompletedMissions = new ArrayList<>();
    }

    @Override
    public void acceptMission(Mission mission) {
        this.notCompletedMissions.add(mission);
    }

    @Override
    public void completeMissions() {
        while (!notCompletedMissions.isEmpty()) {
            Mission currentMission = notCompletedMissions.remove(0);

            this.rating += currentMission.getRating();

            if (this instanceof MasterAgent) {
                try {
                    Field bountyField = this.getClass().getDeclaredField("bounty");
                    bountyField.setAccessible(true);

                    bountyField.set(this, (Double) bountyField.get(this) + currentMission.getBounty());

                    bountyField.setAccessible(false);

                    //Maybe needs to add mission in MasterAgent
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    System.out.println("ERROR....AbstractAgent line 50");
                }
            }

            this.completedMissions.add(currentMission);
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("%s Agent - %s"
                        , this.getClass().getSimpleName().replace("Agent", "")
                        , this.name))
                .append(System.lineSeparator())
                .append(String.format("Personal Code: %s", this.id))
                .append(System.lineSeparator())
                .append(String.format("Assigned Missions: %d"
                        , this.notCompletedMissions.size()))
                .append(System.lineSeparator())
                .append(String.format("Completed Missions: %d"
                        , this.completedMissions.size()))
                .append(System.lineSeparator())
                .append(String.format("Rating: %.2f", this.rating));

        return sb.toString();
    }
}
