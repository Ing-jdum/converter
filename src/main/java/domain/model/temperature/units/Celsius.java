package domain.model.temperature.units;

public class Celsius implements ITemperatureUnit {

    public Celsius() {}
    

    @Override
    public ETemperatureUnits getUnit() {
        return ETemperatureUnits.CELSIUS;
    }

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
}

