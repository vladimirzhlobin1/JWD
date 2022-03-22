package by.gsu.epamlab.exceptions;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.enums.Fields;

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