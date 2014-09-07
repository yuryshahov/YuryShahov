package by.epam.exception;

public class ErrorException extends Exception {

	private static final long serialVersionUID = -812992968078550151L;

	public ErrorException() {
		super();
	}
	
	public ErrorException(String message) {
		super(message);
	}
	
	public ErrorException(Throwable arg0) {
		super(arg0);
	}
	
	public ErrorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
