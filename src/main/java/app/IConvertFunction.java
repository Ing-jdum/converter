package app;

/**
 * Represents a conversion function.
 * This interface defines a method to convert a value from one unit to another.
 *
 * <p>Usage:
 * Implement this interface to define a custom conversion function.
 * The conversion function should take in two unit strings representing the source and target units,
 * and an input value to be converted. It should return the converted value.
 *
 * <p>Example implementation:
 * Suppose you have a temperature conversion function that converts from Celsius to Fahrenheit.
 * You can implement this interface as follows:
 *
 * <pre>{@code
 * public class CelsiusToFahrenheitConverter implements IConvertFunction {
 *     @Override
 *     public double convertValue(String sourceUnit, String targetUnit, double inputValue) {
 *         if (sourceUnit.equals("C") && targetUnit.equals("F")) {
 *             return (inputValue * 9 / 5) + 32;
 *         } else {
 *             throw new IllegalArgumentException("Unsupported conversion: " + sourceUnit + " to " + targetUnit);
 *         }
 *     }
 * }
 * }</pre>
 *
 */
public interface IConvertFunction {
    /**
     * Converts a value from the source unit to the target unit.
     *
     * @param sourceUnit  the source unit
     * @param targetUnit  the target unit
     * @param inputValue  the value to be converted
     * @return the converted value
     * @throws IllegalArgumentException if the conversion is not supported
     */
    double convertValue(String sourceUnit, String targetUnit, double inputValue);
}
