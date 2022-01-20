package Inheritance2;

public class PriceDiscountPurchase extends AbstractPurchase {
    private int priceDiscount;
    public PriceDiscountPurchase(Product product, int numberUnits, int priceDiscount) {
        super(product, numberUnits);
        this.priceDiscount = priceDiscount;
    }
    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + priceDiscount;
    }
    @Override
    protected Byn sumCost(Byn mainCost) {
        return mainCost.sub(priceDiscount.mul(getNumberOfUnits()));
    }
    public int getPriceDiscount() {
        return priceDiscount;
    }}