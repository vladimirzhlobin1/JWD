package by.epam.lab.main;

import by.epam.lab.enums.Fields;
import by.epam.lab.exceptions.NegativeArgumentException;

public class Byn implements Comparable<Byn> {

    private int costOfObject;

    public Byn() {
        this(0);
    }

    public Byn(int value) {
        if (value < 0) {
            throw new NegativeArgumentException(value, Fields.BYN);
        }
        this.costOfObject = value;
    }

    public Byn(int rubs, int coins) {
        if (rubs < 0) {
            throw new NegativeArgumentException(rubs, Fields.BYN);
        }
        if (coins < 0 || coins > 99) {
            throw new NegativeArgumentException(coins, Fields.BYN);
        }
        this.costOfObject = rubs * 100 + coins;
    }

    public int getRubs() {
        return this.costOfObject / 100;
    }
 public Byn(Byn byn) {
        this(byn.costOfObject);
    }
    
 @Override
    public String toString() {
        return getRubs() + "." + costOfObject / 10 % 10 + costOfObject % 10;
    }
    @Override
    public int compareTo(Byn byn) {
        return this.costOfObject - byn.costOfObject;
    }
public int getCoins() {
        return this.costOfObject % 100;
    }
   
    public Byn add(Byn byn) {
        this.costOfObject += byn.costOfObject;
        return this;
    }

    public Byn mul(int k) {
        if (k < 0) {
            throw new NegativeArgumentException(k, Fields.KOEF);
        }
        this.costOfObject *= k;
        return this;
    }
public Byn sub(Byn byn) {
        if (costOfObject < byn.costOfObject) {
            throw new NegativeArgumentException(costOfObject - byn.costOfObject, Fields.BYN);
        }
        this.costOfObject -= byn.costOfObject;
        return this;
    }

    public Byn mul(double k) {
        mul(k, 0);
        return this;
    }
 public Byn mul(double k, int digits) {
        mul(k, digits);
        return this;
    }
}