package domain.model.currency;

/**
 * Interface for a currency.
 *
 * <p>
 * Represents a currency and provides methods to retrieve exchange value.
 *
 */
public interface ICurrency {

	/**
	 * Retrieves the exchange value of the currency.
	 *
	 * @return the exchange value of the currency as a {@code double}.
	 */
	double exchangeValue();
}
