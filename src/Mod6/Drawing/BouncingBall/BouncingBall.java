package Mod6.Drawing.BouncingBall;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.Random;

/**
 * Randomly move a ball around the screen
 * Each iteration, it goes a while
 */
public class BouncingBall extends JFrame {
	private final int MOVE = 20;       // Pixels to move ball
	Random random;
	private int numberOfSteps = 10;
	private MyBallPanel myBallPanel;
	private JButton goButton;
	private Ball ball;
	private int width = 300;
	private int height = 300;

	/**
	 * Create the timer and associate it with a listener, and then start the timer
	 */
	public BouncingBall() {
		setTitle("Bouncing Ball");
		setSize(width*2,height*2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());   
		ball = new Ball(width,height);//creates a new ball that bounces within the panel
		random = new Random();
		myBallPanel = new MyBallPanel();
	     // Set the size of the panel.
		myBallPanel.setPreferredSize(new Dimension(width, height));
		myBallPanel.setSize(width,height);
		goButton = new JButton("Go for a short while");
		add(goButton, BorderLayout.NORTH);
		add(myBallPanel, BorderLayout.CENTER);
		// Hook up the radio buttons with the event listener
		MyListener listener = new MyListener();
		goButton.addActionListener(listener);
	//	pack();
	}

	private class MyBallPanel extends JPanel
	{
		/**
		 * Repaint the ball based on its current location
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (ball != null) {
				g.setColor(Color.red);
				int row = ball.getX();
				int col = ball.getY();
				g.fillOval(row, col, ball.getBallWidth(), ball.getBallWidth());
			}
		}
	}

	private class MyListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (e.getSource() == goButton)
			{
				runIt();
			}else
			{
				System.exit(0);
			}
		}
	}

/**
 * When the user clicks the button, move the ball for a while
 * sleep to have a delay between the drawings
 */
	public void runIt() {
		try{
			Thread.sleep(500);
			for (int i =0;i<numberOfSteps; i++){
				int xIncrease = random.nextInt(MOVE);
				int yIncrease = random.nextInt(MOVE);
				ball.move(xIncrease,yIncrease);
				myBallPanel.paintImmediately(0, 0, myBallPanel.getWidth(), myBallPanel.getHeight());
				Thread.sleep(100);
				}
		} catch (Exception e) {
			System.out.println("This shouldn't happen.");
		}
	}
	public static void main(String args[]) {
		/* Create and display the form */
		BouncingBall bb = new BouncingBall();
		bb.setVisible(true);
	}

}

