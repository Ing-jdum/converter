package domain.repository;

import java.util.List;


public interface IItemRepository {
	String getTitle();
    List<IExchangableItem> getAllItems();
    IExchangableItem getItemByName(String name);
}
