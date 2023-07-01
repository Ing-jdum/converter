package domain.model;

import domain.repository.IExchangableItem;

public record Temperature(String simbol, String name) implements IExchangableItem{

}
