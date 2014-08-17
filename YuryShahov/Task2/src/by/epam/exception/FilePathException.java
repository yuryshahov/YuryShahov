package by.epam.exception;

public class FilePathException extends Exception {

	private static final long serialVersionUID = 596888820144850883L;
	
	public FilePathException() {
		super();
	}
	
	public FilePathException(String message) {
		super(message);
	}
	
	public FilePathException(Throwable arg0) {
		super(arg0);
	}
	
	public FilePathException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("Wrong file path or type.\r\n");
		sb.append(super.getMessage());
		return sb.toString();
	}
}
