package presentation.continue_converting.view;

import javax.swing.JOptionPane;

public class ContinueConversion {
	
	private ContinueConversion() {}
	
	public static boolean showContinueConversion() {
		int choice = JOptionPane.showOptionDialog(
		         null,
		         "Do you want to continue converting?",
		         "Continue Conversion",
		         JOptionPane.YES_NO_OPTION,
		         JOptionPane.QUESTION_MESSAGE,
		         null,
		         null,
		         null
		 );
		
		return choice == JOptionPane.YES_OPTION;
	}
	 
}
