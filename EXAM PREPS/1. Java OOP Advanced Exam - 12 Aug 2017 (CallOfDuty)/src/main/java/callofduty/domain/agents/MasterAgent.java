package callofduty.domain.agents;

import callofduty.interfaces.BountyAgent;

public class MasterAgent extends AbstractAgent implements BountyAgent {

    private static final Double INITIAL_BOUNTY = 0D;

    private Double bounty;

    public MasterAgent(String id, String name, Double rating) {
        super(id, name, rating);
        this.bounty = INITIAL_BOUNTY;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s\nBounty Earned: $%.2f"
                , super.toString()
                , this.bounty));

        return sb.toString();
    }
}
