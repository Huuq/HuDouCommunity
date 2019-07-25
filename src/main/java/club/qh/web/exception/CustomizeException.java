package club.qh.web.exception;

public class CustomizeException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public CustomizeException(ICustomizeErrorCode errorCode) {
		super();
		this.message = errorCode.getMessage();
	}


	public CustomizeException(String message) {
		super();
		this.message = message;
	}
	

}
