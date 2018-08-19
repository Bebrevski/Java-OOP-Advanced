package task3_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class ListIteratorTests {

    private ListIteratorImpl<String> listIterator;

    @Before
    public void initListIterator() {
        this.listIterator = new ListIteratorImpl<>("Pesho", "Gosho", "Stamat");
    }

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testMove_expectedToMoveByOne() throws OperationNotSupportedException {
        Assert.assertTrue(this.listIterator.move());

        Assert.assertEquals("Gosho", this.listIterator.print());
    }

    @Test
    public void testMove_expectedIndexToIncreaseByOne() throws NoSuchFieldException, IllegalAccessException {
        this.listIterator.move();
        Field indexField = ListIteratorImpl.class.getDeclaredField("index");
        indexField.setAccessible(true);
        Assert.assertEquals(1, indexField.get(this.listIterator));
    }

    @Test
    public void testHasNext_expectedTrue() {
        this.listIterator.move();
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void testHasNext_expectedFalse() {
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        Assert.assertFalse(this.listIterator.hasNext());
    }

    @Test
    public void testPrint_expectedLastString() throws OperationNotSupportedException {
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        Assert.assertEquals("Stamat", this.listIterator.print());
    }

    @Test
    public void testPrint_expectedException() throws OperationNotSupportedException {
        ListIterator<Integer> newList = new ListIteratorImpl<>();
        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("Invalid Operation!");
        newList.print();
    }
}
