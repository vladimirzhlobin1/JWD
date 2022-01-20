package Inheritance2;

import java.util.Arrays;
public class Runner {
    public static void main(String[] args) {
        final Product JUICE = new Product("JUICE", new Byn(500));
        AbstractPurchase[] purchases = new  AbstractPurchase[]{
                new TransportWithPurchase(JUICE, 1, new Byn(2)),
                new TransportWithPurchase(JUICE, 2, new Byn(10)),
                new PercentDiscountPurchase(JUICE, 1, 15),
                new PercentDiscountPurchase(JUICE, 2, 15),
                new PriceDiscountPurchase(JUICE, 1, new Byn(20)),
                new PriceDiscountPurchase(JUICE, 1, new Byn(15)),
        };
        printPurchases(purchases);
        System.out.println("Sorting from max to min.................");
        Arrays.sort(purchases);
        printPurchases(purchases);
        System.out.println("Minimum cost is = " + purchases[purchases.length - 1]);
        intSearch(purchases);
    }
    private static void printPurchases(AbstractPurchase[] purchases) {
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }}
    private static void intSearch(AbstractPurchase[] purchases) {
        int index = Arrays.binarySearch(purchases, new TransportWithPurchase(
                new Product("JUICE", new Byn(500)), 100, new Byn(1)));
        if (index < 0) {
            System.out.println("Required purchase is not found");
        } else {
            System.out.println("Required purchase is " + purchases[index]);
        }}
}