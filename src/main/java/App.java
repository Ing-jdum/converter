import java.util.List;

import data.repository.CurrencyRepositoryImpl;
import domain.use_case.CurrencyConverterUtil;
import presentation.selection.view.SelectionScreen;
import presentation.value_to_convert.view.InputValueScreen;

public class App {

	public static void main(String[] args) {
		List<String> selectedValues;
		Double inputValue;
		Double result;
		
		SelectionScreen view = new SelectionScreen(CurrencyRepositoryImpl.INSTANCE);
        selectedValues = view.showSelectionDialog();
        System.out.println(selectedValues.toString());
        InputValueScreen view2 = new InputValueScreen();
        inputValue = Double.parseDouble(view2.showNumberInputDialog());
        result = CurrencyConverterUtil.convertCurrency(selectedValues.get(0), 
        		selectedValues.get(1), inputValue);
        System.out.println(result);
    }

}
