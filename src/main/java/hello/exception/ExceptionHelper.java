package hello.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExceptionHelper {

	public static String getErrorText(String message, String errorCode) {
		Map<String, String> errMap = new HashMap<String, String>();
		errMap.put("code", errorCode);
		errMap.put("desc", message);
		return toJson(errMap);
	}

	/**
	 * Common exceptions Handler for service errors
	 *
	 * @param message
	 * @param errorCode
	 * @return
	 */
	public static ResponseEntity<?> handleServiceExceptions(String message, String errorCode) {
		String errorJson = ExceptionHelper.getErrorText(message,errorCode);
		return evaluateExceptions(errorJson);
	}
	
	public static ResponseEntity<?> handleServiceExceptions(Exception exception) {
		String errorCode = null;
		if (exception instanceof DataAccessException) {
			errorCode = ((DataAccessException) exception).getErrorCode();
		}else if(exception instanceof ProcessorException) {
			errorCode = ((ProcessorException) exception).getErrorCode();
		}else if(exception instanceof InputValidationException) {
			errorCode = ((InputValidationException) exception).getErrorCode();
		}
		return evaluateExceptions(ExceptionHelper.getErrorText(exception.getMessage(),errorCode));
	}

	/**
	 * @param message
	 * @param errorCode
	 * @return
	 */
	private static ResponseEntity<String> evaluateExceptions(String message) {
		return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * convert an object to a json string
	 *
	 * @param
	 * @return
	 */
	public static String toJson(Object amap) {
		String json = null;
		if (amap != null) {
			try {
				json = (new ObjectMapper()).writeValueAsString(amap);
			} catch (Exception ex) {
				json = "{ \"msg\": " + json.toString() + "}";
			}
		}
		return json;
	}
	
}
