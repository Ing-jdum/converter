package domain.use_case;

import data.repository.temperature.ETemperatureUnits;
import data.repository.temperature.TemperatureUnitRepositoryImpl;

/**
 * Utility class for converting temperatures between different units of
 * measurement. This class provides methods to convert temperatures from one
 * unit to another, such as Celsius, Fahrenheit, and Kelvin. The conversions are
 * based on mathematical formulas and use the Kelvin unit as an intermediate
 * step.
 * 
 * <p>
 * Usage: To convert a temperature from a source unit to a target unit, use the
 * {@code convertTemperature} method. Pass the source and target temperature
 * units as strings (e.g., "Celsius", "Fahrenheit") and the value to be
 * converted. The method will return the converted value.
 * 
 * <p>
 * Note: The temperature conversion is performed based on the formulas derived
 * from scientific calculations. There might be slight variations due to
 * rounding errors or differences in precision.
 * 
 * @see ETemperatureUnits
 * @see TemperatureUnitRepositoryImpl
 */

public class TemperatureConverterUtil {

	private TemperatureConverterUtil() {
	}

	/**
	 * Converts the temperature from the source temperature unit to the target
	 * temperature unit.
	 *
	 * @param sourceTemperature the source temperature unit.
	 * @param targetTemperature the target temperature unit.
	 * @param value             the value to be converted.
	 * @return the converted value.
	 */
	public static double convertTemperature(String sourceTemperature, String targetTemperature, double value) {
		return TemperatureUnitRepositoryImpl.INSTANCE.getTemperatureUnitByDescription(sourceTemperature)
				.flatMap(sourceItem -> TemperatureUnitRepositoryImpl.INSTANCE
						.getTemperatureUnitByDescription(targetTemperature).map(targetItem -> {
							double kelvinValue = convertTemperatureToKelvin(sourceItem, targetItem, value);
							return convertTemperatureFromKelvin(sourceItem, targetItem, kelvinValue);
						}))
				.orElse(0.0);
	}

	private static double convertTemperatureToKelvin(ETemperatureUnits sourceTemperature,
			ETemperatureUnits targetTemperature, double value) {
		double result;
		result = switch (sourceTemperature) {
		case CELSIUS -> celsiusToKelvin(value);
		case FAHRENHEIT -> fahrenheitToKelvin(value);
		case KELVIN -> value;
		default -> throw new IllegalArgumentException("Unsupported conversion: " + sourceTemperature);
		};
		return result;
	}

	private static double convertTemperatureFromKelvin(ETemperatureUnits sourceTemperature,
			ETemperatureUnits targetTemperature, double value) {
		double result = value;
		result = switch (targetTemperature) {
		case CELSIUS -> kelvinToCelsius(result);
		case FAHRENHEIT -> kelvinToFahrenheit(result);
		case KELVIN -> result;
		default -> throw new IllegalArgumentException("Unsupported conversion: " + targetTemperature);
		};
		return result;
	}

	private static double celsiusToFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	private static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	private static double celsiusToKelvin(double celsius) {
		return celsius + 273.15;
	}

	private static double kelvinToCelsius(double kelvin) {
		return kelvin - 273.15;
	}

	private static double fahrenheitToKelvin(double fahrenheit) {
		double celsius = fahrenheitToCelsius(fahrenheit);
		return celsiusToKelvin(celsius);
	}

	private static double kelvinToFahrenheit(double kelvin) {
		double celsius = kelvinToCelsius(kelvin);
		return celsiusToFahrenheit(celsius);
	}
}
