package gui;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author andersoncl4
 */
public class NameWin extends JFrame{

	private int width = 600;
	private int height = 300;

	public NameWin()
	{
		this.setTitle("Name Entry");
		this.setSize(width,height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		configureWin();

		this.setVisible(true);
	}

	private void configureWin()
	{
		JPanel nameEntryPan = new JPanel(new GridLayout(4,2));
//		this.add(nameEntryPan,BorderLayout.CENTER);
		this.add(nameEntryPan);

		JLabel firstName = new JLabel("First Name");
		JLabel lastName = new JLabel("Last Name");
		JLabel userName = new JLabel("User Name");

		JTextField firstTxt = new JTextField(10);
		JTextField lastTxt = new JTextField(10);
		JTextField userTxt = new JTextField(10);

		nameEntryPan.add(firstName);
		nameEntryPan.add(firstTxt);
		nameEntryPan.add(lastName);
		nameEntryPan.add(lastTxt );
		nameEntryPan.add(userName);
		nameEntryPan.add(userTxt);

		JButton enterButton = new JButton("Enter");
		JPanel butPan = new JPanel();
		butPan.add(enterButton);
		nameEntryPan.add(butPan);
	}

	public static void main(String[] args)
	{
		NameWin nw = new NameWin();
	}
}
