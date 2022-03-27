package by.epam.lab.exceptions;

import by.epam.lab.Constants;
import by.epam.lab.enums.Fields;

public class NonpositiveArgumentException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;
    private Fields raw;
    private int value;


    public int getValue() {
        return value;
    }

    public Fields getRaw() {
        return raw;
    }

    public String getFieldName() {
        return raw.name();
    }

    public NonpositiveArgumentException() {
        super();
    }

    public NonpositiveArgumentException(int antiValue, Fields field) {
        value = antiValue;
        this.raw = field;
    }

    public NonpositiveArgumentException(Fields field) {
        this.raw = field;
    }

    public String getHeader() {
        return Constants.ERROR_NEGATIVE_VAL;
    }

    @Override
    public String toString() {
        return getHeader() + value
                + Constants.ERROR_EXCEPTION_NEGATIVE + raw
                + Constants.ERROR_EXCEPTION_NONPOSITIVE_FOOT;
    }
}