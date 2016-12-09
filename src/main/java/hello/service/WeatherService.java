package hello.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hello.exception.InputValidationException;
import hello.exception.InputValidator;
import hello.exception.ProcessorException;
import hello.model.Response;
import hello.model.WeatherObservation;

@Service
public class WeatherService {

	@Autowired
	private RestTemplate restTemplate ;
	
	private Response response;
	
	//private String weatherUrl="http://api.geonames.org/findNearByWeatherJSON";
	
	private String weatherUrl = "http://api.geonames.org/findNearByWeatherJSON?lat=43&lng=-2&username=demo";
	
	public WeatherObservation getWeatherDetails(String lat, String lng, String username){
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("lat", "43"); 
		urlVariables.put("lng", "-2"); 
		urlVariables.put("username", "demo"); 
		ResponseEntity<WeatherObservation> responseEntity = this.restTemplate.getForEntity(weatherUrl, WeatherObservation.class, urlVariables);
		return responseEntity.getBody();
	}
	
	public void getExceptionMessage(String message) throws ProcessorException {
		if(message.equals("Test")){
			throw new ProcessorException("My Exception Test");
		}
	}
	
	public void validateTelephoneNumber(String tnNumber) throws InputValidationException{
		InputValidator.validateTelephoneNumber(tnNumber);
	}
}
