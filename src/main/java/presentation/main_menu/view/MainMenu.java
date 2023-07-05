package presentation.main_menu.view;

import javax.swing.JOptionPane;

/**
 * The MainMenu class represents the main menu screen for selecting a conversion
 * option.
 */
public class MainMenu {
	/**
	 * The Option enum represents the available conversion options.
	 */
	public enum Option {
		TEMPERATURE, CURRENCY
	}

	/**
	 * Displays the option screen and allows the user to select a conversion option.
	 *
	 * @return the selected conversion option
	 */
	public static Option showOptionScreen() {
		Option[] options = Option.values();
		return (Option) JOptionPane.showInputDialog(null, "Select a conversion:", "Main Menu",
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}
}
