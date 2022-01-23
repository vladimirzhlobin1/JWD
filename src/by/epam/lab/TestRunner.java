package Inheritance2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestRunner {
    @Test
    public void testByn() {
        Byn byn1 = new Byn();
        Assert.assertEquals(byn1, new Byn(0));
        byn1.add(new Byn(200)).mul(4).sub(new Byn(40)).add(new Byn(80));
        Assert.assertEquals(byn1, new Byn(840));
    }

    @Test
    public void testGetCost() {
        TransportWithPurchase tr = new TransportWithPurchase
                (new Product("Oil", new Byn(3)), 1, new Byn(100));
        Byn byn1 = new Byn (tr.getCost());
        Assert.assertEquals(new Byn(100), byn1);
        PriceDiscountPurchase pr = new PriceDiscountPurchase
                (new Product("Oil", new Byn(3)), 1, new Byn(-100));
        Byn byn2 = new Byn(pr.getCost());
        Assert.assertEquals(new Byn(100), byn2);
        PercentDiscountPurchase pd = new PercentDiscountPurchase
                (new Product("Oil", new Byn(5)), 100, 10.14);
        Byn byn3 = new Byn(pd.getCost());
        Assert.assertEquals(new Byn(500), byn3);
    }

    @Test
    public void testSearch() {
        final int UNSUCCESSFUL = -1;
        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new TransportWithPurchase(new Product("Juice", new Byn(2)), 1, new Byn(2)),
                new TransportWithPurchase(new Product("Juice", new Byn(3)), 2, new Byn(1))};
        // int index = Arrays.binarySearch(purchases, new TransportWithPurchase(
        //   new Product("JUICE", new Byn(500)), 1, new Byn(1)));
        //Assert.assertEquals(UNSUCCESSFUL,index);
        Assert.assertEquals(UNSUCCESSFUL, Runner.intSearch(purchases));
    }

}
