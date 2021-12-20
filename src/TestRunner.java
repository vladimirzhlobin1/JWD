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

    @Test
    public void mainPurchaseGetTest() {
        String scannerLineGeneralPurchase = "GENERAL_PURCHASE Milk 140 3";
        Scanner sc1 = new Scanner(scannerLineGeneralPurchase);
        Purchase purchase = PurchasesGet.getPurchaseFromFactory(sc1);
        Assert.assertEquals(purchase,
                new Purchase("Milk", new Byn(140), 3));
        String scannerLineNumberDiscountPurchase = "PRICE_DISCOUNT_OF_PURCHASE Bread 140 9 34";
        Scanner sc2 = new Scanner(scannerLineNumberDiscountPurchase);
        Purchase discountPurchase = PurchasesGet.getPurchaseFromFactory(sc2);
        Assert.assertEquals(discountPurchase.toString(),
                new DiscountPurchases("Bread",
                        new Byn(140), 9, 34).toString());
    }

    @Test
    public void bynMethodTest() {
        Byn byn1 = new Byn();
        Assert.assertEquals(byn1, new Byn(0));
        byn1.add(new Byn(200)).mul(4).sub(new Byn(40)).add(new Byn(80));
        Assert.assertEquals(byn1, new Byn(840));
    }

    @Test
    public void testGetCostOfObject() {
        Byn byn = new Byn(454);
        Byn byn1 = new Byn(1816);
        Purchase p1 = new Purchase("Bread",byn,4);
        Assert.assertEquals(byn1, p1.getCost());
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

    @Test
    public void testMethodEquals() {
        Byn byn1 = new Byn(1816);
        Purchase p1 = new Purchase("Bread", byn1, 4);
        Byn byn2 = new Byn(1816);
        Purchase p2 = new Purchase("Bread", byn2, 4);
        Assert.assertEquals(p1, p2);
    }

}