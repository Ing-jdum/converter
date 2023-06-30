package data.repository;

import java.util.ArrayList;
import java.util.List;

import domain.model.Temperature;
import domain.repository.ExchangableItem;
import domain.repository.ItemRepository;

public enum TemperatureRepositoryImpl implements ItemRepository{
	INSTANCE;
	
	private List<ExchangableItem> temperatures;
	String title = "Temperature conversion";
	
	private TemperatureRepositoryImpl() {
        temperatures = new ArrayList<>();
        // Add temperatures to the list
        temperatures.add(new Temperature("F", "Farenheit"));
        temperatures.add(new Temperature("K", "Kelvin"));
        temperatures.add(new Temperature("C", "Celcius"));
    }
	
	@Override
	public List<ExchangableItem> getAllItems() {
		return temperatures;
	}

	@Override
	public ExchangableItem getItemByName(String name) {
		return temperatures.stream()
                .filter(temp -> temp.simbol().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
	}

	@Override
	public String getTitle() {
		return title;
	}

}
