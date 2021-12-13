package by.epam.lab;

import java.util.Scanner;

public class QuantityDiscountPurchases extends Purchases {

    private double percentDiscount;
    private final static int NUMBER_WITH_DISCOUNT = 10;

    public QuantityDiscountPurchases() {}

    public QuantityDiscountPurchases(String productName, int price, int number, double percentOfDiscount) {
        super(productName,price,number);
        this.percentDiscount = percentOfDiscount;
    }

    public QuantityDiscountPurchases(Scanner sc) {
        super(sc);
        this.percentDiscount = sc.nextDouble();
    }

    @Override
    protected String classFieldsToString() {
        return super.classFieldsToString() +";" + percentDiscount;
    }


    @Override
    public Byn getCost() {
        if (NUMBER_WITH_DISCOUNT < getNumber()) {
            new Byn().mul(1.0 - percentDiscount / 100.0);
        }
        return super.getCost();
    }
}
