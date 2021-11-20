package by.gsu.epamlab;

public classс  Runner {

    public static void main(String[] args) {

        Subject subjectVol = new Subject(new Material("Steel", 7850.0), "Volume of steel", 0.03);

        System.out.println(subjectVol.toString());

        subjectVol.setMaterial(new Material("Copper", 8500.0));

        System.out.println("The mass of material is " + subjectVol.getMass() + " kg.");
    }

}
