package by.gsu.epamlab;

public class Runner {

    public static void main(String[] args) {

        Subject wire = new Subject(Material.STEEL, "Wire ", 0.03);
        System.out.println(wire);
        wire.setMaterial(Material.COPPER);
        System.out.println("The mass of material is " + wire.getMass() + " kg.");
    }
}

	
	

	