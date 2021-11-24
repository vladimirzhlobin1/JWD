package by.gsu.epamlab;

public enum MaterialEnam {
	STEEL(7850),COPPER(8500);

	MaterialEnam(double density) {this.density = density;
    }
	
	public double getDensity() {
		return density;
	}

	private final double density;

	 @Override
	 public String toString() {
	       return  name().toLowerCase() + " ; " + density;
	}
}
