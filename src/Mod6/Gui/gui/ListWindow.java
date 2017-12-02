package gui;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

/**
 * Show how a list works. This program illustrates:
 * (1) how to create a list
 * (2) how to add scroll bar to a list
 * (3) To respond to the event from a list, we need to implement ListSelectionListener
 * 
 * @author Sherri Harms
 *
 */
public class ListWindow extends JFrame{
	private JList<String> monthList;
	private JTextField selectedMonth;
	
	/**
	 * Create the GUI
	 */
	public ListWindow(){
		// Set the title and the close operation
		setTitle("List Demo");
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
		
		// Create a list
		String[] months = {"January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December"
		};	
		monthList = new JList<String>(months);
		monthList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Hook up the list with the listener
		monthList.addListSelectionListener(new MyListener());
		
		// Put the list into a scroll pane before putting it into the panel
	//	JScrollPane sp = new JScrollPane(monthList);
	//	monthPanel.add(sp);
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
	 * Build a listener to respond the selection event from the list
	 */
	private class MyListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e){
			// Get the selected item from the list of months
			String month = (String)monthList.getSelectedValue();

			// Set the selected value to the text field bottom
			selectedMonth.setText(month);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListWindow lw = new ListWindow();
	}

}
