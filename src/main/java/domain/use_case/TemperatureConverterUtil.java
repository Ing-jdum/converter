package domain.use_case;

import domain.model.temperature.Temperature;
import domain.model.temperature.units.ITemperatureUnit;

public class TemperatureConverterUtil {
	
	public double convertTemperature(ITemperatureUnit sourceTemperature, ITemperatureUnit targetTemperature, double value) {
		double convertedTemperature = 0.0;
		switch(targetTemperature.getUnit()){
	        case CELSIUS:
	            convertedTemperature = sourceTemperature.convertToCelsius(value);
	            break;
	        case FAHRENHEIT:
	            convertedTemperature = sourceTemperature.convertToFahrenheit(value);
	            break;
	        case KELVIN:
	            convertedTemperature = sourceTemperature.convertToKelvin(value);
	            break;
	        default:
	            System.out.println("Invalid temperature unit");
	            break;
	    }
		return convertedTemperature;
	}
	
	public double convertTemperature(Temperature sourceTemperature, Temperature targetTemperature, double value) {
		return convertTemperature(sourceTemperature.unit(), targetTemperature.unit(), value);
	}
}
