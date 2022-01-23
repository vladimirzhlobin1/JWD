package Inheritance2;
public class PercentDiscountPurchase extends AbstractPurchase {
    private final double percentDiscount;
    private final static int NUMBER_DISCOUNT = 10;
    public PercentDiscountPurchase(Product productName, int numberOfUnits, double percentDiscount) {super(productName, numberOfUnits);this.percentDiscount = percentDiscount;}
    public double getPercentDiscount() {return percentDiscount;}
    @Override
    protected String fieldsToString() {
        return super.fieldsToString()  + ";" + percentDiscount;
    }
    @Override
    protected Byn getFinalCost(Byn baseCost) {return baseCost.mul(getNumberOfUnits());}
    @Override
    protected Byn sumCost(Byn baseCost) {
        Byn byn = new Byn(getCost());if (getNumberOfUnits() > NUMBER_DISCOUNT) {byn.mul(percentDiscount);
        }return baseCost;}
}