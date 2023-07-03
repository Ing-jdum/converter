package domain.model.temperature;

import domain.model.temperature.units.ETemperatureUnits;

public interface ITemperatureUnit {
	public ETemperatureUnits getUnit();
	public double convertToCelsius();
	public double convertToFahrenheit();
	public double convertToKelvin();
	public void setTemperature(double temperature);
}
