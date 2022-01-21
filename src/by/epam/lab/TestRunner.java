package Inheritance2;

import org.junit.Assert;
import org.junit.Test;

public class TestRunner {
    @Test
    public void testByn(){
        Byn byn1 = new Byn();
        Assert.assertEquals(byn1,new Byn (0));
        byn1.add(new Byn(200)).mul(4).sub(new Byn(40)).add(new Byn(80));
        Assert.assertEquals(byn1,new Byn (840));
    }
    @Test
    public void testGetCost(){
        TransportWithPurchase tr = new TransportWithPurchase
                (new Product("Oil", new Byn(3)),1,new Byn(100));
        Byn byn1 = new Byn (tr.getCost());
        Assert.assertEquals(new Byn(100),byn1 );
        PriceDiscountPurchase pr = new PriceDiscountPurchase
                (new Product("Oil", new Byn(3)),1,new Byn(15));
        Byn byn2 = new Byn(pr.getCost());
        Assert.assertEquals(new Byn(1),byn2);
        PercentDiscountPurchase pd = new PercentDiscountPurchase
                (new Product("Oil", new Byn(5)), 1,1);
        Byn byn3 = new Byn(pd.getCost());
        Assert.assertEquals(new Byn(10),byn3 );
    }
    @Test
    public void testSearch() {

        Assert.assertEquals(2, Runner.intSearch(new AbstractPurchase[], new TransportWithPurchase
                (new Product("Oil", new Byn(3)), 1, new Byn(100))));
    }}