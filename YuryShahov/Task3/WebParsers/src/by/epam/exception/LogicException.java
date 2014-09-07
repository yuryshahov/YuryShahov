package by.epam.exception;

public class LogicException extends Exception {

	private static final long serialVersionUID = 596888820144850883L;
	
	public LogicException() {
		super();
	}
	
	public LogicException(String message) {
		super(message);
	}
	
	public LogicException(Throwable arg0) {
		super(arg0);
	}
	
	public LogicException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
