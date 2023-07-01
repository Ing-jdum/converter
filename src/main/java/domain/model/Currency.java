package domain.model;

import domain.repository.IExchangableItem;

public record Currency (String simbol, String name, double exchangeValue) 
implements IExchangableItem{
}
