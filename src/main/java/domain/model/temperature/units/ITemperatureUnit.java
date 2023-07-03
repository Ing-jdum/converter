package domain.model.temperature.units;

public interface ITemperatureUnit {
	public ETemperatureUnits getUnit();
	public double convertToCelsius(double temperature);
	public double convertToFahrenheit(double temperature);
	public double convertToKelvin(double temperature);
}
