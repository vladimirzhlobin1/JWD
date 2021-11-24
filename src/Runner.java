package by.gsu.epamlab;
import Kloig.MaterialEnam;
public class Runner {

	    public static void main(String[] args) {

			//  final Material STEEL = new Material(STEEL, 7850.0);
	       // final Material COPPER = new Material("Copper", 8500.0);
	        Subject wire = new Subject(MaterialEnam.STEEL, "Wire ", 0.03);
	        System.out.println(wire);
	        wire.setMaterial(MaterialEnam.COPPER);
	        System.out.println(" The mass of material is " + wire.getMass() + " kg.");
	    }
	}

	
	

	