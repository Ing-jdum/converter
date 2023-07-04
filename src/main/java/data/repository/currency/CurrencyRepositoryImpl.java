	package data.repository.currency;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import domain.model.IExchangableItem;
import domain.model.currency.Currency;
import domain.repository.ICurrencyRepository;
import domain.repository.IItemRepository;

public enum CurrencyRepositoryImpl implements IItemRepository, ICurrencyRepository {
	INSTANCE;
	
	private List<IExchangableItem> currencies = Stream.of(ECurrencies.values())
			.map(enumValue -> (IExchangableItem) enumValue.getCurrency())
			.toList();
	
    String title = "Currency conversion";
    
    private CurrencyRepositoryImpl() {}
    
    
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
                .filter(currency -> currency.description().equalsIgnoreCase(name))
                .map(Currency.class::cast)
                .findFirst();
    }
}


