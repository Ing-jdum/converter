package data.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.model.IExchangableItem;
import domain.model.temperature.Temperature;
import domain.model.temperature.units.Celsius;
import domain.model.temperature.units.ETemperatureUnits;
import domain.model.temperature.units.Fahrenheit;
import domain.model.temperature.units.Kelvin;
import domain.repository.IItemRepository;
import domain.repository.ITemperatureUnitRepository;

public enum TemperatureUnitRepositoryImpl implements IItemRepository, ITemperatureUnitRepository{
	INSTANCE;
	
	private List<IExchangableItem> temperatures;
	String title = "Temperature conversion";
	
	private TemperatureUnitRepositoryImpl() {
        temperatures = new ArrayList<>();
        // Add temperatures to the list
        temperatures.add(new Temperature("C", ETemperatureUnits.CELSIUS.getName(), new Celsius()));
        temperatures.add(new Temperature("F", ETemperatureUnits.FAHRENHEIT.getName(), new Fahrenheit()));
        temperatures.add(new Temperature("K", ETemperatureUnits.KELVIN.getName(), new Kelvin()));
    }
	
	@Override
	public List<IExchangableItem> getAllItems() {
		return temperatures;
	}

	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public Optional<Temperature> getItemByName(String name) {
		return temperatures.stream()
                .filter(temp -> temp.name().equalsIgnoreCase(name))
                .map(Temperature.class::cast)
                .findFirst();
	}

}
