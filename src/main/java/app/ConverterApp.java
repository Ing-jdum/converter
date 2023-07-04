package app;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import domain.repository.IItemRepository;
import domain.use_case.TemperatureConverterUtil;
import presentation.result.view.ResultScreen;
import presentation.selection.view.SelectionScreen;
import presentation.value_to_convert.view.InputValueScreen;

public class ConverterApp implements IConverterApp{

	@Override
	public void run(IItemRepository repository, IConvertFunction function) {
		List<String> selectedVals = getSelectedValues(repository);
		Optional<Double> valueToConvert = getValueToConvert();
		valueToConvert.ifPresent(val -> {
			showValue(convertFunction(selectedVals, val.doubleValue(), function));
		});
	}

	@Override
	public List<String> getSelectedValues(IItemRepository repository) {
		SelectionScreen view = new SelectionScreen(repository);
		return view.showSelectionDialog();
	}

	@Override
	public Optional<Double> getValueToConvert() {
		InputValueScreen view = new InputValueScreen();
		String value = view.showNumberInputDialog();
		
		if (StringUtils.isEmpty(value)) return Optional.empty();
		return Optional.of(Double.parseDouble(value));
	}

	@Override
	public void showValue(Double value) {
		ResultScreen.showDouble(value);
	}

	@Override
	public double convertFunction(List<String> selectedValues, double inputValue, IConvertFunction function) {
		return	function.convertValue(selectedValues.get(0), 
        		selectedValues.get(1), inputValue);
	}

}
