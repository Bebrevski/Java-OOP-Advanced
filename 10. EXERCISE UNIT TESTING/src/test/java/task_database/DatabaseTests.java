package task_database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DatabaseTests {

    private static final int CAPACITY = 16;
    private static final int WRONG_CAPACITY = 17;
    private static final Integer[] TEST_ARRAY = new Integer[]{1, 2, 3};

    private Database database;

    @Before
    public void initializeDatabase() {
        try {
            this.database = new Database();
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void databaseHasCorrectCapacity() {
        //Arrange
        Field field = null;
        try {
            field = this.database.getClass().getDeclaredField("database");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            System.out.println(e.getMessage());
        }
        //Act
        Integer[] arr = null;
        try {
            arr = (Integer[]) field.get(this.database);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        //Assert
        int expected = CAPACITY;
        assert arr != null;
        int actual = arr.length;

        Assert.assertEquals("Wrong capacity!", expected, actual);

        field.setAccessible(false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void databaseThrowExceptionIfCapacityIsIncorrect() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //Arrange
        Method setDatabase = Database.class.getDeclaredMethod("setDatabase", Integer[].class);
        Field databaseField = this.database.getClass().getDeclaredField("database");
        setDatabase.setAccessible(true);
        databaseField.setAccessible(true);

        //Act
        databaseField.set(this.database, new Integer[WRONG_CAPACITY]);
        setDatabase.invoke(this.database, TEST_ARRAY);
        setDatabase.setAccessible(false);
        setDatabase.setAccessible(false);

        //Assert
    }
}
