package by.epam.lab;

import java.util.Scanner;

public class Byn implements Comparable<Byn> {
    private int costOfObject;

    public Byn() {
    }

    public Byn(Scanner sc) {
        this(sc.nextInt());
    }

    public Byn(int costOfObject) {
        this.costOfObject = costOfObject;
    }

    public Byn(int rub, int coins) {
        this(rub * 100 + coins);
    }

    public int getRub() {
        return this.costOfObject / 100;
    }

    public int getCoins() {
        return this.costOfObject % 100;
    }

    public Byn(Byn byn) {
        this(byn.costOfObject);
    }

    public Byn add(Byn byn) {
        this.costOfObject += byn.costOfObject;
        return this;
    }

    public Byn sub(Byn byn) {
        this.costOfObject -= byn.costOfObject;
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

    public Byn mul(double k, RoundMethod round, int num) {
        costOfObject = round.rounding(costOfObject * k, num);
        return this;
    }

    public Byn round(RoundMethod round, int num) {
        costOfObject = round.rounding(costOfObject, num);
        return this;
    }

    public Byn mul(int d) {
        this.costOfObject *= d;
        return this;
    }

}