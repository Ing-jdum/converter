package app;

import domain.repository.IItemRepository;

/**
 * Represents a converter application.
 * This interface defines a method to run the converter application using a specified item repository
 * and conversion function.
 *
 * <p>Usage:
 * Implement this interface to define a custom converter application.
 * The run method should take in an item repository and a conversion function, and perform the conversion
 * based on user input or any other logic specific to the application.
 *
 * <p>Example implementation:
 * Suppose you have a currency converter application that converts between different currencies.
 * You can implement this interface as follows:
 *
 * <pre>{@code
 * public class CurrencyConverterApp implements IConverterApp {
 *     @Override
 *     public void run(IItemRepository repository, IConvertFunction function) {
 *         // Implement the conversion logic using the repository and function
 *         // For example, prompt the user for input, retrieve the conversion rates from the repository,
 *         // and use the conversion function to perform the conversion
 *         // Display the result to the user or perform any other necessary actions
 *     }
 * }
 * }</pre>
 *
 * @see IItemRepository
 * @see IConvertFunction
 */
public interface IConverterApp {
    /**
     * Runs the converter application using the specified item repository and conversion function.
     *
     * @param repository  the item repository providing the conversion rates or data
     * @param function    the conversion function to perform the conversion
     */
    void run(IItemRepository repository, IConvertFunction function);
}
