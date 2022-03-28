package by.epam.lab.comparators;
import by.epam.lab.main.PriceDiscountPurchase;
import by.epam.lab.main.Purchase;
public class PurchaseComparator extends AbstractPurchaseComparator {
    @Override
    protected boolean isSubPurchase(Purchase p) {
        return p instanceof PriceDiscountPurchase;
    }
}