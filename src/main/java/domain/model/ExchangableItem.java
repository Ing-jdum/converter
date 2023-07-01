package domain.model;

import domain.repository.IExchangableItem;

public record ExchangableItem (String name, String simbol) implements IExchangableItem {
}
