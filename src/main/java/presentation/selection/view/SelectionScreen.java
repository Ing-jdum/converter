package presentation.selection.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.model.IExchangeableItem;
import domain.repository.IItemRepository;

/**
 * The SelectionScreen class provides methods for displaying a selection dialog.
 */
public class SelectionScreen {
	private IItemRepository repository;

	/**
	 * Constructs a SelectionScreen object with the specified item repository.
	 *
	 * @param repository the item repository to be used
	 */
	public SelectionScreen(IItemRepository repository) {
		this.repository = repository;
	}

	/**
	 * Displays a selection dialog to choose items from the repository.
	 *
	 * @return a list of selected item descriptions
	 */
	public List<String> showSelectionDialog() {
		List<String> selectedValues = new ArrayList<>();
		List<IExchangeableItem> items = repository.getAllItems();
		JComboBox<String> sourceItemComboBox = new JComboBox<>();
		JComboBox<String> targetItemComboBox = new JComboBox<>();

		items.stream().map(IExchangeableItem::description).forEach(description -> {
			sourceItemComboBox.addItem(description);
			targetItemComboBox.addItem(description);
		});

		// Create labels for the dropdown menus
		JLabel fromLabel = new JLabel("From:");
		JLabel toLabel = new JLabel("To:");

		// Create the panel to hold the labels and dropdown menus
		JPanel panel = new JPanel();
		panel.add(fromLabel);
		panel.add(sourceItemComboBox);
		panel.add(toLabel);
		panel.add(targetItemComboBox);

		// Show the JOptionPane with the selection dialog
		int result = JOptionPane.showOptionDialog(null, panel, repository.getTitle(), JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, null, null);

		// Check if the OK button was clicked
		if (result == JOptionPane.OK_OPTION) {
			selectedValues.add((String) sourceItemComboBox.getSelectedItem());
			selectedValues.add((String) targetItemComboBox.getSelectedItem());
		}

		return selectedValues;
	}
}
