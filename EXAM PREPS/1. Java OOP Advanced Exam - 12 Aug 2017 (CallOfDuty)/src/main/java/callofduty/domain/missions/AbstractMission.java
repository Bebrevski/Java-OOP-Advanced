package callofduty.domain.missions;

import callofduty.interfaces.Mission;

public abstract class AbstractMission implements Mission {

    private String id;
    private Double rating;
    private Double bounty;

    private boolean status;

    protected AbstractMission(String id, Double rating, Double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }
}
