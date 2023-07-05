package app;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import domain.repository.IItemRepository;
import domain.use_case.TemperatureConverterUtil;
import presentation.continue_converting.view.ContinueConversionScreen;
import presentation.end_program.view.EndProgramScreen;
import presentation.result.view.ResultScreen;
import presentation.selection.view.SelectionScreen;
import presentation.value_to_convert.view.InputValueScreen;

/**
 * Represents a converter application. This class implements the
 * {@link IConverterApp} interface and provides the functionality to run the
 * converter application by interacting with the user through various screens.
 *
 * <p>
 * The main entry point of the application is the
 * {@link #run(IItemRepository, IConvertFunction)} method, which prompts the
 * user for input, performs the conversion using the provided repository and
 * conversion function, and displays the result to the user. The application
 * continues to run as long as the user chooses to continue converting values.
 *
 * <p>
 * Usage: To use this converter application, create an instance of the
 * {@code ConverterApp} class and invoke the
 * {@link #run(IItemRepository, IConvertFunction)} method, passing in an
 * implementation of the {@link IItemRepository} interface and an implementation
 * of the {@link IConvertFunction} interface.
 *
 * <p>
 * Example usage: Suppose you have an implementation of the
 * {@code CurrencyRepository} class that provides currency conversion rates, and
 * an implementation of the {@code CurrencyConverter} class that performs the
 * currency conversion. You can use the converter application as follows:
 *
 * <pre>{@code
 * IItemRepository repository = new CurrencyRepository();
 * IConvertFunction function = new CurrencyConverter();
 *
 * ConverterApp converterApp = new ConverterApp();
 * converterApp.run(repository, function);
 * }</pre>
 *
 * @see IConverterApp
 * @see IItemRepository
 * @see IConvertFunction
 */
public class ConverterApp implements IConverterApp {

	/**
	 * Runs the converter application using the provided item repository and
	 * conversion function. The application prompts the user for input, performs the
	 * conversion, and displays the result. The application continues to run as long
	 * as the user chooses to continue converting values.
	 *
	 * @param repository the item repository providing the conversion rates or data
	 * @param function   the conversion function to perform the conversion
	 */

	@Override
	public void run(IItemRepository repository, IConvertFunction function) {
		Optional<Double> valueToConvert;
		boolean keepConverting = Boolean.TRUE;
		while (keepConverting) {
			List<String> selectedVals = getSelectedValues(repository);
			valueToConvert = getValueToConvert();
			valueToConvert.ifPresent(val -> showValue(convertFunction(selectedVals, val.doubleValue(), function)));
			keepConverting = showContinueConversion();
		}
		showProgramEnded();
	}

	private List<String> getSelectedValues(IItemRepository repository) {
		SelectionScreen view = new SelectionScreen(repository);
		return view.showSelectionDialog();
	}

	private Optional<Double> getValueToConvert() {
		InputValueScreen view = new InputValueScreen();
		String value = view.showNumberInputDialog();

		if (StringUtils.isEmpty(value))
			return Optional.empty();
		return Optional.of(Double.parseDouble(value));
	}

	private void showValue(Double value) {
		ResultScreen.showDouble(value);
	}

	private double convertFunction(List<String> selectedValues, double inputValue, IConvertFunction function) {
		return function.convertValue(selectedValues.get(0), selectedValues.get(1), inputValue);
	}

	private boolean showContinueConversion() {
		return ContinueConversionScreen.showContinueConversion();
	}

	private void showProgramEnded() {
		EndProgramScreen.showMessage("Program ended");
	}

}
