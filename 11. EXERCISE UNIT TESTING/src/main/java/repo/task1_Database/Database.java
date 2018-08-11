package repo.task1_Database;

import javax.naming.OperationNotSupportedException;

public class Database {

    private static final int ARRAY_CAPACITY = 16;
    private static final int ZERO = 0;

    private Integer[] numbers;
    private int index;

    public Database(Integer... inputNumbers) {
        this.numbers = new Integer[ARRAY_CAPACITY];
        this.index = ZERO;

        setNumbers(inputNumbers);
    }

    public void add(Integer number) throws OperationNotSupportedException {
        if (index >= this.numbers.length) {
            throw new OperationNotSupportedException("Array is full!");
        }

        if (number == null) {
            throw new OperationNotSupportedException("Number can not be null!");
        }

        this.numbers[index++] = number;
    }

    public Integer remove() throws OperationNotSupportedException {
        if (this.index == 0 && this.numbers[0] == null) {
            throw new OperationNotSupportedException("Array is empty. Nothing to remove.");
        }

        Integer lastElement = this.numbers[--this.index];

        this.numbers[this.index] = null;

        return lastElement;
    }

    public Integer[] fetch() {
        return this.numbers;
    }

    private void setNumbers(Integer... inputNumbers) {
        for (int i = 0; i < inputNumbers.length; i++) {
            if (inputNumbers[i] != null) {
                this.numbers[i] = inputNumbers[i];
                this.index++;
            } else {
                throw new IllegalArgumentException("Argument must be Integer!");
            }
        }
    }
}
