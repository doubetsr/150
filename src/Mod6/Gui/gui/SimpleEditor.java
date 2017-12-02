package gui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

/**
 * This is a sample program that shows how to open and close a file
 * use a menu system
 * includes a File menu and a Help menu
 * 
 * @author harmssk
 **/

public class SimpleEditor extends JFrame{
	//variables that must be able to be passed between methods and the listeners
	JMenuItem fileOpenMenuItem;   
	JMenuItem fileSaveMenuItem;
	JMenuItem colorMenuItem;
	JMenuItem exitMenuItem;
	JMenuItem helpMenuItem;
	JMenuItem aboutMenuItem;
	JTextArea content;
	JPanel colorPanel;
	File f;

	/**
	 * Build GUI - Constructor
	 */
	public SimpleEditor(){
		// Set the title and close operation
		setTitle("Example Open File Menu system");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the menu bar and put it in the window
		JMenuBar bar = buildMenuBar();
		setJMenuBar(bar);

		// Set the layout of the window
		setLayout(new BorderLayout());

		//show the content of the file in this panel
		JPanel contentPanel = buildContentPanel();
		
		//show the color change in this panel 
		buildColorPanel();
		
		// Put panels into the window
		add(colorPanel, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
	
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
		
		//put space between the File and the Help Menus
		Label whiteSpace = new Label("                        ");
		menuBar.add(whiteSpace);
	
		//create the help Menu
		JMenu helpMenu = buildHelpMenu();
		menuBar.add(helpMenu);
		
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
		fileOpenMenuItem = new JMenuItem("Open a file");
		fileSaveMenuItem = new JMenuItem("Save");
		colorMenuItem = new JMenuItem("Choose a color");
		exitMenuItem = new JMenuItem("exit");
	
		// Add these menu items into fileMenu
		fileMenu.add(fileOpenMenuItem);
		fileMenu.add(fileSaveMenuItem);
		fileMenu.add(colorMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		
		// Hook up the menu items with the listener
		MyListener listener = new MyListener();
		exitMenuItem.addActionListener(listener);
		fileOpenMenuItem.addActionListener(listener);
		fileSaveMenuItem.addActionListener(listener);
		colorMenuItem.addActionListener(listener);
		
		return fileMenu;
	}

	
	/**
	 * Create the Help menu
	 * 
	 * @return The created help menu
	 */
	private JMenu buildHelpMenu(){
		// Create
		JMenu helpMenu = new JMenu("Help");
		
		// Create the menu items
		helpMenuItem = new JMenuItem("View Help");
		aboutMenuItem = new JMenuItem("About this program");
		helpMenu.add(helpMenuItem);
		helpMenu.add(aboutMenuItem);
		// Hook up the menu items with the listener
		MyHelpListener helpListener = new MyHelpListener();
		helpMenuItem.addActionListener(helpListener);
		aboutMenuItem.addActionListener(helpListener);
		
		return helpMenu;
}
	/**
	 * Create the panel to hold the color change
	 * 
	 * @return The created panel
	 */
	private void buildColorPanel(){
		// Create the panel
		colorPanel = new JPanel();
		// Create a label and put it in the window
		JLabel label = new JLabel("Use the menu to change my color.");
		colorPanel.add(label);
	}
	
	/**
	 * Create the panel to hold the text file contents
	 * Allow the user to edit the content
	 * @return The created panel
	 */
	private JPanel buildContentPanel(){
		// Create the panel
		JPanel contentPanel = new JPanel();
		
	
		// Create the text area and put it into the panel
		content = new JTextArea(20, 100);
		JScrollPane sp = new JScrollPane(content);
		contentPanel.add(sp);

		// Avoid long lines
		content.setLineWrap(true);
		
		// Do not break a word from the middle
		content.setWrapStyleWord(true);
		
		// Set the scroll pane policy
	//	sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	//	sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//	sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		// Set the font of the text area
		Font font = new Font("monospaced", Font.ITALIC|Font.BOLD, 12);
		content.setFont(font);
		
		return contentPanel;
	}

	
	/**
	 * To handle the events from the file menu items
	 * 
	 * @author Xuli Liu, Sherri Harms
	 *
	 */
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == exitMenuItem)
				System.exit(0);
			else if(e.getSource() == fileOpenMenuItem){
				// Show a dialog to allow the user to choose files
				JFileChooser fc = new JFileChooser("./");  //set starting point
				int status = fc.showOpenDialog(null);
				if(status == JFileChooser.APPROVE_OPTION){
					// Show the file that the user has selected
					f = fc.getSelectedFile();
					String filename = f.getPath();
					JOptionPane.showMessageDialog(null, filename);
					// Put the string file contents into the text area
					content.setText(showFile());
				}
			}
			else if(e.getSource() == fileSaveMenuItem){
				writeFile();  //save the file
			} 
			else if(e.getSource() == colorMenuItem){
				// Show a dialog to allow the user to choose a color
				Color selected = JColorChooser.showDialog(null, "choose a color", Color.BLACK);
				if (selected != null){
					// Set the background of the window
					colorPanel.setBackground(selected);
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
				//finish this "about this program" here
			}
		}
	}

	/**
	 * Show the contents of the file
	 * @return string of text from the file
	 */
public String showFile(){
	// Put all selections into one string
	String s = "";

	try
	{Scanner file = new Scanner(f);
	while (file.hasNextLine())
	{
		// Read the data
		s+=file.nextLine().toString()+"\n";

	}
	// Close the file
	file.close();
	} catch (FileNotFoundException e) {
		System.out.println("File Not Found: " + e.getMessage());
		System.exit(0);
	}
	
return s;

}

/**
 * write the content back to the file
 */
public void writeFile(){
	try
	{FileWriter outFile = new FileWriter(f);
	content.write(outFile);
	// Close the file
	outFile.close();
	} catch (FileNotFoundException e) {
		System.out.println("File Not Found: " + e.getMessage());
		System.exit(0);
	} catch (IOException e) {
		System.out.println("IO Error: " + e.getMessage());
		System.exit(0);
	}
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleEditor mw = new SimpleEditor();
	}

}
