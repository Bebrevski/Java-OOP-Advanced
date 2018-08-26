package callofduty.domain.agents;

public class NoviceAgent extends AbstractAgent {

    private static final Double INITIAL_RATING = 0D;
    public NoviceAgent(String id, String name) {
        super(id, name, INITIAL_RATING);
    }
}
