package by.epam.lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(new FileReader("in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = 6;
            Purchase purchases[] = new Purchase[PURCHASES_NUMBER];
            int maxElement = 0;
            Byn maxCost = new Byn();
            boolean elementEqual = true;
            int lenhth = purchases.length;
            for (int i = 0; i < lenhth; i++) {
                purchases[i] = PurchasesGet.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);
                Byn cost = purchases[i].getCost();
                if (maxCost.compareTo(cost) < 0) {
                    maxCost = cost;
                    maxElement = i;
                }
                if (!purchases[i].equals(purchases[0])) {
                    elementEqual = false;
                }
            }
            System.out.println("The purchase with max cost: " + purchases[maxElement]);

            if (elementEqual) {
                System.out.println("All purchases are equal");
            } else {
                System.out.println("Not all purchases are equal");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
