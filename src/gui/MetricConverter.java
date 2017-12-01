package gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * Demonstrate how radio buttons work. Key points in this example:
 * (1) How to create radio buttons
 * (2) How to group radio buttons
 * (3) How to add radio buttons to a panel
 * (4) How to respond radio button events
 *
 * @author Sherri Harms
 *
 */
public class MetricConverter extends JFrame{
	private JTextField kiloTextField;
	private JRadioButton milesButton;
	private JRadioButton feetButton;
	
	/**
	 * Create GUI
	 */
	public MetricConverter(){
		// Set the title and the close operation
		setTitle("Metric Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build the panel to hold the text field and radio buttons
		JPanel panel = buildPanel();
		add(panel);
		
		// show the window
		pack();
		setVisible(true);
	}
	
	/**
	 * Create the panel
	 * 
	 * @return The created panel
	 */
	private JPanel buildPanel(){
		// Create a label and a textfield, and put them into the top panel
		JLabel messageLabel = new JLabel("Enter a distance in kilometers");
		kiloTextField = new JTextField(10);
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.add(messageLabel);
		topPanel.add(kiloTextField);
		
		// Create two radio buttons
		milesButton = new JRadioButton("Convert to miles");
		feetButton = new JRadioButton("Convert to feet");
		
		// Put them into the same group
	ButtonGroup group = new ButtonGroup();
		group.add(milesButton);
		group.add(feetButton);
		
		// Hook up the radio buttons with the event listener
		MyListener listener = new MyListener();
		milesButton.addActionListener(listener);
		feetButton.addActionListener(listener);
		
		// Put the buttons into the bottom panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(milesButton);
		bottomPanel.add(feetButton);

		// Add a border around the bottom panel
//	Border b = BorderFactory.createTitledBorder("radio buttons");
//	Border b = BorderFactory.createBevelBorder(NORMAL, Color.black, Color.yellow);
//		bottomPanel.setBorder(b);

		// use a grid layout panel to hold the bottom panel and top panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.add(topPanel);
		panel.add(bottomPanel);
		
		return panel;
	}
	
	/**
	 * The listener to respond to radio button events
	 * 
	 * @author Sherri Harms
	 *
	 */
	private class MyListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			// Get the input
			String input = kiloTextField.getText();
			
			// Convert the input into miles or feet
			double result = 0.0;
			if(e.getSource() == milesButton){
				result = Double.parseDouble(input) * 0.6124;
			}else if(e.getSource() == feetButton){
				result = Double.parseDouble(input) * 3281.0;
			}
			
			// Show the conversion result
			JOptionPane.showMessageDialog(null, String.valueOf(result));
		}
	}

		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MetricConverter window = new MetricConverter();
	}

}
