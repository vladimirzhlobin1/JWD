package by.epam.lab;

import java.util.Scanner;

public class DiscountPurchases extends Purchases {

    private Byn priceWithDiscount;

    public DiscountPurchases() {
    }

    public DiscountPurchases(String productName, int price, int number, int priceWithDiscount) {
        super(productName,price,number);
        this.priceWithDiscount = new Byn(priceWithDiscount);
    }

    public DiscountPurchases(Scanner sc) {
        super(sc);
        this.priceWithDiscount = new Byn(sc.nextInt());
    }

    @Override
    protected String classFieldsToString() {
        return super.classFieldsToString() +";" + priceWithDiscount;
    }

    @Override
    public Byn getCost() {

        return new Byn().sub(priceWithDiscount).mul(getNumber());
    }
}