package data.repository.temperature;

import domain.model.IExchangableItem;

public enum ETemperatureUnits implements IExchangableItem {
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