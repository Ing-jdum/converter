package data.repository.temperature;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import domain.model.IExchangableItem;
import domain.repository.IItemRepository;
import domain.repository.ITemperatureUnitRepository;

public enum TemperatureUnitRepositoryImpl implements IItemRepository, ITemperatureUnitRepository{
	INSTANCE;
	
	private List<IExchangableItem> temperatures = Stream.of(ETemperatureUnits.values())
			.map(IExchangableItem.class::cast)
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
	public Optional<ETemperatureUnits> getTemperatureUnitByDescription(String description) {
	    return Stream.of(ETemperatureUnits.values())
	            .filter(unit -> unit.description().equalsIgnoreCase(description))
	            .findFirst();
	}

}
