import java.util.List;

import presentation.currency_selection.view.CurrencySelectionScreen;
import presentation.value_to_convert.view.InputValueScreen;

public class CurrencyConverter {

	public static void main(String[] args) {
		List<String> selectedValues;
		
		CurrencySelectionScreen view = new CurrencySelectionScreen();
        selectedValues = view.showSelectionDialog();
        System.out.println(selectedValues.toString());
        InputValueScreen view2 = new InputValueScreen();
        System.out.println(view2.showNumberInputDialog());	
    }

}
