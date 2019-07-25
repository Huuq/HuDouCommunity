package club.qh.web.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
	QUESTION_NOT_FOUND("服务器热的冒烟了！请稍后再试试");

	private String message;

	private CustomizeErrorCode(String message) {
		this.message = message;
	}
    @Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
