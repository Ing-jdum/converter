package domain.model.temperature;

import domain.model.IExchangableItem;

public record Temperature(String simbol, String name, ITemperatureUnit unit) 
implements IExchangableItem, ITemperature {

}
