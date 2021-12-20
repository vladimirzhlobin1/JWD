package by.epam.lab;

import java.util.Scanner;

public class QuantityDiscountPurchases extends Purchase {

    private double percentDiscount;

    private final static int NUMBER_WITH_DISCOUNT = 10;

    public QuantityDiscountPurchases() {
    }

    public QuantityDiscountPurchases(String productName, Byn price, int number, double percentOfDiscount) {
        super(productName, price, number);
        this.percentDiscount = percentOfDiscount;
    }

    public QuantityDiscountPurchases(Scanner sc) {
        super(sc);
        this.percentDiscount = sc.nextDouble();
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    protected String classFieldsToString() {
        return super.classFieldsToString() + ";" + percentDiscount;
    }

    @Override
    public Byn getCost() {
        if (NUMBER_WITH_DISCOUNT < getNumber()) {
            new Byn(super.getCost()).mul(1.0 - percentDiscount / 100.0, RoundMethod.ROUND, 0);
        }
        return super.getCost();
    }
}
