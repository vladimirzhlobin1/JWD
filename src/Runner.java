package by.gsu.epamlab;

public class Runner {

    public static void main(String[] args) {
        final Material MATERIAL1 = new Material("Steel", 7850.0);
        final Material MATERIAL2 = new Material("Copper", 8500.0);
        Subject subject1 = new Subject(MATERIAL1, "Wire", 0.03);
        subject1.setMaterial(MATERIAL2);
        System.out.println(subject1);
    }

}
