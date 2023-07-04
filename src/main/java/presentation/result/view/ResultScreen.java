package presentation.result.view;

import javax.swing.JOptionPane;

public class ResultScreen {
	
	private ResultScreen() {}
	
	public static void showDouble(double value) {
        String message = "The conversion result is: " + value;
        JOptionPane.showMessageDialog(null, message);
    }
}
