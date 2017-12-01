package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class MenuWindow extends JFrame{
	JMenuItem fileMenuItem;
	JMenuItem colorMenuItem;
	JMenuItem exitMenuItem;
	JMenuItem helpMenuItem;
	JMenuItem aboutMenuItem;
	
	/**
	 * Build GUI
	 */
	public MenuWindow(){
		// Set the title and close operation
		setTitle("Example Menu System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the menu bar and put it in the window
		JMenuBar bar = buildMenuBar();
		setJMenuBar(bar);
		
		// Create a label and put it in the window
		JLabel label = new JLabel("Use the menu to change my color.");
		label.setPreferredSize(new Dimension(400, 200));
		add(label);
		
		// Show the window
		pack();
		setVisible(true);
	}
	
	/**
	 * Create a menu bar
	 * 
	 * @return The created menu bar
	 */
	private JMenuBar buildMenuBar(){
		// Create a menu bar
		JMenuBar menuBar = new JMenuBar();

		// Call "buildFileMenu()" to create a menu and add it into the menu bar
		JMenu fileMenu = buildFileMenu();		
		menuBar.add(fileMenu);
		
		Label whiteSpace = new Label("                        ");
		menuBar.add(whiteSpace);
		
		JMenu mnHelp = buildHelpMenu();
		menuBar.add(mnHelp);
	
		return menuBar;
	}
	
	/**
	 * Create the file menu
	 * 
	 * @return The created file menu
	 */
	private JMenu buildFileMenu(){
		// Create
		JMenu fileMenu = new JMenu("File");
		
		// Create the menu items
		fileMenuItem = new JMenuItem("Open File");
		colorMenuItem = new JMenuItem("Choose Color");
		exitMenuItem = new JMenuItem("Exit");
	
		// Add these menu items into fileMenu
		fileMenu.add(fileMenuItem);
		fileMenu.add(colorMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		
		// Hook up the menu items with the listener
		MyListener listener = new MyListener();
		exitMenuItem.addActionListener(listener);
		fileMenuItem.addActionListener(listener);
		colorMenuItem.addActionListener(listener);
		
		return fileMenu;
	}
	
	/**
	 * Create the help menu
	 * @return The created help menu
	 */
	private JMenu buildHelpMenu(){
		// Create
		JMenu helpMenu = new JMenu("Help");
		
		helpMenu.setMnemonic('h');
		helpMenu.setHorizontalAlignment(SwingConstants.RIGHT);
		
		helpMenuItem = new JMenuItem("View Help");
		helpMenu.add(helpMenuItem);
		
		aboutMenuItem = new JMenuItem("About This Program");
		helpMenu.add(aboutMenuItem);
		// Hook up the menu items with the listener
		MyHelpListener helpListener = new MyHelpListener();
		helpMenuItem.addActionListener(helpListener);
		aboutMenuItem.addActionListener(helpListener);
		
		return helpMenu;
	}

	
	/**
	 * To handle the events from the menu items
	 * 
	 * @author Sherri Harms
	 *
	 */
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == exitMenuItem)
				System.exit(0);
			else if(e.getSource() == fileMenuItem){
				// Show a dialog to allow the user to choose files
				JFileChooser fc = new JFileChooser("./");  //set starting point
				int status = fc.showOpenDialog(null);
				if(status == JFileChooser.APPROVE_OPTION){
					// Show the file that the user has selected
					File f = fc.getSelectedFile();
					String filename = f.getPath();
					JOptionPane.showMessageDialog(null, filename);
					showFile(f);
				}
			}
			else if(e.getSource() == colorMenuItem){
				// Show a dialog to allow the user to choose a color
				Color selected = JColorChooser.showDialog(null, "choose a color", Color.BLACK);
				if (selected != null){
					// Set the background of the window
					getContentPane().setBackground(selected);
				}
			}
		}
	}
	
	/**
	 * To handle the events from the help menu items
	 * 
	 * @author Sherri Harms
	 *
	 */
	private class MyHelpListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == helpMenuItem){
				// Show a new window for the help info
				JFrame helpFrame = new JFrame();  //set starting point
				helpFrame.setTitle("Example Help");
				helpFrame.setSize(300, 100);
				// close this window on exit, but do not close the whole program
				helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JTextArea helpText = new JTextArea();
				helpText.append("This is all the help you get.");
				helpFrame.add(helpText);
				//helpFrame.pack();
				helpFrame.setVisible(true);
			}
			else if(e.getSource() == aboutMenuItem){
				// Show a new window for the help info
				JFrame aboutFrame = new JFrame();  //set starting point
				aboutFrame.setTitle("About MenuWindow");
				aboutFrame.setSize(300, 100);
				// close this window on exit, but do not close the whole program
				aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JTextArea aboutText = new JTextArea();
				aboutText.append("MenuWindow is based on Chapter 13 from our textbook.");
				aboutText.append("\nWritten by Sherri Harms.");
				aboutText.append("\nVersion 1.2");
				aboutText.append("\nCopyright 2015.");
				aboutFrame.add(aboutText);
				aboutFrame.pack();
				aboutFrame.setVisible(true);
			}
		}
	}


public static void showFile(File f){
	try
	{Scanner file = new Scanner(f);
	System.out.println("The file contains:");
	while (file.hasNextLine())
	{
		// Read the data
		System.out.println(file.nextLine().toString());
		// Output the data
	}
	// Close the file
	file.close();
	} catch (FileNotFoundException e) {
		System.out.println("File Not Found: " + e.getMessage());
		System.exit(0);
	}
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MenuWindow mw = new MenuWindow();
	}

}
