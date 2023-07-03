package domain.model.temperature;

import domain.repository.IExchangableItem;

public record Temperature(String simbol, String name, ITemperatureUnit unit) implements IExchangableItem {

}
