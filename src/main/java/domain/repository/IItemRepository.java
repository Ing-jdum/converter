package domain.repository;

import java.util.List;
import java.util.Optional;


public interface IItemRepository {
	String getTitle();
    List<IExchangableItem> getAllItems();
    Optional<IExchangableItem> getItemByName(String name);
}
