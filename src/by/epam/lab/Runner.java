package by.epam.lab;

import by.epam.lab.Purchases;
import by.epam.lab.PurchasesGet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(new FileReader("in.txt"))){
            sc.useLocale(Locale.ENGLISH);
            Purchases[] purchases = new Purchases[6];
            int maxElement=0;
            int maxCost = 0;
            boolean elementEqual = true;
            int lENGTH = purchases.length;
            for (int i = 0; i < lENGTH; i++) {
                purchases[i] = PurchasesGet.getPurchase(sc);
                System.out.println(purchases[i]);
                int cost = purchases[i].getCost().costOfObject;
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
        }
    }
}
