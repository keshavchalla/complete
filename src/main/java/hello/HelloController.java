package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.model.City;
import hello.model.WeatherObservation;
import hello.service.WeatherService;

@RestController
public class HelloController {
	
	@Autowired
	private WeatherService weatherService;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping("/weatherDetails")
    public WeatherObservation getWeatherDetails(){
    	//return weatherService.getWeatherDetails("43", "-2", "demo");
    	City city = new City();
    	WeatherObservation wo = new WeatherObservation();
    	wo.setClouds("clouds");
    	wo.setCloudsCode("cloudsCode");
    	wo.setCountryCode("USA");
    	wo.setICAO("ICAO");
    	wo.setDewPoint("dewPoint");
    	wo.setStationName("stationName");
    	wo.setObservation("observation");
    	city.setName("West Chester");
    	city.setAlias("WestChester");
    	wo.setCity(city);
    	return wo;
    }
    
}
