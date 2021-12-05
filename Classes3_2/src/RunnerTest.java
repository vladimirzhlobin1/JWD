import by.gsu.epamlab.Format;
import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.WeekDay;
import org.junit.Assert;
import org.junit.Test;


public class RunnerTest {
    @Test
    public void testGetCost() {
        Purchase p1 = new Purchase(WeekDay.SUNDAY, 2, 5.00);
        Assert.assertEquals(1500, p1.getCost());
        Purchase p2 = new Purchase(WeekDay.MONDAY, 4, 1);
        Assert.assertEquals(3000, p2.getCost());
    }
    @Test
    public void testConstructors() {
        Purchase p1 = new Purchase(1,2,12.00);
        Purchase p2 = new Purchase(WeekDay.MONDAY,2,12.00);
        Assert.assertEquals(p1.toString(),p2.toString());
        Purchase p3 = new Purchase(5,0,25.12);
        Purchase p4 = new Purchase(WeekDay.FRIDAY, 0,25.12);
        Assert.assertEquals(p3.toString(),p4.toString());

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
    @Test (expected = ArrayIndexOutOfBoundsException.class )
    public void irregularNumberINDayID ( ) {
        Purchase p1 = new Purchase(12,2,5.00);
        Purchase p2 = new Purchase(-1,2,5.00);
    }
    @Test
    public void testPurchaseInit() {
        Purchase p3 = new Purchase(WeekDay.MONDAY, 79, 15.0);
        Assert.assertEquals(p3.toString(), "79;15.0;monday;517.00");
    }
}