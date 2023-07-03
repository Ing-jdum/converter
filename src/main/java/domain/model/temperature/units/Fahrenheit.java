package domain.model.temperature.units;

import domain.model.temperature.ITemperatureUnit;

public class Fahrenheit implements ITemperatureUnit{
	
	private double temperature;
	
	public Fahrenheit() {}
	
	public Fahrenheit(double temperature) {
		this.temperature = temperature;
	}
	
	@Override
    public ETemperatureUnits getUnit() {
        return ETemperatureUnits.FAHRENHEIT;
    }

    @Override
    public double convertToCelsius() {
        return (temperature - 32) * 5 / 9;
    }

    @Override
    public double convertToFahrenheit() {
        return temperature;
    }

    @Override
    public double convertToKelvin() {
        return (temperature + 459.67) * 5 / 9;
    }

	@Override
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
    
}
