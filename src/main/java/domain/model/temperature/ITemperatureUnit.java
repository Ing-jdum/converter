package domain.model.temperature;

public interface ITemperatureUnit {
	public String getName();
	public double convertToCelsius();
	public double convertToFahrenheit();
	public double convertToKelvin();
}
