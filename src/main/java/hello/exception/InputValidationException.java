package hello.exception;

public class InputValidationException extends BaseException {

private static final long serialVersionUID = 1L;
private String errorCode = "10003";
	
	public InputValidationException(){
		
	}

	public InputValidationException(String message){
		super(message);
	}
	
	public InputValidationException(ErrorCode errorCode) {
		super(errorCode);
	}

	public InputValidationException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

	public InputValidationException(Throwable cause, ErrorCode errorCode) {
		super(cause, errorCode);
	}

	public InputValidationException(String message, Throwable cause, ErrorCode errorCode) {
		super(message, cause, errorCode);
	}
	
	public String getErrorCode(){
		return this.errorCode;
	}
}
