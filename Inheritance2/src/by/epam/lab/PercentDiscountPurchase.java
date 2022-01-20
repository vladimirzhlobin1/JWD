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

    Byn mainCost = new Byn(getProduct().getPrice()).mul(getNumberOfUnits());

    @Override
    protected Byn sumCost(Byn mainCost) {
        if (NUMBER_DISCOUNT < getNumberOfUnits()) {
            mainCost.mul(1.0 - percentDiscount / 100.0);
        }
        return mainCost;
    }
}