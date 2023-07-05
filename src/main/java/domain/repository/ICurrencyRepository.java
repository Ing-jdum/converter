package domain.repository;

import java.util.Optional;

import domain.model.currency.Currency;

/**
 * Represents a repository for currency items. This interface provides methods
 * to retrieve currency items based on their names. Implementing classes should
 * provide the implementation details for retrieving the items.
 * 
 * <p>
 * Usage: To retrieve a currency item by its name, use the {@code getItemByName}
 * method. Pass the name of the currency as a string, and the method will return
 * an optional containing the corresponding currency item. If the currency item
 * is found, it will be wrapped in the optional; otherwise, an empty optional
 * will be returned.
 * 
 */
public interface ICurrencyRepository {
	/**
	 * Retrieves a currency item by its name.
	 * 
	 * @param name the name of the currency
	 * @return an optional containing the currency item if found, or an empty
	 *         optional if not found
	 */
	Optional<Currency> getItemByName(String name);
}
