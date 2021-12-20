package by.epam.lab;

public enum RoundMethod {
    ROUND {
        double roundFunction(double roundingCostOfObject) {
            return Math.round(roundingCostOfObject);
        }
    },
    CEIL {
        double roundFunction(double roundingValue) {
            return Math.ceil(roundingValue);
        }
    },
    FLOOR {
        double roundFunction(double roundingValue) {
            return Math.floor(roundingValue);
        }
    };

    abstract double roundFunction(double roundingCostOfObject);

    private static final int[] ten = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

    public int rounding(double roundingValue, int num) {
        return (int) roundFunction(roundingValue / ten[num]) * ten[num];
    }

}