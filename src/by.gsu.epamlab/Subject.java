package by.gsu.epamlab;

public class Subject {
    private Material material;
    private String nameOfSubject;
    private double volume;

    public Subject() {
        super();
    }

    public Subject(Material  material, String name, double volume) {
        super();
        this.material = material;
        this.nameOfSubject = name;
        this.volume = volume;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getName() {
        return nameOfSubject;
    }

    public void setName(String name) {
        this.nameOfSubject  =  name;
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
        // TODO Auto-generated method stub
        return nameOfSubject + ";" + material.getName() + ";" + material.getDensity() + ";" + volume + ";" + getMass();
    }

}
