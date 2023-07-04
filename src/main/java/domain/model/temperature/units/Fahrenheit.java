package domain.model.temperature.units;

import data.repository.temperature.ETemperatureUnits;
import domain.model.IExchangableItem;

public class Fahrenheit implements ITemperatureUnit, IExchangableItem{
		
    @Override
    public double convertToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    @Override
    public double convertToFahrenheit(double temperature) {
        return temperature;
    }

    @Override
    public double convertToKelvin(double temperature) {
        return (temperature + 459.67) * 5 / 9;
    }

	@Override
	public String description() {
		return "Fahrenheit";
	}

	@Override
	public String simbol() {
		return "F";
	}
	
	@Override
	public ETemperatureUnits getUnit() {
		return ETemperatureUnits.FAHRENHEIT;
	}

}
