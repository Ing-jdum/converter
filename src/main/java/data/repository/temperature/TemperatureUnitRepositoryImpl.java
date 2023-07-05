package data.repository.temperature;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import domain.model.IExchangeableItem;
import domain.repository.IItemRepository;
import domain.repository.ITemperatureUnitRepository;

/**
 * Represents a temperature unit repository implementation. This enum serves as
 * a singleton implementation of the {@link IItemRepository} and
 * {@link ITemperatureUnitRepository} interfaces. It provides methods to
 * retrieve temperature units and their descriptions.
 * 
 * <p>
 * Usage: The repository instance can be accessed through the {@code INSTANCE}
 * field, which represents the singleton instance of the repository. To retrieve
 * all temperature units, use the {@code getAllItems} method, which returns a
 * list of exchangeable temperature units. To get the title of the repository,
 * use the {@code getTitle} method. To retrieve a specific temperature unit by
 * its description, use the {@code getTemperatureUnitByDescription} method.
 * 
 * @see ETemperatureUnits
 */
public enum TemperatureUnitRepositoryImpl implements IItemRepository, ITemperatureUnitRepository {
	INSTANCE;

	private List<IExchangeableItem> temperatures = Stream.of(ETemperatureUnits.values())
			.map(IExchangeableItem.class::cast).toList();

	private String title = "Temperature conversion";

	private TemperatureUnitRepositoryImpl() {
	}

	/**
	 * Retrieves all exchangeable temperature units.
	 *
	 * @return a list of exchangeable temperature units
	 */
	@Override
	public List<IExchangeableItem> getAllItems() {
		return temperatures;
	}

	/**
	 * Retrieves the title of the temperature unit repository.
	 *
	 * @return the title of the temperature unit repository
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * Retrieves a temperature unit by its description.
	 *
	 * @param description the description of the temperature unit
	 * @return an optional containing the temperature unit if found, or an empty
	 *         optional if not found
	 */
	@Override
	public Optional<ETemperatureUnits> getTemperatureUnitByDescription(String description) {
		return Stream.of(ETemperatureUnits.values()).filter(unit -> unit.description().equalsIgnoreCase(description))
				.findFirst();
	}
}
