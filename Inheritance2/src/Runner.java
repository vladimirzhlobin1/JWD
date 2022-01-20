import java.util.Arrays;
public class Runner {
    public static void main(String[] args) {
        final Product JUICE = new Product("JUICE", new Byn(500));
        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new TransportWithPurchase(JUICE, 100, 2),
                new TransportWithPurchase(JUICE, 200, 10),
                new PercentDiscountPurchase(JUICE, 100, 15),
                new PercentDiscountPurchase(JUICE, 200, 15),
                new PriceDiscountPurchase(JUICE, 100, 20),
                new PriceDiscountPurchase(JUICE, 100, 20),
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
                new Product("JUICE", new Byn(500)), 100, 0));
        if (index < 0) {
            System.out.println("Required purchase is not found");
        } else {
            System.out.println("Required purchase is " + purchases[index]);
        }}
}