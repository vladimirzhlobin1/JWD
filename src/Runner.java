import by.gsu.epamlab.*;

public class Runner   {

    public static void main(String[] args) {

        BusinessTrip[]  businessTrips = {new BusinessTrip("Angela Merkel", 1010, 2), new BusinessTrip("Antoin Makron", 2010, 3), null,
                new BusinessTrip("Vladimir Putin", 2510, 4), new BusinessTrip()};

        for (BusinessTrip businessTrip : businessTrips) {
            // catch null object
            if (businessTrip != null) {
                businessTrip.show();
            }
        }
        // give some money last's employee
        businessTrips[4].setTransportationExpenses(450);

        // total during of muchmoney's trips
        System.out.println("Duration of business trips for the last two employees = "
                + (businessTrips[0].getNumberOfDays() + businessTrips[1].getNumberOfDays()) + " days");

        for (BusinessTrip businessTrip : businessTrips) {
            // hide toString
            System.out.println(businessTrip);
        }
    }

}

