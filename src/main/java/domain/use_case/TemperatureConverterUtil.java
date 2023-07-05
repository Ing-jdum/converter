package domain.use_case;

import java.util.Optional;

import data.repository.temperature.ETemperatureUnits;
import data.repository.temperature.TemperatureUnitRepositoryImpl;

public class TemperatureConverterUtil {
	
	private TemperatureConverterUtil() {}
	
	public static double convertTemperature(String sourceTemperature, String targetTemperature, double value) {
		Optional<ETemperatureUnits> sourceItem = 
        		TemperatureUnitRepositoryImpl.INSTANCE.getTemperatureUnitByDescription(sourceTemperature);
        Optional<ETemperatureUnits> targetItem = 
        		TemperatureUnitRepositoryImpl.INSTANCE.getTemperatureUnitByDescription(targetTemperature);
        double result = 0;
        if(sourceItem.isPresent() && targetItem.isPresent()) {
        	ETemperatureUnits sourceTemp = sourceItem.get();
        	ETemperatureUnits targetTemp = targetItem.get();
            double kelvinValue = convertTemperatureToKelvin(sourceTemp, targetTemp, value);
            result = convertTemperatureFromKelvin(sourceTemp, targetTemp, kelvinValue);
        }
        return result;
	}
	
	public static double convertTemperatureToKelvin(ETemperatureUnits sourceTemperature, ETemperatureUnits targetTemperature, double value) {
		double result = 0.0;
		switch(sourceTemperature){
	        case CELSIUS:
	        	result = celsiusToKelvin(value);
	            break;
	        case FAHRENHEIT:
	        	result = fahrenheitToKelvin(value);
	            break;
	        case KELVIN:
	        	result = value;
	            break;
	        default:
	            break;
	    }
		return result;
	}
	
	public static double convertTemperatureFromKelvin(ETemperatureUnits sourceTemperature, ETemperatureUnits targetTemperature, double value) {
		double result = value;
		switch(targetTemperature){
	        case CELSIUS:
	            result = kelvinToCelsius(result);
	            break;
	        case FAHRENHEIT:
	        	result = kelvinToFahrenheit(result);
	            break;
	        case KELVIN:
	            break;
	        default:
	            break;
		}
		return result;
	}
	
	public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
    
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
    
    public static double fahrenheitToKelvin(double fahrenheit) {
        double celsius = fahrenheitToCelsius(fahrenheit);
        return celsiusToKelvin(celsius);
    }
    
    public static double kelvinToFahrenheit(double kelvin) {
        double celsius = kelvinToCelsius(kelvin);
        return celsiusToFahrenheit(celsius);
    }
}
