package domain.model.temperature.units;

import data.repository.temperature.ETemperatureUnits;
import domain.model.IExchangableItem;

public class Kelvin implements ITemperatureUnit, IExchangableItem {

    @Override
    public double convertToCelsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double convertToFahrenheit(double temperature) {
        return (temperature - 273.15) * 9 / 5 + 32;
    }
    
    @Override
    public double convertToKelvin(double temperature) {
        return temperature;
    }

	@Override
	public String description() {
		return "Kelvin";
	}

	@Override
	public String simbol() {
		return "K";
	}
	
	@Override
	public ETemperatureUnits getUnit() {
		return ETemperatureUnits.KELVIN;
	}
	
}

