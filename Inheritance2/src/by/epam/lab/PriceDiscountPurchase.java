public class PriceDiscountPurchase extends AbstractPurchase {
    private final Byn priceDiscount;
    public PriceDiscountPurchase(Product product, int numberUnits, int priceDiscount) {
        super(product, numberUnits);
        this.priceDiscount = new Byn(priceDiscount);
    }
    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + priceDiscount;
    }
    @Override
    protected Byn sumCost(Byn mainCost) {
        return mainCost.sub(priceDiscount.mul(getNumberOfUnits()));
    }}