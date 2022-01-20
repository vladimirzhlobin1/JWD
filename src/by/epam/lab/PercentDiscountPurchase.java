package Inheritance2;

public class PercentDiscountPurchase extends AbstractPurchase {
    private final double percentDiscount;
    private final static int NUMBER_DISCOUNT = 10;

    public PercentDiscountPurchase(Product productName, int numberOfUnits, double percentDiscount) {
        super(productName, numberOfUnits);
        this.percentDiscount = percentDiscount;
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + percentDiscount;
    }

    @Override
    protected Byn sumCost() {
        Byn byn = new Byn(getProduct().getPrice()).mul(getNumberOfUnits());
        if (getNumberOfUnits() > NUMBER_DISCOUNT) {
            byn.mul(percentDiscount);
        }
        return byn;
    }
}