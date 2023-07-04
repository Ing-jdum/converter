package domain.model.temperature.units;

import domain.model.IExchangableItem;

public enum ETemperatureUnits implements IExchangableItem, IExchangableUnit{
	CELSIUS("Celsius", "C", new Celsius()),
    FAHRENHEIT("Fahrenheit", "F", new Fahrenheit()),
    KELVIN("Kelvin", "K", new Kelvin());

    private final String description;
    private final String simbol;
    private final ITemperatureUnit unit;

    ETemperatureUnits(String description, String simbol, ITemperatureUnit unit) {
        this.description = description;
        this.simbol = simbol;
        this.unit = unit;
    }
    
    @Override
    public String description() {
        return description;
    }

	@Override
	public String simbol() {
		return simbol;
	}
	
	@Override
	public ITemperatureUnit getUnit() {
		return unit;
	}
}
