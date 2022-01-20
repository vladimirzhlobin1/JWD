public class TransportWithPurchase extends AbstractPurchase {
    private static  Product product;
    private Byn transportExpenses;
    public TransportWithPurchase(Product product, int numberUnits, Byn transportExpenses) {
        super(product, numberUnits);
        this.transportExpenses = new Byn(transportExpenses);
    }

    public TransportWithPurchase(Product juice, int numberUnits, int i) {
        super(product);
    }

    public Byn getTransportExpenses() {
        return transportExpenses;
    }

    public void setTransportExpenses(Byn transportExpenses) {
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
