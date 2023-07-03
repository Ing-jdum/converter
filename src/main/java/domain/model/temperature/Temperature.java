package domain.model.temperature;

import domain.model.IExchangableItem;
import domain.model.temperature.units.ITemperatureUnit;

public record Temperature(String simbol, String name, ITemperatureUnit unit) 
implements IExchangableItem, ITemperature {

}
