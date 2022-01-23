package Inheritance2;
public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product product;
    private int numberOfUnits;
    public AbstractPurchase(Product product, int numberUnits) {this.product = product;this.numberOfUnits = numberUnits;}
    public Product getProduct() {
        return product;
    }
    public int getNumberOfUnits() {return numberOfUnits;}
    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }
    protected abstract Byn sumCost(Byn baseCost);
    public Byn getCost() {
        Byn baseCost = product.getPrice().mul(numberOfUnits);
        Byn finalCost = sumCost(baseCost);
        return finalCost.round(Round.FLOOR, 2);
    }
    protected String fieldsToString() {
        return getClass().getSimpleName() + ";" +product + ";" + numberOfUnits;}
    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }
    public int compareTo(AbstractPurchase purchase){return purchase.getCost().compareTo(getCost());}}