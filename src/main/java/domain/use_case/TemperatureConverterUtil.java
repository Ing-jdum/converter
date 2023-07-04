package domain.use_case;

import java.util.Optional;

import data.repository.TemperatureUnitRepositoryImpl;
import domain.model.temperature.units.ETemperatureUnits;

public class TemperatureConverterUtil {
	
	public static double convertTemperature(ETemperatureUnits sourceTemperature, ETemperatureUnits targetTemperature, double value) {
		double convertedTemperature = 0.0;
		switch(targetTemperature){
	        case CELSIUS:
	            convertedTemperature = sourceTemperature.getUnit().convertToCelsius(value);
	            break;
	        case FAHRENHEIT:
	            convertedTemperature = sourceTemperature.getUnit().convertToFahrenheit(value);
	            break;
	        case KELVIN:
	            convertedTemperature = sourceTemperature.getUnit().convertToKelvin(value);
	            break;
	        default:
	            System.out.println("Invalid temperature unit");
	            break;
	    }
		return convertedTemperature;
	}
	
	public static double convertTemperature(String sourceTemperature, String targetTemperature, double value) {
		Optional<ETemperatureUnits> sourceItem = 
        		TemperatureUnitRepositoryImpl.INSTANCE.getItemByName(sourceTemperature);
        Optional<ETemperatureUnits> targetItem = 
        		TemperatureUnitRepositoryImpl.INSTANCE.getItemByName(targetTemperature);
        double result = 0;

        if(sourceItem.isPresent() && targetItem.isPresent()) {
        	ETemperatureUnits sourceTemp = sourceItem.get();
        	ETemperatureUnits targetTemp = targetItem.get();
        	result = convertTemperature(sourceTemp, targetTemp, value);
        }
        return result;
	}
}
