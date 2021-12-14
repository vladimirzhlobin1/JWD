package by.epam.lab;

public class Byn implements Comparable<Byn> {
    public int costOfObject;

    public Byn() {
    }

    public Byn(int costOfObject) {
        this.costOfObject = costOfObject;
    }

    public Byn(Byn price) {
        this.costOfObject = price.costOfObject;
    }

    public Byn add(Byn byn) {
        this.costOfObject += byn.costOfObject;
        return this;
    }

    public Byn sub(Byn byn) {
        this.costOfObject -= byn.costOfObject;
        return this;
    }

    public Byn mul(int a) {
        this.costOfObject *= a;
        return this;
    }

    public Byn mul(double a) {
        this.costOfObject *= Math.round(a);
        return this;
    }

    public Byn sum() {

        return this;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", costOfObject / 100, costOfObject % 100);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Byn other = (Byn) obj;
        return costOfObject == other.costOfObject;
    }

    @Override
    public int compareTo(Byn o) {
        return costOfObject - o.costOfObject;
    }

}