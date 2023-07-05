package presentation.value_to_convert.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.lang3.StringUtils;

/**
 * The InputValueScreen class provides methods for displaying an input screen
 * and getting a numeric value from the user.
 */
public class InputValueScreen {
	private JPanel panel;
	private JButton convertButton;

	/**
	 * Constructs an InputValueScreen object.
	 */
	public InputValueScreen() {
		panel = new JPanel();
		panel.setLayout(new FlowLayout());

		convertButton = new JButton("Convert");

		convertButton.addActionListener(e -> {
			String valueText = showNumberInputDialog();
			// Perform conversion or handle the input value
		});

		panel.add(convertButton);
	}

	/**
	 * Gets the panel containing the input screen.
	 *
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Displays an input dialog for the user to enter a number.
	 *
	 * @return the input value as a string
	 */
	public String showNumberInputDialog() {
		String valueText = "";

		while (true) {
			valueText = JOptionPane.showInputDialog(panel, "Enter a number:");
			if (StringUtils.isEmpty(valueText) || valueText.matches("^-?\\d*\\.?\\d+$")) {
				break;
			} else {
				JOptionPane.showMessageDialog(panel, "Please enter a valid number.", "Invalid Input",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		return valueText;
	}
}
