package by.epam.lab;
import java.util.Scanner;
public class Purchases {
    private String productName;
    private Byn price;
    private int number;
    public Purchases() {
    }

    public Purchases(String productName, Byn price, int number) {
        this.productName = productName;
        this.price = price;
        this.number = number;
    }

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

    public Purchases (Scanner sc) {
        this(sc.next(),new Byn(sc),sc.nextInt());
    }


    public Byn getCost() {
        return new Byn().add(price).mul(number);
    }

    protected String classFieldsToString() {
        return productName + ";" + price + ";" + number;
    }

    @Override
    public String toString() {
        return  classFieldsToString() + ";" + getCost();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)  return false;
        if (this == o) return true;
        if (!(o instanceof Purchases)) return false;

        Purchases purchase = (Purchases) o;

        return price.equals(purchase.price) &&
                productName.equals(purchase.productName);
    }
}
