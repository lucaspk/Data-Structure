package exceptions;

public class NullElementException extends Exception {

	public NullElementException() {
		super("The element must be different of null.");
	}
	
	public NullElementException(String message) {
		super(message);
	}

	public NullElementException(String message, Throwable cause) {
		super(message, cause);
	}

	public NullElementException(Throwable cause) {
		super(cause);
	}
	
}
