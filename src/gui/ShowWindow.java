package gui;
import javax.swing.*;

/**
 * Create a window directly from JFrame
 * @author Sherri Harms
 */
public class ShowWindow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int WINDOW_WIDTH = 350;
		final int WINDOW_HEIGHT = 250;
		
		// create a window
		JFrame window = new JFrame();
		
		// Set the title
		window.setTitle("A simple window that creates the window in main");
		
		// Set the size
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify the action to do when the close button is clicked
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Display the window
		window.setVisible(true);
	}
}
