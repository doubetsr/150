package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Show how check box works. This example illustrates:
 * (1) how to create check boxes
 * (2) To respond check box events, you need to implement "ItemListener"
 * 
 * Use WindowBuilder to design the layout, and set the actionPerformed.
 * @author Sherri Harms
 *
 */
public class ColorCheckBoxWindow extends JFrame{
	private JCheckBox redBox;
	private JCheckBox yellowBox;
	private JPanel panel;
	private JButton resetButton;
	
	public ColorCheckBoxWindow(){
		// Create title and close operation
		setTitle("Color Check Boxes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build the panel
		buildPanel();
		getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		yellowBox.setBackground(Color.WHITE);
		redBox.setBackground(Color.WHITE);			
	
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yellowBox.setSelected(false);
				redBox.setSelected(false);
				panel.setBackground(Color.WHITE);
				yellowBox.setBackground(Color.WHITE);
				redBox.setBackground(Color.WHITE);	
	}
		});
		resetButton.setMnemonic('s');
		resetButton.setToolTipText("Reset");
		panel.add(resetButton);

		// Show the window
		pack();
		setVisible(true);
		
	}
	
	/**
	 * Build the panel
	 */
	private void buildPanel() {
		// Create the panel
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		// Create a label message
		JLabel messageLabel = new JLabel("Select the check boxes to change colors");
		panel.add(messageLabel);
		
		// Create the check boxes
		yellowBox = new JCheckBox("yellow background");
		redBox = new JCheckBox("red background");
		
		// Hook up the boxes with the event listener
		MyListener listener = new MyListener();
		yellowBox.addItemListener(listener);
		redBox.addItemListener(listener);
		
		// Put the boxes into the panel
		panel.add(yellowBox);
		panel.add(redBox);
	}

	/**
	 * Create the event listener
	 * 
	 * @author Sherri Harms
	 *
	 */
	private class MyListener implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			// Change the background appropriately
			if (e.getSource() == yellowBox){
				if (yellowBox.isSelected()){
					panel.setBackground(Color.YELLOW);
					yellowBox.setBackground(Color.YELLOW);
					redBox.setBackground(Color.YELLOW);
				} else {
					panel.setBackground(Color.LIGHT_GRAY);
					yellowBox.setBackground(Color.LIGHT_GRAY);
					redBox.setBackground(Color.LIGHT_GRAY);			
				}
			} else if (e.getSource() == redBox){
				if (redBox.isSelected()){
					panel.setBackground(Color.RED);
					yellowBox.setBackground(Color.RED);
					redBox.setBackground(Color.RED);
				} else {
					panel.setBackground(Color.BLACK);
					yellowBox.setBackground(Color.BLACK);
					redBox.setBackground(Color.BLACK);			
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ColorCheckBoxWindow window = new ColorCheckBoxWindow();
	}

}
