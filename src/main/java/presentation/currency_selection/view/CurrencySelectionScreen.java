	package presentation.currency_selection.view;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.repository.TemperatureRepositoryImpl;
import domain.repository.ExchangableItem;
import domain.repository.ItemRepository;
import presentation.currency_selection.view_model.CurrencySelectionViewModel;


public class CurrencySelectionScreen {
	private CurrencySelectionViewModel viewModel = new CurrencySelectionViewModel();	
	private ItemRepository repository = new TemperatureRepositoryImpl();
	
	
	public void showSelectionDialog(){
		List<ExchangableItem> items = repository.getAllItems();
		JComboBox<String> sourceItemComboBox = new JComboBox<>();
		JComboBox<String> targetItemComboBox = new JComboBox<>();
		
		for (ExchangableItem item : items) {
			sourceItemComboBox.addItem(item.name());
			targetItemComboBox.addItem(item.name());
		}
		
		// Create labels for the dropdown menus
        JLabel fromLabel = new JLabel("From:");
        JLabel toLabel = new JLabel("To:");

        // Create the panel to hold the labels and dropdown menus
        JPanel panel = new JPanel();
        panel.add(fromLabel);
        panel.add(sourceItemComboBox);
        panel.add(toLabel);
        panel.add(targetItemComboBox);

		
		 // Show the JOptionPane with the double selection box
        int result = JOptionPane.showOptionDialog(
                null,
                panel,
                repository.getTitle(),
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null
        );
        
     // Check if the OK button was clicked
        if (result == JOptionPane.OK_OPTION) {
            // Get the selected items from the dropdown menus
            String sourceCurrency = (String) sourceItemComboBox.getSelectedItem();
            String targetCurrency = (String) targetItemComboBox.getSelectedItem();

            // Perform the currency conversion with the selected items
            viewModel.handleSelectedValue(sourceCurrency, targetCurrency);
        }
	}
}
