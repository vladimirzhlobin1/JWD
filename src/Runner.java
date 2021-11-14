import by.gsu.epamlab.*;

public class Runner {
    public static void main(String[] args) {

        BusinessTrip[] businessTrips = {
                new BusinessTrip("Angela", 1010, 2),
                new BusinessTrip("Antoin", 2010, 3),
                null,
                new BusinessTrip("Vladimir", 2510, 4),
                new BusinessTrip()};
        BusinessTrip maxCostTrip = new BusinessTrip();
        //display objects BusinessTrip
        for (BusinessTrip businessTrip : businessTrips) {
            // catch null object
            if (businessTrip != null) {
                businessTrip.show();

                if (maxCostTrip.getTotal() < businessTrip.getTotal()) {
                    maxCostTrip = businessTrip;
                }

            }

        }
        System.out.println("MaxCost = " + maxCostTrip);

        // give some money last's employee

        businessTrips[businessTrips.length - 1].setTransportationExpenses(450);

        // total during of muchmoney's trips
        System.out.println("Duration of business trips for the last two employees = "
                + (businessTrips[0].getNumberOfDays() + businessTrips[1].getNumberOfDays()) + " days");

        for (BusinessTrip businessTrip : businessTrips) {
            // hide toString
            System.out.println(businessTrip);
        }
    }

}

