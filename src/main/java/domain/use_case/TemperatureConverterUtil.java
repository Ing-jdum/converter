package domain.use_case;

import java.util.Optional;

import data.repository.TemperatureUnitRepositoryImpl;
import domain.model.currency.Currency;
import domain.model.temperature.Temperature;
import domain.model.temperature.units.ITemperatureUnit;

public class TemperatureConverterUtil {
	
	public static double convertTemperature(ITemperatureUnit sourceTemperature, ITemperatureUnit targetTemperature, double value) {
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
	
	public static double convertTemperature(Temperature sourceTemperature, Temperature targetTemperature, double value) {
		return convertTemperature(sourceTemperature.unit(), targetTemperature.unit(), value);
	}
	
	public static double convertTemperature(String sourceTemperature, String targetTemperature, double value) {
		Optional<Temperature> sourceItem = TemperatureUnitRepositoryImpl.INSTANCE.getItemByName(sourceTemperature);
		Optional<Temperature> targetItem = TemperatureUnitRepositoryImpl.INSTANCE.getItemByName(targetTemperature);
		double result = 0;
		
		if(sourceItem.isPresent() && targetItem.isPresent()) {
        	Temperature sourceTemp = sourceItem.get();
        	Temperature targetTemp = targetItem.get();
        	result =  convertTemperature(sourceTemp, targetTemp, value);
        }
		
		return result;
	}
}
