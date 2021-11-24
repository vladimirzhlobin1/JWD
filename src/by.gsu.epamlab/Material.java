package by.gsu.epamlab;

public enum Material {
    STEEL(7850),
    COPPER(8500);
    private final double density;

    Material(double density) {
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

    public String getName() {
        return name().toLowerCase();
    }

    @Override
    public String toString() {
        return getName() + ";" + density;
    }
}