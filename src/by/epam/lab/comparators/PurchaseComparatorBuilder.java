package by.epam.lab.comparators;

import java.util.Comparator;

import by.epam.lab.main.Purchase;

public class PurchaseComparatorBuilder {
    private static Comparator<Purchase> purchaseComparator;

    private PurchaseComparatorBuilder() {
    } //for newInstance

    public static Comparator<Purchase> getPurchaseComparator() {
        return purchaseComparator;
    }

    public static void buildPurchaseComparator(String comparator) {
        if (purchaseComparator != null) {
            return;
        }
        final String FULL_COMPARATOR_NAME = PurchaseComparatorBuilder.class.getPackage().getName() + "." + comparator;
        try {
            Class<AbstractPurchaseComparator> compClass;
            compClass = (Class<AbstractPurchaseComparator>) Class.forName(FULL_COMPARATOR_NAME);
            purchaseComparator = compClass.newInstance();
        } catch (Exception e) {
            purchaseComparator = new PurchaseComparator();
        }
    }
}