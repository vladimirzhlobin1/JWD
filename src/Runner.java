package by.gsu.epamlab;

public class Runner {

    public static void main(String[] args) {
        final Material STEEL = new Material("Steel", 7850.0);
        final Material COPPER = new Material("Copper", 8500.0);
        Subject wire = new Subject(STEEL, "Wire", 0.03);
        System.out.println(wire);
        wire.setMaterial(COPPER);
        System.out.println("The mass of material is " + wire.getMass() + " kg.");
    }
}
