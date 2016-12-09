package hello.exception;

public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;
	protected ErrorCode errorCode;
	
	public BaseException(){
		
	}
	
	public BaseException(String message){
		super(message);
	}
	
	public BaseException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public BaseException(String message, ErrorCode errorCode){
		super(message);
		this.errorCode = errorCode;
	}
	
	public BaseException(Throwable cause){
		super(cause);
	}
	
	public BaseException(Throwable cause, ErrorCode errorCode){
		super(cause);
		this.errorCode = errorCode;
	}
	
	public BaseException(String message, Throwable cause){
		super(message,cause);
	}
	
	public BaseException(String message, Throwable cause, ErrorCode errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}
}
