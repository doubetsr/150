package gui;
import javax.swing.JFrame;

/**
 * Create a window by extending JFrame
 *
 */
public class SimpleWindow extends JFrame {

	/**
	 * In this constructor, we create the window
	 */
	public SimpleWindow(){
		final int WINDOW_WIDTH = 350;
		final int WINDOW_HEIGHT = 250;
		
		// Set the title
		setTitle("A simple window that extends JFrame");
		
		// Set the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify the action to do when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		// Create a window and show it
		SimpleWindow myWindow = new SimpleWindow();
		myWindow.setVisible(true);
	}
}
