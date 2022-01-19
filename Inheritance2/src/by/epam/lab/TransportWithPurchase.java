public class TransportWithPurchase extends AbstractPurchase {
    private Byn transportExpenses;
    public TransportWithPurchase(Product product, int numberUnits, int transportExpenses) {
        super(product, numberUnits);
        this.transportExpenses = new Byn(transportExpenses);
    }
    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportExpenses;
    }
    @Override
    protected Byn sumCost(Byn mainCost) {
        return mainCost.add(transportExpenses);
    }}
