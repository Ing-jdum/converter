package domain.repository;

import java.util.Optional;

import domain.model.temperature.Temperature;

public interface ITemperatureRepository {
	Optional<Temperature> getItemByName(String name);

}
