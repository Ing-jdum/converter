package app;

import java.util.List;
import java.util.Optional;

import domain.repository.IItemRepository;

public interface IConverterApp {
	public void run(IItemRepository repository, IConvertFunction function);
	public List<String> getSelectedValues(IItemRepository repository);
	public Optional<Double> getValueToConvert();
	public double convertFunction(List<String> selectedValues, double inputValue, IConvertFunction function);
	public void showValue(Double value);
	public boolean showContinueConversion();
	public void showProgramEnded();
}
