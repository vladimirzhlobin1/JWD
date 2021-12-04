package by.gsu.epamlab;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RunnerTest {
    @Test
    public void testGetCost() {
        Purchase p1 = new Purchase(WeekDay.SUNDAY, 2, 5.00);
        Assert.assertEquals(1500, p1.getCost());
        Purchase p2 = new Purchase(WeekDay.MONDAY, 4, 1);
        Assert.assertEquals(3000, p2.getCost());
    }

    @Test
    public void testToByn() {
        Assert.assertEquals("2.05", Format.format(205));
        Assert.assertEquals("3.05", Format.format(305));
        Assert.assertEquals("3.00", Format.format(300));
        Assert.assertEquals("2.05", Format.format(205));
        Assert.assertEquals("0.00", Format.format(0));
        Assert.assertEquals("1005.00", Format.format(100500));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void irregularNumberINDayID() {
        Purchase p1 = new Purchase(12, 2, 5.00);
        Purchase p2 = new Purchase(-1, 2, 5.00);
    }

    @Test
    public void testPurchaseInit() {
        Purchase p3 = new Purchase(WeekDay.MONDAY, 79, 15.0);
        Assert.assertEquals(p3.toString(), "79;15.0;monday;517.00");
    }
}
