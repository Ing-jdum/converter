package domain.repository;

import java.util.List;

import domain.model.Currency;


public interface ItemRepository {
	String getTitle();
    List<ExchangableItem> getAllItems();
    ExchangableItem getItemByName(String name);
}
