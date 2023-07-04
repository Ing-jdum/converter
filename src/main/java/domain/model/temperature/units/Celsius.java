package domain.model.temperature.units;

import data.repository.temperature.ETemperatureUnits;
import domain.model.IExchangableItem;

public class Celsius implements ITemperatureUnit, IExchangableItem {

    @Override
    public double convertToCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double convertToFahrenheit(double temperature) {
        return (temperature * 9 / 5) + 32;
    }

    @Override
    public double convertToKelvin(double temperature) {
        return temperature + 273.15;
    }

	@Override
	public String description() {
		return "Celsius";
	}

	@Override
	public String simbol() {
		return "C";
	}

	@Override
	public ETemperatureUnits getUnit() {
		return ETemperatureUnits.CELSIUS;
	}
}

