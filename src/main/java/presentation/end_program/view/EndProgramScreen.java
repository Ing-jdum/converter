package presentation.end_program.view;

import javax.swing.JOptionPane;
/**
 * The EndProgramScreen class provides a utility method to display a message indicating the end of the program.
 */
public class EndProgramScreen {

    private EndProgramScreen() {
        // private constructor to prevent instantiation
    }

    /**
     * Displays a message indicating the end of the program.
     *
     * @param message the message to be displayed.
     */
	public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
