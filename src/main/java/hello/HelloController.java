package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.model.City;
import hello.model.CustomerDetails;
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
    
    @RequestMapping("/customerDetails")
    public List<CustomerDetails> getCustomerDetails() {
    	List<CustomerDetails> cdList = new ArrayList<CustomerDetails>();
    	CustomerDetails cd1 = new CustomerDetails();
    	cd1.setAccountNumber("8919100010000017");
    	cd1.setTnType("UNKNOWN");
    	
    	CustomerDetails cd2 = new CustomerDetails();
    	cd2.setAccountNumber("8210100200055975");
    	cd2.setTnType("UNKNOWN");
    	
    	CustomerDetails cd3 = new CustomerDetails();
    	cd3.setAccountNumber("8919100011045425");
    	cd3.setTnType("UNKNOWN");
    	
    	cdList.add(cd1);
    	cdList.add(cd2);
    	cdList.add(cd3);
    	return cdList;
    }
    
}
