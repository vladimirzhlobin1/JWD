package by.epam.lab.exceptions;

import by.epam.lab.Constants;
import by.epam.lab.enums.Fields;

public class NegativeArgumentException extends NonpositiveArgumentException {

    private static final long serialVersionUID = 1L;

    public NegativeArgumentException() {
    }

    public NegativeArgumentException(int value, Fields field) {
        super(value, field);
    }

    public String getHeader() {
        return Constants.ERROR_EXCEPTION_NEGATIVE_FIN;
    }

}