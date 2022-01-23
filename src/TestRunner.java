import Inheritance2.*;
import org.junit.Assert;
import org.junit.Test;

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
        final int UNSUCCESSFUL = -1;
        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new TransportWithPurchase(new Product("Juice", new Byn(2)), 1, new Byn(2)),
                new TransportWithPurchase(new Product("Juice", new Byn(3)), 2, new Byn(1))};
        Assert.assertEquals(UNSUCCESSFUL, Runner.intSearch(purchases, new TransportWithPurchase(
                new Product("JUICE", new Byn(500)), 1, new Byn(1))));
    }

}
