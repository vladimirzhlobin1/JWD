package Inheritance2;

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

    int rounding(double roundingValue, int num) {
        final int[] ten = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        return (int) roundFunction(roundingValue / ten[num]) * ten[num];
    }
}