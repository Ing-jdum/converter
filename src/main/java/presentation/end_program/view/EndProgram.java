package presentation.end_program.view;

import javax.swing.JOptionPane;

public class EndProgram {
	private EndProgram() {}
	public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
