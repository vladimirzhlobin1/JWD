package Inheritance2;

import org.junit.Assert;
import org.junit.Test;

public class TestRunner {
    @Test
    public void testByn() {
        Byn byn1 = new Byn();
        Assert.assertEquals(byn1, new Byn(0));
        byn1.add(new Byn(200)).mul(4).sub(new Byn(40)).add(new Byn(80));
        Assert.assertEquals(byn1, new Byn(840));
    }

}
