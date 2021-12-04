package by.gsu.epamlab;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                //int days = sc.nextInt();
                // int number = sc.nextInt();
                // double discount = sc.nextDouble();
                //WeekDay WDay = WeekDay.values()[days];
                //purchases[i] = new Purchase(WDay, number, discount);
                purchases[i] = {new Purchase(WeekDay.values()[day], sc.nextInt(), sc.nextInt(), sc.nextDouble());}
            }
            lookArray(purchases);
            double averageCost = 0.00;
            int mondayCost = 0;
            //String maxday = null;
            WeekDay maxday=null;
            for (Purchase purchase : purchases) {
                int cost = purchase.getCost();
                averageCost += cost;
                int maxPurchase = 0;
                if (purchase.getWeekDay() == WeekDay.MONDAY) {
                    mondayCost += cost;
                }
                if (purchase.getCost() > maxPurchase) {
                    maxPurchase = purchase.getCost();
                    maxday = purchase.getWeekDay().toString();
                }
            }

            if (PURCHASES_NUMBER >0) {
                System.out.printf("Average cost = %3f\n",averageCost/PURCHASES_NUMBER);}
            else {
                System.out.printf("AverageCost = %3f\n",averageCost);
            }
            System.out.println("Monday's purchases = " + Format.format(mondayCost)
                    + ";\n" + "Max purchases day: " + maxday);
            Arrays.sort(purchases);
            lookArray(purchases);

            int index = Arrays.binarySearch(purchases, new Purchase(null, 5, 2));
            if (index < 0) {
                System.out.println("Item not found");
            } else {
                System.out.println("Request item is: " + purchases[index]);
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
