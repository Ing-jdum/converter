import app.ConverterApp;
import app.IConvertFunction;
import data.repository.CurrencyRepositoryImpl;
import data.repository.TemperatureUnitRepositoryImpl;
import domain.use_case.CurrencyConverterUtil;
import domain.use_case.TemperatureConverterUtil;

public class App {

	public static void main(String[] args) {
		ConverterApp converterApp = new ConverterApp();
		IConvertFunction function = TemperatureConverterUtil::convertTemperature;
        converterApp.run(TemperatureUnitRepositoryImpl.INSTANCE, function);
        IConvertFunction functionC = CurrencyConverterUtil::convertCurrency;
        converterApp.run(CurrencyRepositoryImpl.INSTANCE, functionC);
    }

}
