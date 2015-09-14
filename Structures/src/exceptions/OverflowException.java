package exceptions;

public class OverflowException extends Exception {
	
	public OverflowException(String message) {
		super(message);
	}

	public OverflowException() {
		super("The structure is full.");
	}
	
	public OverflowException(String message, Throwable cause) {
		super(message, cause);
	}

	public OverflowException(Throwable cause) {
		super(cause);
	}
}
