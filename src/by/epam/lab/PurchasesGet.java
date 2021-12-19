package by.epam.lab;

import java.util.Scanner;

public class PurchasesGet {

    private static enum PurchaseType {
        GENERAL_PURCHASE {
            Purchases getPurchase(Scanner sc) {
                return new Purchases(sc);
            }
        },
        PRICE_DISCOUNT_OF_PURCHASE {
            Purchases getPurchase(Scanner sc) {
                return new DiscountPurchases(sc);
            }
        },
        NUMBER_DISCOUNT_PURCHASE {
            Purchases getPurchase(Scanner sc) {
                return new QuantityDiscountPurchases(sc);
            }
        };

        abstract Purchases getPurchase(Scanner sc);
    }

    public static Purchases getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        return PurchaseType.valueOf(id).getPurchase(sc);
    }
}