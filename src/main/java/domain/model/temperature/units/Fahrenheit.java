package domain.model.temperature.units;

public class Fahrenheit implements ITemperatureUnit{
		
	
	@Override
    public ETemperatureUnits getUnit() {
        return ETemperatureUnits.FAHRENHEIT;
    }

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
    
}
