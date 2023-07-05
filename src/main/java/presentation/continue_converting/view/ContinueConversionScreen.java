package presentation.continue_converting.view;

import javax.swing.JOptionPane;

/**
 * The ContinueConversionScreen class provides a utility method to display a
 * dialog asking the user if they want to continue converting.
 */
public class ContinueConversionScreen {

	private ContinueConversionScreen() {
		// private constructor to prevent instantiation
	}

	/**
	 * Displays a dialog asking the user if they want to continue converting.
	 *
	 * @return true if the user chooses to continue converting, false otherwise.
	 */
	public static boolean showContinueConversion() {
		int choice = JOptionPane.showOptionDialog(null, "Do you want to continue converting?", "Continue Conversion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		return choice == JOptionPane.YES_OPTION;
	}

}
