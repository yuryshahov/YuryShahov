package by.epam.exception;

public class TextTypeNotFoundException extends Exception {

	
	private static final long serialVersionUID = -1608102586983031927L;

	public TextTypeNotFoundException() {
		super();
	}
	
	public TextTypeNotFoundException(String message) {
		super(message);
	}
	
	public TextTypeNotFoundException(Throwable arg0) {
		super(arg0);
	}
	
	public TextTypeNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("Type of text lexeme not found.\r\n");
		sb.append(super.getMessage());
		return sb.toString();
	}
}
