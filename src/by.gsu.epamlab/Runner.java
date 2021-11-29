package by.gsu.epamlab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import by.gsu.epamlab.Format;

public class Runner {
    public static void main(String[] args) {
        final int NUMBER_OF_PURCHASE;
        // Purchase[] purchases=null;
        try (Scanner sc = new Scanner(new FileReader("src/purchases.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            NUMBER_OF_PURCHASE = sc.nextInt();
            Purchase[] purchases = new Purchase[NUMBER_OF_PURCHASE];
            for (int i = 0; i < NUMBER_OF_PURCHASE; i++) {
                int days = sc.nextInt();
                int number = sc.nextInt();
                int discount = sc.nextInt();
                WeekDay WDay = WeekDay.values()[days];
                purchases[i] = new Purchase(WDay, number, discount);
            }
            lookArray(purchases);
            double lowerCost = 0.00;
            double mondayCost = 0;
            String maxday = null;
            for (Purchase purchase : purchases) {
                lowerCost += purchase.getCost() / purchases.length;
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
            int index = Arrays.binarySearch(purchases, new Purchase(null, 5, 2));
            if (index < 0) {
                System.out.println("Item not found");
            } else {
                System.out.println("Request item is:" + purchases[index]);
            }
            System.out.println("Lower cost=" + Format.format2(lowerCost) + ";\n"
                    + "Monday's purchases=" + Format.format2(mondayCost)
                    + ";\n" + "Max purchases day:" + maxday);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    private static void lookArray(Purchase[] purchases) {
        if (purchases.length > 0) {
            System.out.println("Name:" + Purchase.NAME_OF_PRODUCT + ";" + "Price="
                    + Format.format(Purchase.PRICE));

            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
        }
    }
}
