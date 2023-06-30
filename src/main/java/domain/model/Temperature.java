package domain.model;

import domain.repository.ExchangableItem;

public record Temperature(String simbol, String name) implements ExchangableItem{

}
