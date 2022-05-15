package by.epam.lab.beans;
import by.epam.lab.Constants;
import by.epam.lab.enums.Fields;
import by.epam.lab.exceptions.NegativeArgumentException;

public class Byn implements Comparable<Byn> {

    private int value;
    public static final int  COPS = 100;
    public Byn() {
        this(0);
    }

    public Byn(String message, int value) {
        if (value < 0) {
            throw new NegativeArgumentException(message, value);
        }
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        this(getValidValue(rubs, coins));
    }
    private static int getValidValue(int rubs, int coins) {
        if (rubs < 0) {
            throw new IllegalArgumentException("...");
        }
        if (rubs < 0) {
            throw new NegativeArgumentException(rubs, coins);
        }
        if (coins < 0 || coins > 99) {
            throw new NegativeArgumentException(rubs, coins);
        }
        return 100 * rubs + coins;
    }

 public Byn(Byn byn) {
        this(byn.value);
    }
    
 public Byn(String string) {
	// TODO Auto-generated constructor stub
}

@Override
    public String toString() {
        return String.format(VALUE_FORMAT, value / COPS, + value% COPS);
    }
    @Override
    public int compareTo(Byn byn) {
        return this.value - byn.value;
    }
   
    public Byn add(Byn byn) {
        this.value += byn.value;
        return this;
    }

    public Byn mul(int k) {
        if (k < 0) {
        }
        this.value *= k;
        return new Byn();
    }
public Byn sub(Byn byn) {
        if (value < byn.value) {
        }
        this.value -= byn.value;
        return new Byn();
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