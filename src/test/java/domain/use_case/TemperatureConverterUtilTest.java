package domain.use_case;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TemperatureConverterUtilTest {

	@Test
	void testConvertTemperature() {
		double value;
		double expectedValue;
		double convertedValue;
		final double TOLERANCE = 0.001;

		// Test Celsius to Fahrenheit
		value = 25.0;
		expectedValue = 77;
		convertedValue = TemperatureConverterUtil.convertTemperature("Celsius", "Fahrenheit", value);
		assertEquals(expectedValue, convertedValue, TOLERANCE);

		// Test Celsius to Kelvin
		value = 25.0;
		expectedValue = 298.15;
		convertedValue = TemperatureConverterUtil.convertTemperature("Celsius", "Kelvin", value);
		assertEquals(expectedValue, convertedValue, TOLERANCE);

		// Test Celsius to Celsius
		value = 25.0;
		expectedValue = 25.0;
		convertedValue = TemperatureConverterUtil.convertTemperature("Celsius", "Celsius", value);
		assertEquals(expectedValue, convertedValue, TOLERANCE);

		// Test Fahrenheit to Celsius
		value = 77.0;
		expectedValue = 25.0;
		convertedValue = TemperatureConverterUtil.convertTemperature("Fahrenheit", "Celsius", value);
		assertEquals(expectedValue, convertedValue, TOLERANCE);

		// Test Fahrenheit to Kelvin
		value = 77.0;
		expectedValue = 298.15;
		convertedValue = TemperatureConverterUtil.convertTemperature("Fahrenheit", "Kelvin", value);
		assertEquals(expectedValue, convertedValue, TOLERANCE);

		// Test Fahrenheit to Fahrenheit
		value = 77.0;
		expectedValue = 77.0;
		convertedValue = TemperatureConverterUtil.convertTemperature("Fahrenheit", "Fahrenheit", value);
		assertEquals(expectedValue, convertedValue, TOLERANCE);

		// Test Kelvin to Celsius
		value = 298.15;
		expectedValue = 25.0;
		convertedValue = TemperatureConverterUtil.convertTemperature("Kelvin", "Celsius", value);
		assertEquals(expectedValue, convertedValue, TOLERANCE);

		// Test Kelvin to Fahrenheit
		value = 298.15;
		expectedValue = 77.0;
		convertedValue = TemperatureConverterUtil.convertTemperature("Kelvin", "Fahrenheit", value);
		assertEquals(expectedValue, convertedValue, TOLERANCE);

		// Test Kelvin to Kelvin
		value = 298.15;
		expectedValue = 298.15;
		convertedValue = TemperatureConverterUtil.convertTemperature("Kelvin", "Kelvin", value);
		assertEquals(expectedValue, convertedValue, TOLERANCE);

	}

}
