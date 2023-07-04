package data.repository.currency;

import domain.model.currency.Currency;
import domain.model.currency.ICurrency;
import domain.model.currency.IExchangableCurrency;

public enum ECurrencies implements IExchangableCurrency{
	DOP(new Currency("DOP", "Dominican Peso", 1.0)),
	USD(new Currency("USD", "United States Dollar", 0.021)),
    EUR(new Currency("EUR", "Euro", 0.018)),
    GBP(new Currency("GBP", "British Pound", 0.015)),
    JPY(new Currency("JPY", "Japanese Yen", 2.32)),
    KRW(new Currency("KRW", "South Korean Won", 24.75));
	
	private final Currency currency;
	
	ECurrencies(Currency currency) {
		this.currency = currency;
	}

	@Override
	public ICurrency getCurrency() {
		return currency;
	}
}
