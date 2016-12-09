package hello.exception;

import java.util.regex.Pattern;

public class InputValidator {
	
	private static final Pattern PATTERN_ALPHANUM = Pattern.compile("^[a-zA-Z0-9]+$");
	private static final Pattern PATTERN_PHONE = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$");
	private static final Pattern PATTERS_NREGEX = Pattern.compile("^[2-9]\\d{2}$");
	private static final Pattern PATTERS_XXXXREGEX = Pattern.compile("^\\d{4}$");
	
	public static boolean isValidPhone(String str) {
		return PATTERN_PHONE.matcher(str).matches();
	}
	
	public static boolean isValidNPA(String tnNumber) {
		String npa = getStrippedNumber(tnNumber).substring(0, 3);
		return PATTERS_NREGEX.matcher(npa).matches();
	}
	
	public static boolean isValidNXX(String tnNumber){
		String nxx = getStrippedNumber(tnNumber).substring(3, 6);
		return PATTERS_NREGEX.matcher(nxx).matches();
	}
	
	public static boolean isNXXSpecialCodes(String tnNumber){
		String nxx = getStrippedNumber(tnNumber).substring(3, 6);
		if(nxx.equals("958") || nxx.equals("959") || nxx.equals("950") || nxx.equals("976")){
			return false;
		}
		return true;
	}
	
	public static boolean isValidNXX11(String tnNumber){
		String nxx = getStrippedNumber(tnNumber).substring(3, 6);
		if(nxx.subSequence(1, 3).equals("11")){
			return false;
		}
		return true;
	}
	
	public static boolean isValidNXX555(String tnNumber){
		String nxx = getStrippedNumber(tnNumber).substring(3, 6);
		String xxxx = getStrippedNumber(tnNumber).substring(6, 10);
		if(nxx.equals("555")){
			if(Integer.parseInt(xxxx) >= 100 && Integer.parseInt(xxxx) <= 199){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidXXXX(String tnNumber){
		String xxxx = getStrippedNumber(tnNumber).substring(6, 10);
		return PATTERS_XXXXREGEX.matcher(xxxx).matches();
	}
	
	public static String getStrippedNumber(String tnNumber) {
		String strippedNumber = tnNumber.replaceAll("[^0-9]","");
		return strippedNumber;
	}
	
	public static void validateTelephoneNumber(String tnNumber) throws InputValidationException{
		
		if(!isValidPhone(tnNumber)){
			throwInvalidTN(tnNumber);
		}
		
		if(!isValidNPA(tnNumber)){
			throwInvalidTN_NPA(tnNumber);
		}
		
		if(!isValidNXX(tnNumber)){
			throwInvalidTN_NXX(tnNumber);
		}
		
		if(!isNXXSpecialCodes(tnNumber)){
			throwInvalidTN_NXX(tnNumber);
		}
		
		/*if(isValidNXX555(tnNumber)){
			throwInvalidTN_NXX(tnNumber);
		}*/
		
		if(!isValidNXX11(tnNumber)){
			throwInvalidTN_NXX(tnNumber);
		}
		
		if(!isValidXXXX(tnNumber)){
			throwInvalidTN_XXXX(tnNumber);
		}
		
	}
	
	
	
	
	public static void throwInvalidTNLength(String tnNumber) throws InputValidationException {
		throw new InputValidationException(tnNumber + " Telephone number is not of valid length");
	}
	
	public static void throwInvalidTN(String tnNumber) throws InputValidationException{
		throw new InputValidationException("Telephone number is not a valid number ");
	}
	
	public static void throwInvalidTN_NPA(String tnNumber) throws InputValidationException {
		throw new InputValidationException("Telephone number does not contain valid NPA");
	}
	
	public static void throwInvalidTN_NXX(String tnNumber) throws InputValidationException {
		throw new InputValidationException("Telephone number does not contain valid NXX");
	}
	
	public static void throwInvalidTN_XXXX(String tnNumber) throws InputValidationException {
		throw new InputValidationException("Telephone number does not contain valid XXXX");
	}
	
	public static void throwInvalid_NXX_N11(String tnNumber) throws InputValidationException {
		throw new InputValidationException("");
	}
	
	public static void throwInvalidTN_555(String tnNumber) throws InputValidationException {
		throw new InputValidationException("");
	}
	
	public static void throwInvalidTN_Identical(String tnNumber) throws InputValidationException {
		throw new InputValidationException("");
	}
	
	public static void throwInvalidFieldFormat(String tnNumber) throws InputValidationException {
		throw new InputValidationException(tnNumber+" is not formatted correctly or has invalid characters");
	}
	public static void throwMissingField(String tnNumber) throws InputValidationException {
		throw new InputValidationException(tnNumber+" is a required field");
	}
}
