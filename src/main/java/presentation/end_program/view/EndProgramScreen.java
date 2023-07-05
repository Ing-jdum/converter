package presentation.end_program.view;

import javax.swing.JOptionPane;

public class EndProgramScreen {
	private EndProgramScreen() {}
	public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
