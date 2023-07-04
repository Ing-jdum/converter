package presentation.main_menu.view;

import javax.swing.JOptionPane;

public class MainMenu {
	public enum Option {
        TEMPERATURE, CURRENCY
    }

    public static Option showOptionScreen() {
        Option[] options = Option.values();
        return (Option) JOptionPane.showInputDialog(
                null,
                "Select a conversion:",
                "Main Menu",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );
    }
}
