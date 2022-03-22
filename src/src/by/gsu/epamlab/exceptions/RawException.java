package by.gsu.epamlab.exceptions;

import by.gsu.epamlab.Constants;

public class RawException extends Exception {

	private static final long serialVersionUID = 1L;
	private String misCsv;

    public RawException() {
        super();
    }
 public RawException(String cause, String misCsv) {
        super(cause);
        this.misCsv = misCsv;
    }
    public RawException(Exception exception, String misCsv) {
        super(exception);
        this.misCsv = misCsv;
    }

    public String toString() {
        return misCsv + Constants.ERROR_EXCEPTION_DELIMETER + getMessage();
    }
}