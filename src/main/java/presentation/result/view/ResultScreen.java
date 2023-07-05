package presentation.result.view;

import javax.swing.JOptionPane;

/**
 * The ResultScreen class provides methods for displaying conversion results.
 */
public class ResultScreen {
	/**
	 * Displays the conversion result as a double value.
	 *
	 * @param value the conversion result to be displayed
	 */
	public static void showDouble(double value) {
		String message = "The conversion result is: " + value;
		JOptionPane.showMessageDialog(null, message);
	}
}
