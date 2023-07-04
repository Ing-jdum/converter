package data.repository.temperature;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import domain.model.IExchangableItem;
import domain.model.temperature.units.ITemperatureUnit;
import domain.repository.IItemRepository;
import domain.repository.ITemperatureUnitRepository;

public enum TemperatureUnitRepositoryImpl implements IItemRepository, ITemperatureUnitRepository{
	INSTANCE;
	
	private List<IExchangableItem> temperatures = Stream.of(ETemperatureUnits.values())
			.map(enumValue -> (IExchangableItem) enumValue.getUnit())
			.toList();
			
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
	public Optional<ITemperatureUnit> getItemByName(String name) {
		return temperatures.stream()
                .filter(temp -> temp.description().equalsIgnoreCase(name))
                .map(ITemperatureUnit.class::cast)
                .findFirst();
	}

}
