package by.epam.lab;
import java.util.Scanner;
public class Purchases {
    private String productName;
    private Byn price;
    private int number;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

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
        return new Byn().add(price).mul(number);
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
                price.costOfObject== purchase.price.costOfObject;
    }

}
