package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase> {
    public static final String NAME_OF_PRODUCT = "Item";
    public static final int PRICE = 770;
    private int numberOfPurchases;
    private WeekDay weekDay;
    private double discountPercentage;

    public Purchase() {
    }

    public Purchase(WeekDay weekDay, int numberOfPurchases, double discountPercentage) {
        this.weekDay = weekDay;
        this.numberOfPurchases = numberOfPurchases;
        this.discountPercentage = discountPercentage;
    }

    public Purchase(int day, int numberOfPurchases, double discountPercentage) {
        this(WeekDay.values()[day], numberOfPurchases, discountPercentage);
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfPurchases(int numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getCost() {
        return (int) Math.round((PRICE * numberOfPurchases
                * (100.0 - discountPercentage) / 100) * 0.01) * 100;
    }

    @Override
    public int compareTo(Purchase purchase) {
        return numberOfPurchases - purchase.numberOfPurchases;
    }

    @Override
    public String toString() {
        return numberOfPurchases + ";" + discountPercentage + ";" + weekDay + ";"
                + Format.format(getCost());
    }

}
