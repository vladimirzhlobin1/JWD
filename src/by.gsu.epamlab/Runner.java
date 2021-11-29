package by.gsu.epamlab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import by.gsu.epamlab.Format;
public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/purchases.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                int days = sc.nextInt();
                int number = sc.nextInt();
                double discount = sc.nextDouble();
                WeekDay WDay = WeekDay.values()[days];
                purchases[i] = new Purchase(WDay, number, discount);
            }
            lookArray(purchases);
            double averageCost = 0.00;
            int mondayCost = 0;
            String maxday = null;
            for (Purchase purchase : purchases) {
                averageCost += purchase.getCost();
                if (purchase.getWeekDay() == WeekDay.MONDAY) {
                    mondayCost += purchase.getCost();
                }
                int maxPurchase = 0;
                if (purchase.getNumberOfPurchases() > maxPurchase) {
                    maxPurchase = purchase.getNumberOfPurchases();
                    maxday = purchase.getWeekDay().toString();
                }
            }
            Arrays.sort(purchases);
            lookArray(purchases);
            if (PURCHASES_NUMBER >0) {
                System.out.println(Format.format2(averageCost/PURCHASES_NUMBER));}
            else {
                System.out.println(Format.format2(averageCost));
            }
            System.out.println("Lower cost = " + ";\n"
                    + "Monday's purchases = " + Format.format(mondayCost)
                    + ";\n" + "Max purchases day: " + maxday);
            int index = Arrays.binarySearch(purchases, new Purchase(null, 5, 2));
            if (index < 0) {
                System.out.println("Item not found");
            } else {
                System.out.println("Request item is:" + purchases[index]);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    private static void lookArray(Purchase[] purchases) {
        if (purchases.length > 0) {
            System.out.println("Name: " + Purchase.NAME_OF_PRODUCT + ";" + "Price = "
                    + Format.format(Purchase.PRICE));

            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
        }
    }
}
