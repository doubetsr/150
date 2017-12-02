package gui;
import javax.swing.*;    // Needed for Swing classes
import java.awt.*;       // Needed for Color class
import java.awt.event.*; // Needed for event listener interface

/**
 * This class demonstrates how to set the background color of
 * a panel and the foreground color of a label.
 */
public class ColorWindow extends JFrame {
	private JLabel messageLabel;		// A label to show message
	private JPanel panel;				// A panel to hold buttons and labels
	private JButton redButton;      // Changes color to red
	private JButton blueButton;     // Changes color to blue
	private JButton yellowButton;   // Changes color to yellow
	private JButton greenButton;	//Change to green

	/**
	 * Constructor
	 */
	public ColorWindow() {
		// Set the title bar text.
		setTitle("Colors");

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a label.
		messageLabel = new JLabel("Click a button to select a color.");

		// Create the three buttons.
		redButton = new JButton("Red");
		blueButton = new JButton("Blue");
		yellowButton = new JButton("Yellow");
		greenButton = new JButton("Green");

		// Register an event listener with all 3 buttons.
		ButtonListener bl = new ButtonListener();
		redButton.addActionListener(bl);
		blueButton.addActionListener(bl);
		yellowButton.addActionListener(bl);
		greenButton.addActionListener(bl);

		// Create a panel and add the components to it.
		panel = new JPanel();
//		panel.add(messageLabel);
		panel.add(yellowButton);
		panel.add(redButton);
		panel.add(messageLabel);
		panel.add(blueButton);
		panel.add(greenButton);
		// Add the panel to the content pane.
		add(panel);

		// Display the window.
		pack();
		setVisible(true);
	}

	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String stringCommand = e.getActionCommand();
				//getActionCommand for JButton by default is the text displayed
			if(stringCommand.equals("Red")) {
	//		if(e.getSource() == redButton) {
				panel.setBackground(Color.red);
				messageLabel.setForeground(Color.blue);
			} else if (stringCommand.equals("Blue")) {
		//	} else if (e.getSource() == blueButton) {
				panel.setBackground(Color.blue);
				messageLabel.setForeground(Color.yellow);
			} else if (stringCommand.equals("Yellow")) {
		//	}else if (e.getSource() == yellowButton) {
				panel.setBackground(Color.yellow);
				messageLabel.setForeground(Color.black);
			} else if (stringCommand.equals("Green")) {
		//	}else if (e.getSource() == greenButton) {
				panel.setBackground(Color.green);
				messageLabel.setForeground(Color.black);
			}

		}
	}

	public static void main(String[] args){

		ColorWindow cw = new ColorWindow();
	}
}

