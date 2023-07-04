package domain.model.currency;

import domain.model.IExchangableItem;

public record Currency (String simbol, String description, double exchangeValue) 
implements IExchangableItem, ICurrency{
}
