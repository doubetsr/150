package gui;
import javax.swing.*;

import java.awt.event.*;

/**
 * Converts kilometers to miles
 */
public class KiloConverterWindow {
	private final double CONVERT = 0.6214;
	final int WINDOW_WIDTH = 350;
	final int WINDOW_HEIGHT = 250;
	private JTextField kiloTextField;	// Accepts kilometers
	private JFrame window ;

	/**
	 * In this constructor, we build this window
	 */
	public KiloConverterWindow() {
		window = new JFrame();
		// Set the title
		window.setTitle("A simple window");
		
		// Specify the action to do when the close button is clicked
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build the panel and add it to the frame
		JPanel panel = buildPanel();
		window.add(panel);

		// Set the size of the window
		window.pack();
		window.setVisible(true);

	}
	
	/**
	 * Build a panel to hold the components
	 *
	 * @return The panel built
	 */
	private JPanel buildPanel(){
		JLabel messageLabel = new JLabel("Enter a distance in kilometers: ");
		kiloTextField = new JTextField(10);
		JButton calcButton = new JButton("Calculate");
		//connect button to its listener
		calcButton.addActionListener(new CalcButtonListener());
		
		JPanel panel = new JPanel();
		
		panel.add(messageLabel);
		panel.add(kiloTextField);
		panel.add(calcButton);

		return panel;
	}
	
	/**
	 * A listener to handle the event of the "calcButton"
	 */
	private class CalcButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String input = kiloTextField.getText();
			double miles = Double.parseDouble(input) * CONVERT;
			JOptionPane.showMessageDialog(null, input+" kilometers is " + miles + " miles.");
		}
	}

	public static void main(String[] args){

		KiloConverterWindow kcw = new KiloConverterWindow();
	}
}
