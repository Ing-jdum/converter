package domain.repository;

import java.util.Optional;

import domain.model.temperature.units.ETemperatureUnits;

public interface ITemperatureUnitRepository {
	Optional<ETemperatureUnits> getItemByName(String name);

}
