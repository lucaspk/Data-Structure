package exceptions;

public class InvalidSizeException extends Exception{
	
	public InvalidSizeException() {
		super("The size must be greater than zero.");
	}
	
	public InvalidSizeException(String message) {
		super(message);
	}

	public InvalidSizeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidSizeException(Throwable cause) {
		super(cause);
	}
}
