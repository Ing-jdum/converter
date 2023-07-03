package domain.model.currency;

import domain.model.IExchangableItem;

public record Currency (String simbol, String name, double exchangeValue) 
implements IExchangableItem, ICurrency{
}
