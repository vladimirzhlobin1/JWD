package by.gsu.epamlab;
import org.junit.Assert;
import org.junit.Test;
public class RunnerTest {
    @Test
    public void testGetCost() {
        Purchase p1 = new Purchase(WeekDay.SUNDAY, 2, 5.00);
        Assert.assertEquals(1500, p1.getCost());
        Purchase p2 = new Purchase(WeekDay.MONDAY, 4, 1.00);
        Assert.assertEquals(3000, p2.getCost());
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

