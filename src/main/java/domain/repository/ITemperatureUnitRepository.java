package domain.repository;

import java.util.Optional;

import data.repository.temperature.ETemperatureUnits;

/**
 * Represents a repository for temperature units. This interface defines methods
 * to retrieve temperature units based on their description.
 */
public interface ITemperatureUnitRepository {

	/**
	 * Retrieves a temperature unit based on its description.
	 *
	 * @param description the description of the temperature unit.
	 * @return an optional containing the temperature unit with the specified
	 *         description, or an empty optional if no matching temperature unit is
	 *         found.
	 */
	Optional<ETemperatureUnits> getTemperatureUnitByDescription(String description);
}
