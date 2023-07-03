package domain.repository;

import java.util.Optional;

import domain.model.currency.Currency;

public interface ICurrencyRepository {
	Optional<Currency> getItemByName(String name);
}
