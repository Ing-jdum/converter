
package data.repository.currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.model.IExchangeableItem;
import domain.model.currency.Currency;
import domain.repository.ICurrencyRepository;
import domain.repository.IItemRepository;

/**
 * Represents a currency repository implementation. This enum serves as a
 * singleton implementation of the {@link IItemRepository} and
 * {@link ICurrencyRepository} interfaces. It provides methods to retrieve
 * currency items and their descriptions.
 * 
 * <p>
 * Usage: The repository instance can be accessed through the {@code INSTANCE}
 * field, which represents the singleton instance of the repository. To retrieve
 * all currencies, use the {@code getAllItems} method, which returns a list of
 * exchangeable currencies. To get the title of the repository, use the
 * {@code getTitle} method. To retrieve a specific currency item by its name,
 * use the {@code getItemByName} method.
 * 
 * @see Currency
 */
public enum CurrencyRepositoryImpl implements IItemRepository, ICurrencyRepository {
	INSTANCE;

	private String title = "Currency conversion";
	private List<IExchangeableItem> currencies;

	/**
	 * Constructs the currency repository and initializes the list of currencies.
	 */
	private CurrencyRepositoryImpl() {
		currencies = new ArrayList<>();
		currencies.add(new Currency("DOP", "Dominican Peso", 1.0));
		currencies.add(new Currency("USD", "United States Dollar", 0.021));
		currencies.add(new Currency("EUR", "Euro", 0.018));
		currencies.add(new Currency("GBP", "British Pound", 0.015));
		currencies.add(new Currency("JPY", "Japanese Yen", 2.32));
		currencies.add(new Currency("KRW", "South Korean Won", 24.75));
	}

	/**
	 * Retrieves all exchangeable currencies.
	 *
	 * @return a list of exchangeable currencies
	 */
	@Override
	public List<IExchangeableItem> getAllItems() {
		return currencies;
	}

	/**
	 * Retrieves the title of the currency repository.
	 *
	 * @return the title of the currency repository
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * Retrieves a currency item by its name.
	 *
	 * @param name the name of the currency
	 * @return an optional containing the currency item if found, or an empty
	 *         optional if not found
	 */
	@Override
	public Optional<Currency> getItemByName(String name) {
		return currencies.stream().filter(currency -> currency.description().equalsIgnoreCase(name))
				.map(Currency.class::cast).findFirst();
	}
}
