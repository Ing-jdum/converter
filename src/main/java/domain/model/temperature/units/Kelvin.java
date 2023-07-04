package domain.model.temperature.units;

public class Kelvin implements ITemperatureUnit {
		
	
	@Override
    public ETemperatureUnits getUnit() {
        return ETemperatureUnits.KELVIN;
    }

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
}

