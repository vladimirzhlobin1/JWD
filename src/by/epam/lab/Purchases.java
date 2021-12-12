package by.epam.lab;
import java.util.Scanner;
public class Purchases {
	protected String productName;
    protected Byn price;
    protected int number;

    public Purchases() {
    }

    public Purchases(String productName, int price, int number) {
        this.productName = productName;
        this.price = new Byn(price);
        this.number = number;
    }

    public Purchases (Scanner sc) {
        this.productName = sc.next();
        this.price = new Byn(sc.nextInt());
        this.number = sc.nextInt();
    }
    public Byn getCost() {
        return new Byn(price.getcostOfObject() * number);
    }

    protected String classFieldsToString() {
        return "";
    }

    @Override
    public String toString() {
        return productName + ";" + price + ";" + number + classFieldsToString() + ";" + getCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchases)) return false;
        Purchases purchase = (Purchases) o;

        return productName.equals(purchase.productName) &&
                price.getcostOfObject()== purchase.price.getcostOfObject();
    }

}
