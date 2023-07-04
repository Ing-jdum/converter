package presentation.value_to_convert.view;

import java.awt.FlowLayout;

import org.apache.commons.lang3.StringUtils;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class InputValueScreen {
    private JPanel panel;
    private JButton convertButton;

    public InputValueScreen() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        convertButton = new JButton("Convert");

        convertButton.addActionListener(e -> {
            String valueText = showNumberInputDialog();
        });

        panel.add(convertButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String showNumberInputDialog() {
        String valueText = "";

        while (true) {
            valueText = JOptionPane.showInputDialog(panel, "Enter a number:");
            if(StringUtils.isEmpty(valueText) || valueText.matches("^-?\\d*\\.?\\d+$")) {
            	break;
            } 
            else{
            	JOptionPane.showMessageDialog(panel, "Please enter a valid number.", 
                		"Invalid Input", JOptionPane.WARNING_MESSAGE);;
            } 	
        }
        return valueText;
    }

}



