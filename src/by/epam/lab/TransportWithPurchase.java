package Inheritance2;

public class TransportWithPurchase extends AbstractPurchase {
    private Byn transportExpenses;
    public TransportWithPurchase(Product product, int numberUnits, Byn transportExpenses) {super(product, numberUnits);this.transportExpenses = transportExpenses;}
    public Byn getTransportExpenses() {return transportExpenses;}
    public void setTransportExpenses(Byn transportExpenses) {this.transportExpenses = transportExpenses;}
    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportExpenses;
    }
    @Override
    protected Byn getFinalCost(Byn baseCost) {return baseCost.add(transportExpenses);}
    @Override
    protected Byn sumCost(Byn baseCost) {return new Byn(getCost());}
}
