package gui;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.event.*;

/**
 * Show how a list works. This program illustrates:
 * (1) how to create a combo box box
 * (2) the comb box event is to be handled by ActionListener
 * (3) how to get the user selection from a combo box
 * (4) how to make the combo box editable
 * 
 * @author Sherri Harms
 *
 */
public class ComboWindow extends JFrame{
	private JComboBox<String> monthList;
	private JTextField selectedMonth;
	// Create a list
	private final String[] months = {"January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December"
	};	

	/**
	 * Create the GUI
	 */
	public ComboWindow(){
		// Set the title and the close operation
		setTitle("Combo Box Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the layout
		setLayout(new BorderLayout());
		
		// build the two panels
		JPanel monthPanel = buildMonthPanel();
		monthPanel.setBorder(BorderFactory.createTitledBorder("Choose a month from the list"));
		JPanel selectedMonthPanel = buildSelectedMonthPanel();
		selectedMonthPanel.setBorder(BorderFactory.createTitledBorder("The month your have chosen"));
		
		// Put these two panels to the window
		add(monthPanel, BorderLayout.CENTER);
		add(selectedMonthPanel, BorderLayout.SOUTH);
		
		// Show the window
		pack();
		setVisible(true);
	}
	
	/**
	 * Create a panel to show the 12 months in a list
	 * 
	 * @return The panel created
	 */
	private JPanel buildMonthPanel(){
		// Create the month panel
		JPanel monthPanel = new JPanel();
		
		monthList = new JComboBox<String>(months);
		
		// Make this combo box editable
		monthList.setEditable(true);
		
		// Hook up the list with the listener
		monthList.addActionListener(new MyListener());
		
		// Put the combo box into the panel
		monthPanel.add(monthList);

		return monthPanel;
	}
	
	/**
	 * Create a panel to show the selected month
	 * 
	 * @return The panel created
	 */
	private JPanel buildSelectedMonthPanel(){
		// Create the panel
		JPanel selectedMonthPanel = new JPanel();
		Border b = BorderFactory.createTitledBorder("my border");
		selectedMonthPanel.setBorder(b);
		// Create a label
		JLabel label = new JLabel("You selected: ");
		
		// Create a field to hold the selected month
		selectedMonth = new JTextField(10);
		selectedMonth.setEditable(false);
		
		// Put the label and the text field into the panel
		selectedMonthPanel.add(label);
		selectedMonthPanel.add(selectedMonth);
		
		return selectedMonthPanel;
	}
	
	/** 
	 * Build a listener to respond the selection event from the combo box
	 */
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// Get the selected item from the list of months
			String month = (String)monthList.getSelectedItem();

			// Set the selected value to the text field bottom
			selectedMonth.setText(month);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComboWindow cw = new ComboWindow();
	}

}
