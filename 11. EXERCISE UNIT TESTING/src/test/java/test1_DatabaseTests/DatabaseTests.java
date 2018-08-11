package test1_DatabaseTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repo.task1_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {

    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;
    private static final Integer NULL = null;
    private static final int ARRAY_CAPACITY = 16;

    private Database database;

    @Before
    public void getNewInstance() {
        this.database = new Database(FOUR, ZERO, TWO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfConstructorTakesOnlyIntegers() {
        new Database(null, null);
    }

    @Test
    public void checkIfFetchMethodReturnsArray() {
        Assert.assertTrue(this.database.fetch().getClass().isArray());
    }

    @Test
    public void testIfNumbersAreAddedCorrectly() {
        try {

            this.database.add(FIVE);

            Integer[] outputNums = this.database.fetch();
            StringBuilder outputStr = new StringBuilder();

            for (int i = 0; i < outputNums.length; i++) {
                if (outputNums[i] != null) {
                    outputStr.append(outputNums[i]).append(" ");
                }
            }

            Assert.assertEquals("4 0 2 5 ", outputStr.toString());

        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfLastNumbersIsAddedCorrectly() {
        try {

            for (int i = 0; i < 13; i++) {
                this.database.add(FIVE);
            }

            Integer[] outputNums = this.database.fetch();
            StringBuilder outputStr = new StringBuilder();

            for (int i = 0; i < outputNums.length; i++) {
                if (outputNums[i] != null) {
                    outputStr.append(outputNums[i]).append(" ");
                }
            }

            Assert.assertEquals("4 0 2 5 5 5 5 5 5 5 5 5 5 5 5 5 ", outputStr.toString());

        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfLastElementIsRemovedCorrectly() {
        try {

            this.database.remove();

            Integer[] outputNums = this.database.fetch();
            StringBuilder outputStr = new StringBuilder();

            for (int i = 0; i < outputNums.length; i++) {
                if (outputNums[i] != null) {
                    outputStr.append(outputNums[i]).append(" ");
                }
            }

            Assert.assertEquals("4 0 ", outputStr.toString());

        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfLastElementIsRemovedCorrectly2() {
        try {

            this.database.remove();
            this.database.remove();
            this.database.remove();

            Integer[] outputNums = this.database.fetch();
            StringBuilder outputStr = new StringBuilder();

            for (int i = 0; i < outputNums.length; i++) {
                if (outputNums[i] != null) {
                    outputStr.append(outputNums[i]).append(" ");
                }
            }

            Assert.assertEquals("", outputStr.toString().trim());

        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfElementIsAddedCorrectlyAfterRemovingAllElements() {
        try {

            this.database.remove();
            this.database.remove();
            this.database.remove();
            this.database.add(ZERO);

            Integer[] outputNums = this.database.fetch();
            StringBuilder outputStr = new StringBuilder();

            for (int i = 0; i < outputNums.length; i++) {
                if (outputNums[i] != null) {
                    outputStr.append(outputNums[i]).append(" ");
                }
            }

            Assert.assertEquals("0", outputStr.toString().trim());

        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfAddAndRemoveMethodsWorkCorrectlyTogether() {
        try {

            this.database.remove();
            this.database.add(ZERO);
            this.database.remove();
            this.database.add(FIVE);
            this.database.add(THREE);

            Integer[] outputNums = this.database.fetch();
            StringBuilder outputStr = new StringBuilder();

            for (int i = 0; i < outputNums.length; i++) {
                if (outputNums[i] != null) {
                    outputStr.append(outputNums[i]).append(" ");
                }
            }

            Assert.assertEquals("4 0 5 3 ", outputStr.toString());

        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkIfInitialArrayCapacityIsCorrect() {
        Assert.assertEquals(ARRAY_CAPACITY, this.database.fetch().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void checkIfExceptionIsThrownForNullArg() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void checkIfExceptionIsThrownWhenArrayIsFull() throws OperationNotSupportedException {
        for (int i = 0; i < 100; i++) {
            this.database.add(FIVE);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void checkIfExceptionIsThrownWhenTryToRemoveFromEmptyArray() throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
        this.database.remove();
        this.database.remove();
    }
}
