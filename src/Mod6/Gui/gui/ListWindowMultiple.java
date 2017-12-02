package gui;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.event.*;

/**
 * This program illustrates: 
 * (1) how to create a list
 * (2) how to add scroll bar to a list
 * (3) how to choose multiple items simultaneously from the list
 * (4) how to obtain selected items from a list
 * (5) how to add items to a list
 *  
 * @author Sherri Harms
 *
 */
public class ListWindowMultiple extends JFrame{
	private JList<String> monthList;			// The list to hold the months
	private JList<String> selectedMonth;		// The list to hold selected months
	private final String[] months = {"January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December"};

	/**
	 * Create the GUI
	 */
	public ListWindowMultiple(){
		
		// Set the title and close operation
		setTitle("List Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the panels
		JPanel monthPanel = buildMonthPanel();
		monthPanel.setBorder(BorderFactory.createTitledBorder("Choose one or more months from the list"));
		JPanel selectedMonthPanel = buildSelectedMonthPanel();
		selectedMonthPanel.setBorder(BorderFactory.createTitledBorder("The months that you have selected"));
		JPanel buttonPanel = buildButtonPanel();
		
		// Set the layout of the window
		setLayout(new BorderLayout());
		
		// Put panels into the window
		add(monthPanel, BorderLayout.NORTH);
		add(selectedMonthPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		// Show the window
		pack();
		setVisible(true);
	}
	
	/**
	 * Create a panel to hold the "Get Selections" button
	 * 
	 * @return the panel created
	 */
	private JPanel buildButtonPanel(){
		// Create the button
		JButton button = new JButton("Get Selections");
		
		// Use an image in the button
		ImageIcon icon = new ImageIcon("lions.jpg");
		button.setIcon(icon);

		//or:
//		JButton button = new JButton("Get Selections", icon);
//		JButton button = new JButton("Get Selections");
	    button.setHorizontalTextPosition(SwingConstants.CENTER);
	  button.setVerticalTextPosition(SwingConstants.CENTER);
		
		// Set the mnemonic for this button
		button.setMnemonic(KeyEvent.VK_S);  //Alt-E
		
		// Set a tool tip for this button
		//Scroll mouse over button - what do you see?
		button.setToolTipText("Select the months that you like");
		
		// Hook up this button with the the listener
		button.addActionListener(new MyListener());
		
		// Create a panel and put this button in
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button);
		
		return buttonPanel;
	}
	
	/**
	 * Build the panel to hold the 12 months
	 * 
	 * @return The panel created
	 */
	private JPanel buildMonthPanel(){
		// Create a list to hold the 12 months
		monthList = new JList<String>(months);
		monthList.setVisibleRowCount(6);
		
		// Allow the user to choose multiple months at the same time
		monthList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// Add this list to a scroll pane before putting it into the month panel
		JScrollPane sp = new JScrollPane(monthList);
		JPanel monthPanel = new JPanel();
		monthPanel.add(sp);
		
		return monthPanel;
	}
	
	/**
	 * Create the panel to hold the selected months
	 * 
	 * @return The panel created
	 */
	private JPanel buildSelectedMonthPanel(){
		// Create a panel
		JPanel selectedMonthPanel = new JPanel();

		// Create an empty list and put it into the panel
		selectedMonth = new JList<String>();
		selectedMonth.setVisibleRowCount(3);
		JScrollPane sp = new JScrollPane(selectedMonth);
		selectedMonthPanel.add(sp);
		
		return selectedMonthPanel;
	}
	

	/**
	 * Create a listener to handle the events from the button.
	 * 
	 * @author Sherri Harms
	 *
	 */
	private class MyListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			// Set the selected items to the "selected month"
			int[] selectedIndices = monthList.getSelectedIndices();
			String[] selectedData = new String[selectedIndices.length];
			for (int i=0;i<selectedIndices.length;i++)
			{
				int monthNumber = selectedIndices[i];
				selectedData[i] = months[monthNumber];
			}
			selectedMonth.setListData(selectedData);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListWindowMultiple lw = new ListWindowMultiple();
	}

}
