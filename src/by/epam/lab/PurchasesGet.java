package by.epam.lab;

import java.util.Scanner;

public class PurchasesGet {
    private enum PurchaseType {

        GENERAL_PURCHASE, PRICE_DISCOUNT_OF_PURCHASE, NUMBER_DISCOUNT_PURCHASE
    }

    public static Purchases getPurchase(Scanner sc) {
        String id = sc.next();
        PurchaseType type = PurchaseType.valueOf(id);
        switch (type) {
            case GENERAL_PURCHASE:
                return new Purchases(sc);
            case PRICE_DISCOUNT_OF_PURCHASE:
                return new DiscountPurchases(sc);
            case NUMBER_DISCOUNT_PURCHASE:
                return new QuantityDiscountPurchases(sc);
            default:
                throw new IllegalArgumentException();
        }
    }
}