package domain.repository;

import java.util.Optional;

import data.repository.temperature.ETemperatureUnits;

public interface ITemperatureUnitRepository {
	Optional<ETemperatureUnits> getTemperatureUnitByDescription(String description);
}
