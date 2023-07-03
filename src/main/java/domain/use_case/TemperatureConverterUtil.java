package domain.use_case;

import domain.model.temperature.ITemperatureUnit;

public class TemperatureConverterUtil {
	
	public double convertTemperature(ITemperatureUnit sourceTemperature, ITemperatureUnit targetTemperature) {
		double convertedTemperature = 0.0;
		switch(targetTemperature.getUnit()){
	        case CELSIUS:
	            convertedTemperature = sourceTemperature.convertToCelsius();
	            break;
	        case FAHRENHEIT:
	            convertedTemperature = sourceTemperature.convertToFahrenheit();
	            break;
	        case KELVIN:
	            convertedTemperature = sourceTemperature.convertToKelvin();
	            break;
	        default:
	            System.out.println("Invalid temperature unit");
	            break;
	    }
		return convertedTemperature;
	}
}
