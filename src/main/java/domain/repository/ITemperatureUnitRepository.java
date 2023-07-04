package domain.repository;

import java.util.Optional;

import data.repository.temperature.ETemperatureUnits;
import domain.model.temperature.units.ITemperatureUnit;

public interface ITemperatureUnitRepository {
	Optional<ITemperatureUnit> getItemByName(String name);

}
