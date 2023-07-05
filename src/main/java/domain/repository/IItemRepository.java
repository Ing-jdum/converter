package domain.repository;

import java.util.List;
import domain.model.IExchangeableItem;

/**
 * Interface for an item repository.
 *
 * <p>Provides information about items in the repository.
 *
 * @apiNote Implementing classes should provide concrete implementations of the methods defined in this interface.
 */
public interface IItemRepository {

    /**
     * Retrieves the title of the repository.
     *
     * @return the title of the repository as a {@code String}.
     */
    String getTitle();

    /**
     * Retrieves a list of all exchangeable items in the repository.
     *
     * @return a list of exchangeable items as a {@code List<IExchangeableItem>}.
     */
    List<IExchangeableItem> getAllItems();
}