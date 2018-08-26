package callofduty.domain.missions;

public class HuntMission extends AbstractMission {
    public HuntMission(String id, Double rating, Double bounty) {
        super(id, rating * 1.5, bounty * 2);
    }
}
