package data.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import domain.model.IExchangableItem;
import domain.model.temperature.units.ETemperatureUnits;
import domain.repository.IItemRepository;
import domain.repository.ITemperatureUnitRepository;

public enum TemperatureUnitRepositoryImpl implements IItemRepository, ITemperatureUnitRepository{
	INSTANCE;
	
	ETemperatureUnits[] units = ETemperatureUnits.values();
	private List<IExchangableItem> temperatures = Arrays.asList(units);
	String title = "Temperature conversion";
	
	private TemperatureUnitRepositoryImpl() {}
	
	@Override
	public List<IExchangableItem> getAllItems() {
		return temperatures;
	}

	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public Optional<ETemperatureUnits> getItemByName(String name) {
		return temperatures.stream()
                .filter(temp -> temp.description().equalsIgnoreCase(name))
                .map(ETemperatureUnits.class::cast)
                .findFirst();
	}

}
