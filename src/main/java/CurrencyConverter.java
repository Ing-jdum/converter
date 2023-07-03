import java.util.List;

import data.repository.CurrencyRepositoryImpl;
import domain.use_case.CurrencyConverterUtil;
import presentation.currency_selection.view.CurrencySelectionScreen;
import presentation.value_to_convert.view.InputValueScreen;

public class CurrencyConverter {

	public static void main(String[] args) {
		List<String> selectedValues;
		Double inputValue;
		Double result;
		
		CurrencySelectionScreen view = new CurrencySelectionScreen(CurrencyRepositoryImpl.INSTANCE);
        selectedValues = view.showSelectionDialog();
        System.out.println(selectedValues.toString());
        InputValueScreen view2 = new InputValueScreen();
        inputValue = Double.parseDouble(view2.showNumberInputDialog());
        result = CurrencyConverterUtil.convertCurrency(selectedValues.get(0), 
        		selectedValues.get(1), inputValue);
        System.out.println(result);
    }

}
