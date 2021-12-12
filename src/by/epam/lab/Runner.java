package by.epam.lab;

import by.epam.lab.Purchases;
import by.epam.lab.PurchasesGet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        final String FILE_PATH = "in.txt";

        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(FILE_PATH));
            sc.useLocale(Locale.ENGLISH);
            Purchases[] purchases = new Purchases[6];
            int maxElement = 0;
            int maxCost = 0;
            boolean elementEqual = true;
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesGet.getPurchase(sc);
                System.out.println(purchases[i]);
                int cost = purchases[i].getCost().getcostOfObject();
                if (maxCost < cost) {
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
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}