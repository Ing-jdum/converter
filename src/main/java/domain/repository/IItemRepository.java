package domain.repository;

import java.util.List;
import java.util.Optional;

import domain.model.IExchangableItem;


public interface IItemRepository {
	String getTitle();
    List<IExchangableItem> getAllItems();
}
