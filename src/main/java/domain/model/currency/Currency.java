package domain.model.currency;

import domain.model.IExchangeableItem;

/**
 * Represents a currency.
 * This record class implements the {@link IExchangeableItem} and {@link ICurrency} interfaces.
 *
 * @param symbol         The symbol or abbreviation of the currency.
 * @param description    The description or name of the currency.
 * @param exchangeValue  The exchange value of the currency.
 */
public record Currency (String simbol, String description, double exchangeValue) 
implements IExchangeableItem, ICurrency{
}
