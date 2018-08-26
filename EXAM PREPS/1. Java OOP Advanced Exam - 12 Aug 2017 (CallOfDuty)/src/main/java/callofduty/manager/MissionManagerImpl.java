package callofduty.manager;

import callofduty.core.MissionControlImpl;
import callofduty.factories.AgentFactory;
import callofduty.factories.MissionFactory;
import callofduty.interfaces.*;
import callofduty.domain.agents.AbstractAgent;
import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MissionManagerImpl implements MissionManager {

    private Map<String, Agent> agents;
    private Map<String, Mission> missions;
    private MissionControl missionControl;

    public MissionManagerImpl() {
        this.agents = new LinkedHashMap<>();
        this.missions = new LinkedHashMap<>();
        this.missionControl = new MissionControlImpl();
    }

    @Override
    public String agent(List<String> arguments) {
        String id = arguments.get(1);
        String name = arguments.get(2);

        Agent agent = AgentFactory.createAgent(id, name);

        this.agents.put(id, agent);

        return String.format("Registered Agent - %s:%s", name, id);
    }

    @Override
    public String request(List<String> arguments) {
        String agentId = arguments.get(1);
        String missionId = arguments.get(2);
        Double missionRating = Double.parseDouble(arguments.get(3));
        Double missionBounty = Double.parseDouble(arguments.get(4));

        Mission mission = MissionFactory.createMission(this.missionControl, missionId, missionRating, missionBounty);
        this.missions.put(mission.getId(), mission);

        Agent agent = this.agents.get(agentId);

        agent.acceptMission(mission);

        return String.format("Assigned %s Mission - %s to Agent - %s"
                , mission.getClass().getSimpleName().replace("Mission", "")
                , mission.getId()
                , agent.getName());
    }

    @Override
    public String complete(List<String> arguments) {
        String agentId = arguments.get(1);

        Agent agent = this.agents.get(agentId);

        agent.completeMissions();

        if (agent instanceof NoviceAgent) {
            try {

                Field completedMissionField = AbstractAgent.class.getDeclaredField("completedMissions");
                completedMissionField.setAccessible(true);

                Field notCompletedMissionField = AbstractAgent.class.getDeclaredField("notCompletedMissions");
                notCompletedMissionField.setAccessible(true);

                List<Mission> completedMissions = (List<Mission>) completedMissionField.get(agent);
                List<Mission> notCompletedMissions = (List<Mission>) notCompletedMissionField.get(agent);

                if (completedMissions.size() >= 3) {
                    BountyAgent newMasterAgent = new MasterAgent(agent.getId(), agent.getName(), agent.getRating());

                    completedMissionField.set(newMasterAgent, completedMissions);
                    notCompletedMissionField.set(newMasterAgent, notCompletedMissions);

                    this.agents.put(agentId, newMasterAgent);
                }

                completedMissionField.setAccessible(false);
                notCompletedMissionField.setAccessible(false);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println("ERROR....MissionManagerImpl line 72");
            }
        }

        return String.format("Agent - %s:%s has completed all assigned missions."
                , agent.getName()
                , agent.getId());
    }

    @Override
    public String status(List<String> arguments) {
        String id = arguments.get(1);

        if (this.agents.containsKey(id)) {
            return this.agents.get(id).toString();
        }

        Mission mission = this.missions.get(id);
        boolean isOpen = true;

        for (Agent agent : agents.values()) {
            try {
                Field completedMissionsField = agent.getClass().getSuperclass().getDeclaredField("completedMissions");
                completedMissionsField.setAccessible(true);

                List<Mission> currentAgentMissions = (List<Mission>) completedMissionsField.get(agent);

                if (currentAgentMissions.contains(mission)) {
                    isOpen = false;
                    break;
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println("ERROR....MissionManagerImpl line 123");
            }
        }

        StringBuilder sb = new StringBuilder();
        sb
                .append(String.format("%s Mission - %s"
                        , mission.getClass().getSimpleName()
                        , mission.getId()))
                .append(System.lineSeparator())
                .append(String.format("Status: %s", isOpen ? "Open" : "Completed"))
                .append(System.lineSeparator())
                .append(String.format("Rating: %.2f", mission.getRating()))
                .append(System.lineSeparator())
                .append(String.format("Bounty: %.2f", mission.getBounty()));

        return sb.toString();
    }

    @Override
    public String over(List<String> arguments) {
        return generateFinalOutput();
    }

    private Double getTotalBounty() {
        Double bounty = 0D;

        for (Agent agent : agents.values()) {
            if (agent instanceof MasterAgent) {
                bounty += ((MasterAgent) agent).getBounty();
            }
        }

        return bounty;
    }

    private Double getTotalRating() {
        Double rating = 0D;
        for (Agent agent : agents.values()) {
            rating += agent.getRating();
        }
        return rating;
    }

    private int getCompletedMissions() {
        int completedMissions = 0;
        for (Agent agent : agents.values()) {
            try {
                Field field = agent.getClass().getSuperclass().getDeclaredField("completedMissions");
                field.setAccessible(true);

                List<Mission> missions = (List<Mission>) field.get(agent);

                completedMissions += missions.size();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println("ERROR....MissionManagerImpl line 154");
            }
        }

        return completedMissions;
    }

    private String generateFinalOutput() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("Novice Agents: %d"
                        , this.agents
                                .values()
                                .stream()
                                .filter(a -> a.getClass().getSimpleName().equals("NoviceAgent")).count()))
                .append(System.lineSeparator())
                .append(String.format("Master Agents: %d"
                        , this.agents
                                .values()
                                .stream()
                                .filter(a -> a.getClass().getSimpleName().equals("MasterAgent")).count()))
                .append(System.lineSeparator())
                .append(String.format("Assigned Missions: %d", this.missions.size()))
                .append(System.lineSeparator())
                .append(String.format("Completed Missions: %d", getCompletedMissions()))
                .append(System.lineSeparator())
                .append(String.format("Total Rating Given: %.2f"
                        , getTotalRating()))
                .append(System.lineSeparator())
                .append(String.format("Total Bounty Given: $%.2f"
                        , getTotalBounty()));


        return sb.toString();
    }
}
