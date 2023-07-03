package domain.model.temperature.units;

import domain.model.temperature.ITemperatureUnit;

public class Celsius implements ITemperatureUnit {

    private double temperature;

    public Celsius() {}
    
    public Celsius(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public ETemperatureUnits getUnit() {
        return ETemperatureUnits.CELSIUS;
    }

    @Override
    public double convertToCelsius() {
        return temperature;
    }

    @Override
    public double convertToFahrenheit() {
        return (temperature * 9 / 5) + 32;
    }

    @Override
    public double convertToKelvin() {
        return temperature + 273.15;
    }

	@Override
	public void setTemperature(double temperature) {
		this.temperature = temperature;	
	}
}

