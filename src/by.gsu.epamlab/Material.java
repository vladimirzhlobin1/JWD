package by.gsu.epamlab;

public class Material {
    private final String nameOfMaterial;
    private final double densityOfMaterial;


    public Material() {
        super( );
        this.nameOfMaterial = "";
        this.densityOfMaterial = 0;
    }

    public Material(String name, double density) {
        this.nameOfMaterial = name;
        this.densityOfMaterial = density;
    }

    public String getName() {
        return nameOfMaterial;
    }

    public double getDensity() {
        return densityOfMaterial;
    }

    @Override
    public String toString() {

        return "Name of material" + nameOfMaterial + ";" + "DensityOfMaterial" + densityOfMaterial;
    }

}
