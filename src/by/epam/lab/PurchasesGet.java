package by.epam.lab;

import java.util.Scanner;

public class PurchasesGet {

    private static enum PurchaseType {
        GENERAL_PURCHASE {
            Purchase getPurchase(Scanner sc) {
                return new Purchase(sc);
            }
        },
        PRICE_DISCOUNT_OF_PURCHASE {
            Purchase getPurchase(Scanner sc) {
                return new DiscountPurchases(sc);
            }
        },
        NUMBER_DISCOUNT_PURCHASE {
            Purchase getPurchase(Scanner sc) {
                return new QuantityDiscountPurchases(sc);
            }
        };

        abstract Purchase getPurchase(Scanner sc);
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        return PurchaseType.valueOf(sc.next()).getPurchase(sc);
    }
}