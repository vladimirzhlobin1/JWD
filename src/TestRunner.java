package by.epam.lab;

import by.epam.lab.Byn;
import by.epam.lab.DiscountPurchases;
import by.epam.lab.Purchase;
import by.epam.lab.PurchasesGet;
import by.epam.lab.QuantityDiscountPurchases;
import by.epam.lab.Runner;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

import org.junit.*;

public class TestRunner {

    @Test
    public void testBynMethodsAndConstructors() {
        Byn expectedByn = new Byn(420);
        Byn byn1 = new Byn(expectedByn);
        Assert.assertEquals(byn1, expectedByn);
        Byn expectedByn2 = new Byn(840);
        Byn byn2 = new Byn(expectedByn2);
        Assert.assertEquals(byn2, expectedByn2);
    }

    public Byn mainTest(Byn byn) {
        byn.add(new Byn(200)).mul(4).sub(new Byn(40)).add(new Byn(80));
        return byn;

    }

    @Test
    public void testGetCostOfObject() {
        Byn byn = new Byn(454);
        Byn byn1 = new Byn(1816);
        Purchase p1 = new Purchase("Bread", byn, 4);
        Assert.assertEquals("Bread", byn1, p1.getCost());
    }

    @Test
    public void testGetCost() {
        Purchase purchases = new Purchase("Milk", new Byn(140), 4);
        Assert.assertEquals(new Byn(560), purchases.getCost());
        purchases.getCost().mul(4);
        Assert.assertEquals(new Byn(560), purchases.getCost());
    }

    @Test
    public void testEqualsObject() {
        Byn byn = new Byn(454);
        Byn byn2 = new Byn(454);
        assertEquals(byn, byn2);
    }

    public void testPurchaseGet() {
        Purchase expectedPurchases = new Purchase("Milk", new Byn(140), 3);
        Purchase purchase = mainPurchaseGetTest(new Purchase());
        Assert.assertEquals(purchase, expectedPurchases);
    }

    public Purchase mainPurchaseGetTest(Purchase p) {
        try (Scanner sc = new Scanner(new FileReader("in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            p = PurchasesGet.getPurchaseFromFactory(sc);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
        return p;
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void testMethodEquals() {
        Byn byn1 = new Byn(1816);
        Purchase p1 = new Purchase("Bread", byn1, 4);
        Byn byn2 = new Byn(1816);
        Purchase p2 = new Purchase("Bread", byn2, 4);
        Assert.assertEquals(p1, p2);
    }

}