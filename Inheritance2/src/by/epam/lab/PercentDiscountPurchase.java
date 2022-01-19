public class PercentDiscountPurchase extends AbstractPurchase {
    private final double percentDiscount;
    private final static int NUMBER_DISCOUNT = 10;
    public PercentDiscountPurchase(Product productName, int numberOfUnits, double percentDiscount) {
        super(productName, numberOfUnits);
        this.percentDiscount = percentDiscount;
    }
    @Override
    protected String fieldsToString() {
        return super.fieldsToString()  + ";" + percentDiscount;
    }
    @Override
    protected Byn sumCost(Byn mainCost) {
        if (NUMBER_DISCOUNT < getNumberOfUnits()) {
            mainCost.mul(1.0 - percentDiscount / 100.0);
        }
        return mainCost;
  }}