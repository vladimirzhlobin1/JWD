package by.epam.lab.exceptions;

public class CsvLineException extends Exception {
    public CsvLineException() {
        super();
    }
    
 public CsvLineException(String message) {
        super(message);
    }
    public CsvLineException(Exception exception, String message) {
        super(message,exception);
    }
}