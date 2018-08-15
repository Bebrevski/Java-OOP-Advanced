package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public abstract class BaseCommand implements Executable {

    private String[] data;

    private UnitFactory unitFactory;

    private Repository repository;

    public BaseCommand(String[] data, UnitFactory unitFactory, Repository repository) {
        this.data = data;
        this.unitFactory = unitFactory;
        this.repository = repository;
    }

    public String[] getData() {
        return this.data;
    }

    public UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

    public Repository getRepository() {
        return this.repository;
    }
}
