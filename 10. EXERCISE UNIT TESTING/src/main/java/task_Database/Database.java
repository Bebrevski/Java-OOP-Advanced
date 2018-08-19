package task_Database;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Database {

    private static final int CAPACITY = 16;
    private static final int INDEX_START_VALUE = 0;

    private Integer[] database;
    private int index;

    public Database() throws OperationNotSupportedException {
        this.index = INDEX_START_VALUE;

        setDatabase();
    }

    public Database(Integer... elements) throws OperationNotSupportedException {
        this.index = INDEX_START_VALUE;

        setDatabase(elements);
    }

    public void add(Integer element) throws OperationNotSupportedException {

        validateElement(element);

        this.database[index++] = element;
    }

    public Integer remove() throws OperationNotSupportedException {

        if (this.index == 0) {
            throw new OperationNotSupportedException("Collection is empty!");
        }

        return this.database[--this.index];
    }

    public Integer[] fetch() {
        return Arrays.copyOf(this.database, this.index);
    }

    private void setDatabase(Integer... elements) throws OperationNotSupportedException {

        this.database = new Integer[CAPACITY];

        if (this.database.length != CAPACITY) {
            throw new OperationNotSupportedException("Invalid capacity!");
        }

        for (Integer element : elements) {

            validateElement(element);

            this.database[index++] = element;
        }
    }

    private void validateElement(Integer element) throws OperationNotSupportedException {

        if (element == null) {
            throw new OperationNotSupportedException("Element can not be null!");
        }

        if (this.index >= CAPACITY) {
            throw new OperationNotSupportedException("Collection is full!");
        }
    }
}
