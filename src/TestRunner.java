import Inheritance2.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestRunner {
    public void testByn(int value) {
        Byn byn1 = new Byn(value);
        Assert.assertEquals(byn1, new Byn(0));
        byn1.add(new Byn(200)).mul(4).sub(new Byn(40)).add(new Byn(80));
        Assert.assertEquals(byn1, new Byn(840));
    }

    @Test
    public void testGetCost() {
        TransportWithPurchase tr = new TransportWithPurchase
                (new Product("Oil", new Byn(3)), 1, new Byn(100));
        Assert.assertEquals(new Byn(100), tr.getCost());
        PriceDiscountPurchase pr = new PriceDiscountPurchase
                (new Product("Oil", new Byn(100)), 3, new Byn(2));
        Assert.assertEquals(new Byn(200), pr.getCost());
        PercentDiscountPurchase pd = new PercentDiscountPurchase
                (new Product("Oil", new Byn(5)), 100, 10.14);
        Assert.assertEquals(new Byn(500), pd.getCost());
    }

    @Test
    public void testSearch() {
        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new TransportWithPurchase(new Product("Juice", new Byn(20)), 1, new Byn(2)),
                new TransportWithPurchase(new Product("Juice", new Byn(150)), 7, new Byn(15)),
                new TransportWithPurchase(new Product("Juice", new Byn(50)), 2, new Byn(12)),
                new TransportWithPurchase(new Product("Juice", new Byn(60)), 4, new Byn(11)),
                new TransportWithPurchase(new Product("Juice", new Byn(70)), 1, new Byn(14))
        };
        Arrays.sort(purchases);
        Assert.assertEquals(3, Runner.intSearch(purchases, new TransportWithPurchase(
                new Product("Juice", new Byn(20)), 1, new Byn(2))));
        Assert.assertEquals(0, Runner.intSearch(purchases, new TransportWithPurchase(
                new Product("Juice", new Byn(150)), 7, new Byn(15))));
        Assert.assertEquals(2, Runner.intSearch(purchases, new TransportWithPurchase(
                new Product("Juice", new Byn(50)), 2, new Byn(12))));
    }

}
