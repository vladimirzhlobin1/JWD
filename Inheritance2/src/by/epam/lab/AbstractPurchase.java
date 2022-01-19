public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product product;
    private int numberOfUnits;
    public AbstractPurchase(Product product, int numberUnits) {
        this.product = product;
        this.numberOfUnits = numberUnits;
    }
    public int getNumberOfUnits() {
        return numberOfUnits;
    }
    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }
    protected abstract Byn sumCost(Byn mainCost);
    public Byn getCost() {
        return sumCost(product.getPrice().mul(numberOfUnits)).round(Byn.Round.FLOOR, 2);
    }
    protected String fieldsToString() {
        return getClass().getSimpleName() + ";" +product + ";" + numberOfUnits;
    }
    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }
    public int compareTo(AbstractPurchase purchase){
        return purchase.getCost().compareTo(getCost());
    }}