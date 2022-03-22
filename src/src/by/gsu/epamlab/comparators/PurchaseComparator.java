package by.gsu.epamlab.comparators;
import by.gsu.epamlab.main.PriceDiscountPurchase;
import by.gsu.epamlab.main.Purchase;
public class PurchaseComparator extends AbstractPurchaseComparator {
    @Override
    protected boolean isSubPurchase(Purchase p) {
        return p instanceof PriceDiscountPurchase;
    }
}