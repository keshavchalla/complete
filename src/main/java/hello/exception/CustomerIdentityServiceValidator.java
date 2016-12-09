package hello.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class CustomerIdentityServiceValidator {

	protected static final Pattern NOT_ALL_IDENTICAL_DIGITS = Pattern.compile("^(\\d)(?!\\1{9})\\d{9}$");
	protected static final Pattern AREA_CODE_IS_NOT_0_OR_1 = Pattern.compile("^[^01](\\d){9}$");
	protected static final Pattern AREA_CODE_IS_NOT_999 = Pattern.compile("^[^9](\\d){9}|9[^9](\\d){8}|99[^9](\\d){7}$");
	protected static final Pattern AREA_CODE_IS_NOT_555 = Pattern.compile("^[^5](\\d){9}|5[^5](\\d){8}|55[^5](\\d){7}$");
	protected static final Pattern PH_NO_DOES_NOT_START_WITH_0_OR_1 = Pattern.compile("^(\\d){3}[^01](\\d){6}$");
	protected static final Pattern PH_NO_DOES_NOT_START_WITH_555 = Pattern.compile("^(\\d){3}([^5]\\d{6}|5[^5]\\d{5}|55[^5]\\d{4})$");
	
	protected static List<Pattern> patterns;

	static {
		List<Pattern> initialPatterns = new ArrayList<Pattern>();
		initialPatterns.add(NOT_ALL_IDENTICAL_DIGITS);
		initialPatterns.add(AREA_CODE_IS_NOT_0_OR_1);
		initialPatterns.add(AREA_CODE_IS_NOT_999);
		initialPatterns.add(AREA_CODE_IS_NOT_555);
		initialPatterns.add(PH_NO_DOES_NOT_START_WITH_0_OR_1);
		initialPatterns.add(PH_NO_DOES_NOT_START_WITH_555);
		patterns = Collections.unmodifiableList(initialPatterns);
	}

	public void validateGetAccountTNs(String phoneNumber) throws InputValidationException {
		boolean isValid = true;
		for (Pattern p : patterns) {
			if (!p.matcher(phoneNumber).matches()) {
				isValid = false;
				break;
			}
		}
		if (!isValid) {
			throw new InputValidationException("Telephone number is not a valid number ");
		}
	}
}
