package Inheritance2;

public class TransportWithPurchase extends AbstractPurchase {
    private int transportExpenses;
    public TransportWithPurchase(Product product, int numberUnits, int transportExpenses) {
        super(product, numberUnits);
        this.transportExpenses = transportExpenses;
    }
    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportExpenses;
    }
    @Override
    protected Byn sumCost(Byn mainCost) {
        return mainCost.add(transportExpenses);
    }}
