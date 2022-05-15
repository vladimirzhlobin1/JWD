package by.epam.lab.exceptions;

public class NegativeArgumentException extends NonpositiveArgumentException {

    public NegativeArgumentException(String message) {
        super(message);
    }

}