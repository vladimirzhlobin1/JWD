package by.gsu.epamlab;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestRunner {

    @Test
    public void testGetcostOfObject() {
        Byn byn = new Byn(454);
        Byn byn1 = new Byn(1816);
        Purchases p1 = new Purchases("Bread", byn, 4);
        System.out.println(p1);
        Assert.assertEquals("Bread", byn1, p1.getCost());
    }

    @Test
    public void testEqualsObject() {
        Byn byn = new Byn(454);
        Byn byn2 = new Byn(454);
        assertEquals(byn, byn2);
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void testMethodEquals() {
        Byn byn1 = new Byn(1816);
        Purchases p1 = new Purchases("Bread", byn1, 4);
        Byn byn2 = new Byn(1816);
        Purchases p2 = new Purchases("Bread", byn2, 4);
        equals(p1.equals(p2));
    }

    public void testPurchasesGet() {
        DiscountPurchases dis = new DiscountPurchases();
        Assert.
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void irregularNumberID() {
        Purchases p1 = new Purchases();
        Purchases p2 = new Purchases();
    }
}
/*@Test 
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
*/