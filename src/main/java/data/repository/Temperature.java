package data.repository;

import domain.repository.IExchangableItem;

public record Temperature(String simbol, String name) implements IExchangableItem {

}
