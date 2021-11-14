package by.gsu.epamlab;
import static java.lang.System.out;
public class BusinessTrip   {
    final static int DAILY_ALLOWANCE = 5457;
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

    public void setAccountOfEmploee(String accountOfEmploee) {
        this.accountOfEmployee = accountOfEmploee;
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

    public String getTotal() {
        int b = transportationExpenses + DAILY_ALLOWANCE * numberOfDays;
        int rub = b / 100;
        int coin = b % 100;
        return String.format("%d.%d", rub, coin);

    }


    public String formata(int transportationExpenses) {

        int rub = transportationExpenses / 100;
        int coin = transportationExpenses % 100;
        return String.format("%d.%d", rub, coin);

    }

    public String formata1(int DAILY_ALLOWANCE) {

        int rub = DAILY_ALLOWANCE / 100;
        int coin = DAILY_ALLOWANCE % 100;
        return String.format("%d.%d", rub, coin);


    }

    public void show() {
        out.printf("-- Daily Allowance=" + formata1(DAILY_ALLOWANCE) + "\nAccount of emploee=" + accountOfEmployee
                + "\nTransportation expenses = " + formata(transportationExpenses) + ";\nNumber of days = " + numberOfDays
                + ";\nTotal rate = " + getTotal() + "\n");
    }

    @Override
    public String toString() {
        return accountOfEmployee + ";" + formata(transportationExpenses) + ";" + numberOfDays + ";" + getTotal();

    }

}

