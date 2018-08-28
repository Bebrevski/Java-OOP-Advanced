package panzer.commands;

import panzer.annotations.Inject;
import panzer.contracts.Executable;
import panzer.contracts.Manager;

import java.util.Arrays;

public class PartCommand implements Executable {

    @Inject
    private Manager manager;

    @Inject
    private String[] data;

    @Override
    public String execute() {
        return this.manager.addPart(Arrays.asList(this.data));
    }
}
