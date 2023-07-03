package data.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.model.IExchangableItem;
import domain.model.currency.Currency;
import domain.repository.ICurrencyRepository;
import domain.repository.IItemRepository;

public enum CurrencyRepositoryImpl implements IItemRepository, ICurrencyRepository {
	INSTANCE;
	
    private List<IExchangableItem> currencies;
    String title = "Currency conversion";
    
    private CurrencyRepositoryImpl() {
        currencies = new ArrayList<>();
        // Add currencies to the list
        currencies.add(new Currency("DOP", "Dominican Peso", 1.0));
        currencies.add(new Currency("USD", "United States Dollar", 0.021));
        currencies.add(new Currency("EUR", "Euro", 0.018));
        currencies.add(new Currency("GBP", "British Pound", 0.015));
        currencies.add(new Currency("JPY", "Japanese Yen", 2.32));
        currencies.add(new Currency("KRW", "South Korean Won", 24.75));
    }
    
    
    @Override
    public List<IExchangableItem> getAllItems() {
        return currencies;
    }

	@Override
	public String getTitle() {
		return title;
	}
	
    @Override
    public Optional<Currency> getItemByName(String name) {
        return currencies.stream()
                .filter(currency -> currency.name().equalsIgnoreCase(name))
                .map(Currency.class::cast)
                .findFirst();
    }
}


