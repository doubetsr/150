package gui;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;

/**
 * Demonstrate how text area works. This program illustrates: 
 * (1) how to create a text area
 * (2) how to set the scroll bar policy for a text area
 * (3) how to set the line wrapping policies
 * 
 * @author Sherri Harms
 *
 */
public class ListWindowWithTextArea extends JFrame{
	private JList<String> monthList;
	private JTextArea selectedMonth;
	// Create the month list
	private final String[] months = {"January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December"	};

	/**
	 * Create GUI
	 */
	public ListWindowWithTextArea(){
		// Set the title and close operation
		setTitle("List With Text Area Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the layout of the window
		setLayout(new BorderLayout());

		// Create the panel to hold the month list, text area, and the button
		JPanel monthPanel = buildMonthPanel();
		JPanel selectedMonthPanel = buildSelectedMonthPanel();
		JPanel buttonPanel = buildButtonPanel();

		// Put the above panels into the window
		add(monthPanel, BorderLayout.NORTH);
		add(selectedMonthPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		// Show the window
		pack();
		setVisible(true);
	}

	/**
	 * Create the panel holding the button
	 * 
	 * @return The created panel
	 */
	private JPanel buildButtonPanel(){
		// Create the button
		JButton button = new JButton("Get Selections");
		button.setToolTipText("Select the month");

		// Hook the button up with the listener
		button.addActionListener(new MyListener());

		// Create a panel and put the button in
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button);

		return buttonPanel;
	}

	/**
	 * Create a panel that hold the month list
	 * 
	 * @return The panel created
	 */
	private JPanel buildMonthPanel(){
		monthList = new JList<String>(months);
		monthList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		monthList.setVisibleRowCount(6);

		
		// Put the month list in a scroll pane and then put it into the panel
		JScrollPane sp = new JScrollPane(monthList);
		JPanel monthPanel = new JPanel();
		monthPanel.add(sp);

		return monthPanel;
	}

	/**
	 * Create the panel to hold the selected months
	 * 
	 * @return The created panel
	 */
	private JPanel buildSelectedMonthPanel(){
		// Create the panel
		JPanel selectedMonthPanel = new JPanel();

		// Create the text area and put it into the panel
		selectedMonth = new JTextArea(3, 10);
		JScrollPane sp = new JScrollPane(selectedMonth);
		selectedMonthPanel.add(sp);

		// Avoid long lines
		selectedMonth.setLineWrap(true);

		// Do not break a word from the middle
		selectedMonth.setWrapStyleWord(true);

		// Set the scroll pane policy
		//	sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//	sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//	sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

		// Set the font of the text area
		Font font = new Font("monospaced", Font.ITALIC|Font.BOLD, 32);
		selectedMonth.setFont(font);

		return selectedMonthPanel;
	}

	/**
	 * Create the event listener for the button
	 * 
	 * @author Sherri Harms
	 *
	 */
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// Set the selected items to the "selected month"
			int[] selectedIndices = monthList.getSelectedIndices();
			String s = "";
			for (int i=0;i<selectedIndices.length;i++)
			{
				int monthNumber = selectedIndices[i];
				s+= months[monthNumber]+" ";
			}

			// Put the string into the text area
			selectedMonth.setText(s);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListWindowWithTextArea lw = new ListWindowWithTextArea();
	}

}
