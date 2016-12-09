package hello.exception;

public class ProcessorException extends BaseException {

	private static final long serialVersionUID = 1L;
	//private String errorCode="1001";
	
	
	private String errorCode = "10001";
	
	public ProcessorException(){
		
	}

	public ProcessorException(String message){
		super(message);
	}
	
	public ProcessorException(ErrorCode errorCode) {
		super(errorCode);
	}

	public ProcessorException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

	public ProcessorException(Throwable cause, ErrorCode errorCode) {
		super(cause, errorCode);
	}

	public ProcessorException(String message, Throwable cause, ErrorCode errorCode) {
		super(message, cause, errorCode);
	}
	
	public String getErrorCode(){
		return this.errorCode;
	}
}
