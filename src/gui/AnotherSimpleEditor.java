package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 * This program is a simple text editor. It will save text files with two different
 * encryption methods, as long as change the texts color.
 * @author GrantPerson
 *
 */
public class AnotherSimpleEditor extends JFrame {

	JMenuItem OpenFile;		//Open file option
	JMenuItem SaveFile;		//Save file option
	JMenuItem ExitFile;		//Exit file option
	JMenuItem EditText;		//Change text file option
	JMenuItem BlackText;	//Change text file option
	JTextArea TextA;		//The text area
	JMenuItem SaveOp1;		//The various save options
	JMenuItem SaveOp2;
	JMenuItem SaveOp3;
	JMenuItem How2; 		//About the program menu item
	JMenuItem Info;			//About the program menu item
	File FN;				//FileName
	int TypeOfEn;			//For the type of encryption, 0 for +1, 1 for reverse, 2 for normal

	/**
	 * For making the window and its various parts
	 */
	public AnotherSimpleEditor(){
		//Sets the title of our window
		setTitle("Mini Text Editor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Add the menu bar onto the panel
		JMenuBar bar = buildMenuBar();
		setJMenuBar(bar);

		//Add text area
		JPanel TA = buildTextA();
		add(TA);

		// Show the window
		pack();
		setVisible(true);
	}

	/**
	 * Creates the JMenu bar with the Edit, File, Help options
	 * @return menu A menu bar.
	 */
	private JMenuBar buildMenuBar(){
		//Create a menu bar
		JMenuBar menu = new JMenuBar();

		//Add the various menu items
		JMenu fileM = buildFileMenu();
		menu.add(fileM);
		JMenu EditM = buildEditMenu();
		menu.add(EditM);
		JMenu HelpMe = buildHelpMenu();
		menu.add(HelpMe);

		return menu;
	}

	/**
	 * Creates the File menu along with its various options
	 * @return file A JMenuItem for "File"
	 */
	private JMenu buildFileMenu(){
		//Create the menu
		JMenu file = new JMenu("File");

		//Creates the items.
		OpenFile = new JMenuItem("Open File");
		SaveFile = new JMenu("Save");
		ExitFile = new JMenuItem("Exit");

		//Makes a sub menu for the +1 save option.
		SaveFile.setMnemonic(KeyEvent.VK_S);
		SaveOp1 = new JMenuItem("Save Encrypted +1");
		SaveOp1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.ALT_MASK));
		SaveFile.add(SaveOp1);

		//Makes a sub menu for the revere text save option.
		SaveFile.setMnemonic(KeyEvent.VK_S);
		SaveOp2 = new JMenuItem("Save Encrypted Reverse");
		SaveOp2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.ALT_MASK));
		SaveFile.add(SaveOp2);

		//Makes a sub menu for the regular text save option.
		SaveFile.setMnemonic(KeyEvent.VK_S);
		SaveOp3 = new JMenuItem("Save Normal");
		SaveOp3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,ActionEvent.ALT_MASK));
		SaveFile.add(SaveOp3);

		//Add items to menu
		file.add(OpenFile);
		file.add(SaveFile);
		file.addSeparator();
		file.add(ExitFile);

		// Hook up the menu items with the listener
		MyListener listener = new MyListener();
		OpenFile.addActionListener(listener);
		SaveFile.addActionListener(listener);
		ExitFile.addActionListener(listener);
		SaveOp1.addActionListener(listener);
		SaveOp2.addActionListener(listener);
		SaveOp3.addActionListener(listener);

		return file;
	}

	/**
	 * Creates the Edit menu along with its various options
	 * @return edit A JMenuItem for "Edit"
	 */
	private JMenu buildEditMenu(){
		//Creates the edit menu
		JMenu edit = new JMenu("Edit");

		//Creates color menu item
		EditText = new JMenuItem("Text Color: Red");
		BlackText = new JMenuItem("Text Color: Black");

		//Add item to menu
		edit.add(EditText);
		edit.add(BlackText);

		//Hook up listener with menu item
		EditListner listener = new EditListner();
		EditText.addActionListener(listener);
		BlackText.addActionListener(listener);

		return edit;

	}

	/**
	 * Creates the Help menu along with its various options
	 * @return helpM A JMenuItem for "Help"
	 */
	private JMenu buildHelpMenu(){
		//Create the menu
		JMenu helpM = new JMenu("Help");

		//The items in the menu
		How2 = new JMenuItem("About MiniTextEditor");
		Info = new JMenuItem("Licensing Information");

		//Adds the various options to the help menu
		helpM.add(How2);
		helpM.addSeparator();
		helpM.add(Info);

		//Create the listener for the options in the help menu.
		HelpList listener = new HelpList();
		How2.addActionListener(listener);
		Info.addActionListener(listener);

		return helpM;
	}

	/**
	 * Creates the text area.
	 * @return TxtA A JTextArea for.
	 */
	private JPanel buildTextA(){
		// Create the panel
		JPanel TxtA = new JPanel();

		//Make text area and add to panel
		TextA = new JTextArea(20,20);
		JScrollPane scroll = new JScrollPane(TextA);
		TxtA.add(scroll);

		// Avoid long lines
//		TextA.setLineWrap(true);

		// Do not break a word from the middle
		TextA.setWrapStyleWord(true);

		//Set scroll
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// Set the font of the text area
		Font font = new Font("monospaced", Font.PLAIN|Font.PLAIN, 12);
		TxtA.setFont(font);


		return TxtA;
	}

	/**
	 * This is for printing the help menu.
	 */
	private void HelpMenu() {
		//Displays this message
		JOptionPane.showMessageDialog(null, "This program is a barebones text editor. You can type text into the text area\n" +
				"and change its color.  You can save your data in the text area as an encryted file,\n" +
				"this can be chosen when saving.  Also when opening a file this program will unencrypt\n" +
		"your file so it is readable.");
	}

	/**
	 * This is for printing the information menu
	 */
	private void InfoMenu(){
		//This statement is shown
		JOptionPane.showMessageDialog(null, "MiniTextEditor\nAuthour: Grant Person\nEdition: 1.0\nDate 3/08/12");
	}

	/**
	 * This class is for the action listener in the help menu.
	 * @author GrantPerson
	 *
	 */
	private class HelpList implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//If the About MiniTextEditor is clicked
			if(e.getSource() == How2){
				//Prompt to show help menu.
				HelpMenu();
			}
			else{
				//Any other action (i.e Licensing Info), prints it's this method.
				InfoMenu();
			}
		}
	}

	/**
	 * This class is for the action listener in the file menu.
	 * @author GrantPerson
	 *
	 */
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//If the Exit but is select
			if (e.getSource() == ExitFile)
				System.exit(0);
			//If open file is selected
			else if(e.getSource() == OpenFile){
				// Show a dialog to allow the user to choose files
				JFileChooser of = new JFileChooser("./");  //set starting point
				
				//Next few lines are for prompting the user for which type of encryption 
				//they would like to open the file with. Sets selection to the option chose in the drop down
				//JOptionPane window.
				int status = of.showOpenDialog(null);
				Object[] SaveSelections = {"+1 Encryption", "Reverse Encryption","Normal"};
				String intial = "Normal";
				String selection = (String) JOptionPane.showInputDialog(null, "How is this file encrypted?", "File Open Options", 
						JOptionPane.QUESTION_MESSAGE, null, SaveSelections, intial);

				//Initialize the file
				FN = of.getSelectedFile();
				
				
				//This determines what to set the TypeOfEncryption to depending on the users choice.
				if(selection.equalsIgnoreCase("Reverse Encryption"))
					TypeOfEn = 1;
				else if(selection.equalsIgnoreCase("+1 Encryption"))
					TypeOfEn = 0;
				else 
					TypeOfEn = 2;

				//Show the file
				TextA.setText(showFile());

			}
			else if(e.getSource() == SaveOp1){
				//Opens window for choosing file
				JFileChooser fc = new JFileChooser("./");
				int status = fc.showSaveDialog(null);
				if(status == JFileChooser.APPROVE_OPTION){
					// Get the files name the the user input for what type of encryption.
					FN = fc.getSelectedFile();
					TypeOfEn = 0;
					writeFile();
				}
			}
			else if(e.getSource() == SaveOp2){
				//Opens window for choosing file
				JFileChooser fc = new JFileChooser("./");
				int status = fc.showSaveDialog(null);
				if(status == JFileChooser.APPROVE_OPTION){
					// Get the files name the the user input.
					FN = fc.getSelectedFile();
					TypeOfEn = 1;
					writeFile();
				}
			}

			else if(e.getSource() == SaveOp3){
				//Opens window for choosing file
				JFileChooser fc = new JFileChooser("./");
				int status = fc.showSaveDialog(null);
				if(status == JFileChooser.APPROVE_OPTION){
					// Get the files name the the user input.
					FN = fc.getSelectedFile();
					TypeOfEn = 2;
					writeFile();
				}
			}
		}
	}

	/**
	 * This class is the action listener for the Edit menu item.
	 * @author GrantPerson
	 *
	 */
	private class EditListner implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//For changing the text color to red
			if(e.getSource() == EditText){
				TextA.setForeground(Color.red);
			}
			//Changing text to black
			if(e.getSource() == BlackText){
				TextA.setForeground(Color.black);
			}
		}
	}

	/*
	 * This method is for writing the file depending on what encryption method is chosen.
	 */
	public void writeFile(){
		//Checks if the save type is 1+
		if(TypeOfEn == 0){
			try{
				//Gets the content from the text area and saves into a string
				String Content = TextA.getText();

				//This string is for the end product after the encryption
				String EnContent = "";

				//This loop will read every char of the Content string and add one to the
				//ASCII number.
				for(int i = 0; i< Content.length(); i++){
					if(Character.isLetter(Content.charAt(i))){
						char NL = (char) (Content.charAt(i)+1);
						EnContent = EnContent + NL;
					}
					//If its not a character we skip it.
					else
						EnContent = EnContent + Content.charAt(i);
				}

				//Write the file
				FileWriter outFile = new FileWriter(FN);
				outFile.write(EnContent);

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

		//Checks if the save type is reverse
		if(TypeOfEn == 1){
			try{
				//Gets the content from the text area and saves into a string
				String Content = TextA.getText();

				//This string is for the end product after the encryption
				String EnContent = "";

				//This loop will read every char of the Content string from last to first,
				//then add them to the new encrypted string.
				int length = Content.length();
				for(int i = length-1; i>= 0; i--){
					char NL = (char) (Content.charAt(i));
					EnContent = EnContent + NL;
				}

				//Prints the file
				FileWriter outFile = new FileWriter(FN);
				outFile.write(EnContent);

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

		//Checks if the save type is normal
		if(TypeOfEn == 2){
			try{
				//Just writes text if no encryption is needed
				FileWriter outFile = new FileWriter(FN);
				TextA.write(outFile);

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
	}

	public String showFile(){
		// Put all selections into one string
		String s = "";
		String s2 = "";

		//These if else statements are used to determine which method is needed to be use to open the file
		if(TypeOfEn == 0){
			try{
				//Scanner for reading file
				Scanner file = new Scanner(FN);
				while (file.hasNextLine())
				{
					// Read the data, save into one string
					s = file.nextLine().toString();

					//Goes through the string decrypting it, and copying it to a new string
					for(int i = 0; i < s.length();i++){
						if(Character.isLetter(s.charAt(i))){
							char S =(char) (s.charAt(i)-1);
							s2 = s2 + S;
						}
						else
							s2 = s2 + s.charAt(i);
					}
					s2 = s2 + "\n";
				}
				// Close the file
				file.close();
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found: " + e.getMessage());
				System.exit(0);
			}
		}

		//This will read the file unreversing the text and returning it.
		else if(TypeOfEn == 1){
			try{
				Scanner file = new Scanner(FN);
				while (file.hasNextLine())
				{
					// Read the data
					s = file.nextLine().toString();
					
					for(int i = (s.length()-1); i >= 0;i--){
						s2 = s2 + (char)(s.charAt(i));	
					}
					s2 = s2 + "\n";
				}
				// Close the file
				file.close();
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found: " + e.getMessage());
				System.exit(0);
			}
		}
		//If it is normal simply just print out each line
		else{
			try{
				Scanner file = new Scanner(FN);
				while(file.hasNextLine()){
					s2 = s2 + file.nextLine() +"\n";
				}	
				file.close();
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found: " + e.getMessage());
				System.exit(0);
			}
		}

		return s2;
	}

	/**
	 *@param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Call the text editor
		AnotherSimpleEditor n = new AnotherSimpleEditor();
	}

}
