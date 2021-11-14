package by.gsu.epamlab;

public class BusinessTrip   { private final  static int DAILY_ALLOWANCE = 5457;
    private String accountOfEmployee;// according with bank's programs
    private int transportationExpenses;
    private int numberOfDays;
    public BusinessTrip() {
    }
    public BusinessTrip(String accountOfEmployee, int transportationExpenses, int numberOfDays) {
        this.accountOfEmployee = accountOfEmployee;
        this.transportationExpenses = transportationExpenses;
        this.numberOfDays = numberOfDays;
    }
    public String getAccountOfEmploee() {
        return accountOfEmployee;
    }
    public void setAccountOfEmployee(String accountOfEmployee) {
        this.accountOfEmployee = accountOfEmployee;
    }
    public int getTransportationExpenses() {
        return transportationExpenses;
    }
    public void setTransportationExpenses(int transportationExpenses) {
        this.transportationExpenses = transportationExpenses;
    }
    public int getNumberOfDays() {
        return numberOfDays;
    }
    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
    public int getTotal() {
        int b = transportationExpenses + DAILY_ALLOWANCE * numberOfDays;
        int rub = b / 100;
        int coin = b % 100;
        return DAILY_ALLOWANCE * numberOfDays+transportationExpenses;
    }
    private static String format(int a) {
        int rub = a / 100;
        int coin = a % 100;
        return String.format("%d.%02d", rub, coin);
    }
    public void show() {
        System.out.println("-- Daily Allowance=" + format(DAILY_ALLOWANCE) + "\nAccount of emploee="
                + accountOfEmployee + "\nTransportation expenses = " + format(transportationExpenses)
                + ";\nNumber of days = " + numberOfDays
                + ";\nTotal rate = " + getTotal() + "\n");
    }

    @Override
    public String toString() {
        return accountOfEmployee + ";" + format(transportationExpenses) + ";"
                + numberOfDays + ";" + getTotal();

    }
}

