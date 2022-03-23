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
    public Byn mul(double k, Round round, int digits) {
        this.costOfObject = round.rounding(this.costOfObject * k, digits);
        return this;
    }

    public Byn mul(double k) {
        mul(k, Round.ROUND, 0);
        return this;
    }
 public Byn mul(double k, int digits) {
        mul(k, Round.ROUND, digits);
        return this;
    }
    public Byn mul(double k, Round round) {
        mul(k, round, 0);
        return this;
    }

    public Byn round(int value) {
        round(Round.ROUND, value);
        return this;
    }
  public Byn round(Round round) {
        round(round, 0);
        return this;
    }
    public Byn round(Round round, int value) {
        this.costOfObject = round.rounding(this.costOfObject, value);
        return this;
    }

    public enum Round {
        CEIL {
            double roundFunction(double roundingValue) {
                return Math.ceil(roundingValue);
            }
        },
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

        private int[] ten = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

        public int rounding(double roundingValue, int num) {
            return (int) roundFunction(roundingValue / ten[num]) * ten[num];
        }
    }
}