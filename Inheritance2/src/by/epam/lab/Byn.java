package Inheritance2;

public final class Byn implements Comparable<Byn> {
    private int value;

    public Byn(int i) {
        this.value = value;
    }

    public Byn() {
    }

    public Byn(Byn byn) {
    }

    @Override
    public int compareTo(Byn byn) {
        return value - byn.value;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return this.value == byn.value;
    }

    public Byn add(int a) {
        value += a;
        return this;
    }

    public Byn sub(Byn a) {
        value -= a.value;
        return this;
    }

    public Byn mul(int a) {
        value *= a;
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

    public enum Round {
        FLOOR {
            double roundFunction(double roundingValue) {
                return Math.floor(roundingValue);
            }
        },
        ROUND {
            double roundFunction(double roundingValue) {
                return Math.round(roundingValue);
            }
        };

        abstract double roundFunction(double roundingValue);

        private int rounding(double roundingValue, int num) {
            final int[] ten = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
            return (int) roundFunction(roundingValue / ten[num]) * ten[num];
        }
    }
}