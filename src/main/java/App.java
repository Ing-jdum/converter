import app.ConverterApp;
import app.IConvertFunction;
import data.repository.currency.CurrencyRepositoryImpl;
import data.repository.temperature.TemperatureUnitRepositoryImpl;
import domain.use_case.CurrencyConverterUtil;
import domain.use_case.TemperatureConverterUtil;
import presentation.main_menu.view.MainMenu;
import presentation.main_menu.view.MainMenu.Option;

public class App {

	public static void main(String[] args) {
		ConverterApp converterApp = new ConverterApp();
		Option option = MainMenu.showOptionScreen();
		IConvertFunction function;
		switch(option){
			case TEMPERATURE:
				function = TemperatureConverterUtil::convertTemperature;
		        converterApp.run(TemperatureUnitRepositoryImpl.INSTANCE, function);
		        break;
			case CURRENCY:
				function = CurrencyConverterUtil::convertCurrency;
		        converterApp.run(CurrencyRepositoryImpl.INSTANCE, function);
		}		
    }

}
