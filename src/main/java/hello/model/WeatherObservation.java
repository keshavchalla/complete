package hello.model;

public class WeatherObservation {

	private long elevation;
	private float lng;
	private String observation;
	private String ICAO;
	private String clouds;
	private String dewPoint;
	private String cloudsCode;
	private String datetime;
	private String countryCode;
	private String temperature;
	private String humidity;
	private String stationName;
	private String weatherCondition;
	private String windDirection;
	private String hectoPascAltimeter;
	private float windSpeed;
	private float lat;
	private City city;
	
	public long getElevation() {
		return elevation;
	}
	public void setElevation(long elevation) {
		this.elevation = elevation;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getICAO() {
		return ICAO;
	}
	public void setICAO(String iCAO) {
		ICAO = iCAO;
	}
	public String getClouds() {
		return clouds;
	}
	public void setClouds(String clouds) {
		this.clouds = clouds;
	}
	public String getDewPoint() {
		return dewPoint;
	}
	public void setDewPoint(String dewPoint) {
		this.dewPoint = dewPoint;
	}
	public String getCloudsCode() {
		return cloudsCode;
	}
	public void setCloudsCode(String cloudsCode) {
		this.cloudsCode = cloudsCode;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getWeatherCondition() {
		return weatherCondition;
	}
	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public String getHectoPascAltimeter() {
		return hectoPascAltimeter;
	}
	public void setHectoPascAltimeter(String hectoPascAltimeter) {
		this.hectoPascAltimeter = hectoPascAltimeter;
	}
	public float getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
}
