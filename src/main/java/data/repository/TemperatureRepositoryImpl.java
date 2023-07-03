package data.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.model.temperature.Temperature;
import domain.model.temperature.units.Celsius;
import domain.model.temperature.units.Fahrenheit;
import domain.model.temperature.units.Kelvin;
import domain.repository.IExchangableItem;
import domain.repository.IItemRepository;

public enum TemperatureRepositoryImpl implements IItemRepository{
	INSTANCE;
	
	private List<IExchangableItem> temperatures;
	String title = "Temperature conversion";
	
	private TemperatureRepositoryImpl() {
        temperatures = new ArrayList<>();
        // Add temperatures to the list
        temperatures.add(new Temperature("F", "Farenheit", new Fahrenheit()));
        temperatures.add(new Temperature("K", "Kelvin", new Kelvin()));
        temperatures.add(new Temperature("C", "Celsius", new Celsius()));
    }
	
	@Override
	public List<IExchangableItem> getAllItems() {
		return temperatures;
	}

	@Override
	public Optional<IExchangableItem> getItemByName(String name) {
		return temperatures.stream()
                .filter(temp -> temp.simbol().equalsIgnoreCase(name))
                .findFirst();
	}

	@Override
	public String getTitle() {
		return title;
	}

}
