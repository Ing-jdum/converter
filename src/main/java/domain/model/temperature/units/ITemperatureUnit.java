package domain.model.temperature.units;

public interface ITemperatureUnit {
	public double convertToCelsius(double temperature);
	public double convertToFahrenheit(double temperature);
	public double convertToKelvin(double temperature);
}
