package hello.exception;

public class DataAccessException extends BaseException{

	private static final long serialVersionUID = 1L;
	private String errorCode="1000";

	public DataAccessException(){

	}

	public String getErrorCode(){
		return this.errorCode;
	}

	public DataAccessException(String message){
		super(message);
	}

	public DataAccessException(Throwable cause){
		super(cause);
	}

	public DataAccessException(String message, Throwable cause){
		super(message,cause);
	}
	
}
