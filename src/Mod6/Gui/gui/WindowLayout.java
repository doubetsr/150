package gui;
import javax.swing.*;
import java.awt.*;

/**
 * Demonstrate the three kinds of layout design of Java
 * In this example, I put all components directly in the JFrame, 
 * which is discouraged in practice.
 *
 * @author Sherri Harms
 */
public class WindowLayout extends JFrame{
	private JPanel buttonPanel;
	public WindowLayout(){
		// Set the title and close operation
		setTitle("Window Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create five buttons
		JButton button1 = new JButton("button1");
		JButton button2 = new JButton("button2");
		JButton button3 = new JButton("button3");
		JButton button4 = new JButton("button4");
		JButton button5 = new JButton("button5");
	
		// Set the layout be "flow layout"
		// When we add the components in, we add them from right to left
		// We flow all buttons to the right
		// Notice that the sizes of the buttons do not change with the window
		
		buttonPanel = new JPanel();
//		buttonPanel.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	
//		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30 ,10));
//		buttonPanel.add(button1);
//		buttonPanel.add(button2);
//		buttonPanel.add(button3);
//		buttonPanel.add(button4);
//		buttonPanel.add(button5);
	
		// Now we try border layout
		// When we add the buttons in, we have to determine their positions,
		// e.g., BorderLayout.NORTH
		// Change the size of the window, look at how ugly this interface
		// Will become
		buttonPanel.setLayout(new BorderLayout(200, 100));

		buttonPanel.add(button1, BorderLayout.WEST);
		buttonPanel.add(button2, BorderLayout.EAST);
		buttonPanel.add(button3, BorderLayout.NORTH);
		buttonPanel.add(button4, BorderLayout.SOUTH);
		buttonPanel.add(button5, BorderLayout.CENTER);

		// Now let us try the grid layout
		// We set it in 2 rows and 3 columns
		// Change the size of the window, and see how ugly it becomes
/*		buttonPanel.setLayout(new GridLayout(2, 3));
		
		// Add the buttons into the panel
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		buttonPanel.add(button5);
*/
		// Show the window
		add(buttonPanel);
		pack();
		setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create the window
		WindowLayout fw = new WindowLayout();
	}
}
