package data.repository.temperature;

import domain.model.temperature.units.Celsius;
import domain.model.temperature.units.Fahrenheit;
import domain.model.temperature.units.IExchangableUnit;
import domain.model.temperature.units.ITemperatureUnit;
import domain.model.temperature.units.Kelvin;

public enum ETemperatureUnits implements IExchangableUnit{
	CELSIUS(new Celsius()),
    FAHRENHEIT(new Fahrenheit()),
    KELVIN(new Kelvin());


    private final ITemperatureUnit unit;

    ETemperatureUnits(ITemperatureUnit unit) {
        this.unit = unit;
    }

	@Override
	public ITemperatureUnit getUnit() {
		return unit;
	}
	
}
