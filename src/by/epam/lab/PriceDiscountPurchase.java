package Inheritance2;

public class PriceDiscountPurchase extends AbstractPurchase {
    private Byn priceDiscount;

    public PriceDiscountPurchase(Product product, int numberUnits, Byn priceDiscount) {
        super(product, numberUnits);
        this.priceDiscount = priceDiscount;
    }

    public void setPriceDiscount(Byn priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + priceDiscount;
    }

    public Byn getPriceDiscount() {
        return priceDiscount;
    }

    @Override
    protected Byn sumCost(Byn baseCost) {
        return baseCost.sub(priceDiscount.mul(getNumberOfUnits()));
    }
}