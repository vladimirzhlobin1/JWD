package by.gsu.epamlab;

public class BusinessTrip {
    private final static int DAILY_ALLOWANCE = 5457;
    private String accountOfEmployee;
    private int transportationExpenses;
    private int numberOfDays;

    public BusinessTrip() {
    }

    public BusinessTrip(String accountOfEmployee, int transportationExpenses, int numberOfDays) {
        this.accountOfEmployee = accountOfEmployee;
        this.transportationExpenses = transportationExpenses;
        this.numberOfDays = numberOfDays;
    }

    public String getAccountOfEmployee() {
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
// method for obtaining the entire value
    public int getTotal() {
        return DAILY_ALLOWANCE * numberOfDays + transportationExpenses;
    }

    private static String format(int a) {

        return String.format("%d.%02d",a / 100,a % 100);
    }

    public void show() {
        System.out.println("-- Daily Allowance=" + format(DAILY_ALLOWANCE) + "\nAccount of employee="
                + accountOfEmployee + "\nTransportation expenses = " + format(transportationExpenses)
                + ";\nNumber of days = " + numberOfDays
                + ";\nTotal rate = " + format(getTotal()) + "\n");
    }

    @Override
    public String toString() {
        return accountOfEmployee + ";" + format(transportationExpenses) + ";"
                + numberOfDays + ";" + format(getTotal());
        String.format("%s;%s;%d;%s",account,format(transportationExpenses),numberOfDays,format(getTotal())));

    }

}

