package exceptions;

public class UnderflowException extends Exception{

	public UnderflowException(String message) {
		super(message);
	}

	public UnderflowException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnderflowException(Throwable cause) {
		super(cause);
	}
}
