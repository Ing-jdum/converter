package domain.model.temperature.units;

public enum ETemperatureUnits {
	CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit"),
    KELVIN("Kelvin");

    private final String name;

    ETemperatureUnits(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
