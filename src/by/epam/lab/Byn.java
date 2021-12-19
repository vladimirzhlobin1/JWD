package by.epam.lab;

public class Byn implements Comparable<Byn> {
    public int costOfObject;

    public Byn() {
    }

    public Byn(int costOfObject) {
        this.costOfObject = costOfObject;
    }
    public Byn (int rub, int coins) {
        this(rub * 100 + coins);
    }
    public int getRub() {
        return this.costOfObject / 100;
    }

    public int getCoins() {
        return this.costOfObject % 100;
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

    public Byn sum () {
        return this;
    }
    @Override
    public String toString() {
        return String.format("%d.%02d",costOfObject/100, costOfObject%100);
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
    public Byn mul(double k, Round round, int num) {
        this.costOfObject = round.rounding(this.costOfObject * k, num);
        return this;
    }

    public Byn mul(double k, int num) {
        mul(k, Round.ROUND, num);
        return this;
    }

    public Byn mul(double k) {
        mul(k, Round.ROUND, 0);
        return this;
    }

    public Byn mul(double k, Round round) {
        mul(k, round, 0);
        return this;
    }

    public Byn round(Round round) {
        round(round,0);
        return this;
    }

    public Byn round(int num) {
        round(Round.ROUND,num);
        return this;
    }

    public Byn round(Round round, int num) {
        this.costOfObject = round.rounding(this.costOfObject, num);
        return this;
    }

    public static enum Round {

        ROUND {
            double roundFunction(double roundingCostOfObject) {
                return Math.round(roundingCostOfObject);
            }
        };

        abstract double roundFunction(double roundingCostOfObject);

        private int[] ten = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

        private int rounding(double roundingValue, int num) {
            return (int) roundFunction(roundingValue / ten[num]) * ten[num];
        }
    }
}