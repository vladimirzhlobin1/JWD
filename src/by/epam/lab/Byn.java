package Inheritance2;

public class Byn implements Comparable<Byn> {
    private int value;
    public Byn(int i) {
        this.value = value;
    }
    public Byn() {}
    public Byn(Byn byn) {
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
        return this.value == byn.value;
    }
    public Byn add(Byn a){
        value+=a.value;
        return this; }
    public Byn sub (Byn a) {
        value -= a.value;
        return this;
    }
    public Byn mul(int a){
        value*=a;
        return this;
    }
    public Byn mul(double a, Round round, int digits) {
        round.rounding(value * a, digits);
        return this;
    }

    public Byn mul(double a) {
        mul(a, Round.ROUND, 0);
        return this;
    }

    public Byn round(Round round, int digits) {
        return new Byn(round.rounding(value, digits));
    }
}