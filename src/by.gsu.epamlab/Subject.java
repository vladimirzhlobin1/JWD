package by.gsu.epamlab;

public class Subject {
	private MaterialEnam material;
    private String name;
    private double volume;

    public Subject() {
    }

    public Subject(MaterialEnam material, String name, double volume) {
        this.material = material;
        this.name = name;
        this.volume = volume;
    }

    public MaterialEnam getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEnam material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMass() {
        return material.getDensity() * volume;
    }

    @Override
    public String toString() {
        return name + " ; " + material + " ;" + volume + " ; " + getMass();
    }
}
