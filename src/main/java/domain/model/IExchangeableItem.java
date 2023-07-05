package domain.model;

/**
 * Represents an exchangeable item with a description and a symbol. This
 * interface defines methods to retrieve the description and symbol of the item.
 */
public interface IExchangeableItem {

	/**
	 * Retrieves the description of the exchangeable item.
	 *
	 * @return the description of the item as a {@code String}.
	 */
	String description();

	/**
	 * Retrieves the symbol of the exchangeable item.
	 *
	 * @return the symbol of the item as a {@code String}.
	 */
	String simbol();
}
