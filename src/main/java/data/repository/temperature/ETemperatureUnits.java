package data.repository.temperature;

import domain.model.IExchangeableItem;

/**
 * Enumeration of temperature units.
 * Each unit has a description and a symbol.
 * This enum implements the {@link IExchangeableItem} interface
 * and provides methods to retrieve the description and symbol of each unit.
 */

public enum ETemperatureUnits implements IExchangeableItem {
    CELSIUS("Celsius", "C"),
    FAHRENHEIT("Fahrenheit", "F"),
    KELVIN("Kelvin", "K");

    private final String description;
    private final String symbol;

    ETemperatureUnits(String description, String symbol) {
        this.description = description;
        this.symbol = symbol;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String simbol() {
        return symbol;
    }
}