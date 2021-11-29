package by.gsu.epamlab;

import org.junit.Assert;
import org.junit.Test;

public class RunnerTest {
    @Test
    public void testGetCost() {
        Purchase p1 = new Purchase(WeekDay.SUNDAY, 2, 5.00);
        Assert.assertNotSame(7600, p1.getCost());
        Purchase p2 = new Purchase(WeekDay.MONDAY, 2, 4.00);
        Assert.assertNotSame(4254, p2.getCost());
    }

    @Test
    public void testToByn() {
        Assert.assertEquals("2.05", Format.format(205));
    }

    @Test
    public void testPurchaseInit() {
        Purchase p3 = new Purchase(WeekDay.MONDAY, 79, 15.0);
        Assert.assertEquals(p3.toString(), "79;monday;517.00;15.0");
    }
}

