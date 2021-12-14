package by.epam.lab;

import by.epam.lab.Byn;
import by.epam.lab.DiscountPurchases;
import by.epam.lab.Purchases;
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
        System.out.println(byn);
        return byn;

    }

    @Test
    public void testGetCostOfObject() {
        Byn byn = new Byn(454);
        Byn byn1 = new Byn(1816);
        Purchases p1 = new Purchases("Bread", byn, 4);
        Assert.assertEquals("Bread", byn1, p1.getCost());
    }

    @Test
    public void testEqualsObject() {
        Byn byn = new Byn(454);
        Byn byn2 = new Byn(454);
        assertEquals(byn, byn2);
    }

    public void testPurchaseGet() {
        Purchases expectedPurchases = new Purchases("Milk", new Byn(140), 3);
        Purchases purchase = mainPurchaseGetTest(new Purchases());
        Assert.assertEquals(purchase, expectedPurchases);
    }

    public Purchases mainPurchaseGetTest(Purchases p) {
        try (Scanner sc = new Scanner(new FileReader("in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            p = PurchasesGet.getPurchase(sc);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
        return p;
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void testMethodEquals() {
        Byn byn1 = new Byn(1816);
        Purchases p1 = new Purchases("Bread", byn1, 4);
        Byn byn2 = new Byn(1816);
        Purchases p2 = new Purchases("Bread", byn2, 4);
        Assert.assertEquals(p1, p2);
    }

}