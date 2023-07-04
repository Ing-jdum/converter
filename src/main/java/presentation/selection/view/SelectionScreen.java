	package presentation.selection.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.model.IExchangableItem;
import domain.repository.IItemRepository;



public class SelectionScreen {
	
	private IItemRepository repository;
	
	public SelectionScreen(IItemRepository repository) {
		this.repository = repository;
	}

	public List<String> showSelectionDialog(){
		List<IExchangableItem> items = repository.getAllItems();
        List<String> selectedValues = new ArrayList<>();
		JComboBox<String> sourceItemComboBox = new JComboBox<>();
		JComboBox<String> targetItemComboBox = new JComboBox<>();
        
		for (IExchangableItem item : items) {
			sourceItemComboBox.addItem(item.description());
			targetItemComboBox.addItem(item.description());
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
        	selectedValues.add((String) sourceItemComboBox.getSelectedItem());
            selectedValues.add((String) targetItemComboBox.getSelectedItem());
            
        }
        
        return selectedValues;
	}
}
