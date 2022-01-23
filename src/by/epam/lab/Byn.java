package Inheritance2;

public class Byn implements Comparable<Byn> {
    private int value;
    public Byn(int i) {
        this.value = i;
    }
    public Byn() {}
    public Byn(Byn byn) {
        value = byn.value;
    }
    @Override
    public int compareTo(Byn byn) {
        return value - byn.value;
    }
    @Override
    public String toString() {
        return String.format("%d.%02d",value/100, value%100);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return this.value == byn.value;}
    public Byn add(Byn byn) {
        return new Byn(this.value + byn.value);
    }
    public Byn sub(Byn byn) {
        return new Byn(this.value - byn.value);
    }
    public Byn mul(int a){return new Byn(this.value * a);}
    public Byn mul(double a, Round round, int digits) {
        return new Byn(round.rounding(this.value * a, digits));}
    public Byn mul(double a) {mul(a, Round.ROUND, 0);return this;}
    public Byn round(Round round, int digits) {
        return new Byn(round.rounding(value, digits));
    }
}