package domain.model.temperature.units;

import domain.model.temperature.ITemperatureUnit;

public class Kelvin implements ITemperatureUnit {
	
	private double temperature;
	
	
	public Kelvin(double temperature) {
		this.temperature = temperature;
	}
	
	
    @Override
    public String getName() {
        return "Kelvin";
    }

    @Override
    public double convertToCelsius() {
        return this.temperature - 273.15;
    }

    @Override
    public double convertToFahrenheit() {
        return (this.temperature - 273.15) * 9 / 5 + 32;
    }
    
    @Override
    public double convertToKelvin() {
        return this.temperature;
    }
}

