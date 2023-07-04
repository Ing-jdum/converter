package domain.model.temperature.units;

import data.repository.temperature.ETemperatureUnits;

public interface ITemperatureUnit {
	public double convertToCelsius(double temperature);
	public double convertToFahrenheit(double temperature);
	public double convertToKelvin(double temperature);
	ETemperatureUnits getUnit();
}
