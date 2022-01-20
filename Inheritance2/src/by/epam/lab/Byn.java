public final class Byn implements Comparable<Byn> {
    private int value;
    public Byn(int value) {
        this.value = value;
    }

    public Byn(Byn byn) {
    }
    /*public int compareTo(Byn byn) {
        return this.value - byn.value;
    }*/

    @Override
    public int compareTo(Byn o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d",this.value/100, value%100);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return this.value == byn.value;
    }
    public Byn add(Byn byn) {
        return new Byn(value + byn.value);
    }
    public Byn sub(Byn byn) {
        return new Byn(value - byn.value);
    }
    public Byn mul(int a) {
        value*=a;
        return this;
    }
    public Byn mul(double a, Round round, int digits) {
        return new Byn(round.rounding((int) (value * a), digits));
    }
    public Byn mul(double a) {
        return mul(a, Round.ROUND, 0);
    }
    public Byn round(Round round, int digits) {
        return new Byn(round.rounding(value, digits));
    }
    public enum Round {
        FLOOR {
            double roundFunction(double roundingValue) {
                return Math.floor(roundingValue);
            }},
        ROUND {
            double roundFunction(double roundingValue) {
                return Math.round(roundingValue);
            }};
        abstract double roundFunction(double roundingValue);
        private int rounding(int roundingValue, int num) {
            final int[] ten = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
            return (int) roundFunction(roundingValue / ten[num]) * ten[num];
        }}}