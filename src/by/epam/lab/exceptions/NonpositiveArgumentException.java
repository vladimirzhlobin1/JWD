package by.epam.lab.exceptions;

import by.epam.lab.Constants;
import by.epam.lab.enums.Fields;

public class NonpositiveArgumentException extends IllegalArgumentException {

	public NonpositiveArgumentException(String message) {
		super(message);
	}
}