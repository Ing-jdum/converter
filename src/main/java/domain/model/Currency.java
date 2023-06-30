package domain.model;

import domain.repository.ExchangableItem;

public record Currency (String simbol, String name, double exchangeValue) 
implements ExchangableItem{
}
