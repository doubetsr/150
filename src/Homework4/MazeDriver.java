package Homework4;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


/**
 * This program simulates a robot getting through a maze.
 *	Unlike tic-tac-toe, where the user is the player, the robot moves 
	autonomously through the maze.
 * 	We intentionally share the memory location of the maze with the robot.
	Otherwise the robot would not know how to plan and make its moves.
	
	The maze is stored in a text file that will be entered at runtime.  
	The layout of each maze file will contain:
�	In the first line:  two integers (the number of rows and columns, respectively,  in the maze)  
�	In the second line:  two integers (the row and column locations, respectively, of the Start cell
�	In the third line:  two integers (the row and column locations, respectively, of the Exit cell
�	Each line thereafter will contain characters appearing in one row of the maze.  

 * Created by Sherri Harms
 * built on top of Eddy's UW-Parkside solution
 */

public class MazeDriver {

	/**
	 * The main method will read a maze from an input file.
	 * There will be a prompt for the user to choose the maze.
	 * The maze will be printed via System.
	 * Then, the user will be prompted to choose a robot.
	 * Once chosen, the robot will make it's way through the maze.
	 * The maze will be printed via System.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		File inputFile = getFile();  //sample: testmaze.txt
		Maze maze = new Maze(inputFile); //create maze from the file.
		System.out.println(maze); //print the maze
		String menu = "Choose the Robot that you want to" + //D
				"\n use in the maze you have chosen." +
				"\n\n Type 1 for the LookAheadRobot" +
				"\n Type 2 for the RightHandRobot";
		/**
		 * Run a do while loop so that the only right answer
		 * will be 1 or 2.  Once robot is selected
		 * the robot will navigate the maze and the
		 * program will be finished.
		 */
		do {
			String response = JOptionPane.showInputDialog(null,
					menu, "Menu", 1);
			char letter = response.toUpperCase().charAt(0);
			switch (letter) {
				case '1':
					JOptionPane.showMessageDialog(null,
							"You chose the Look Ahead Robot", "LookAheadRobot", 1);
					Robot bot = new LookAheadRobot(maze); //show the bot the maze
					for (int k = 0; k < 10000 && !bot.solved(); k++)
					//this limits the robot's moves, in case it takes too long to find the exit.
					{
						int direction = bot.chooseMoveDirection();
						if (direction >= 0)  //invalid direction is -1
							bot.move(direction);
						System.out.println(maze);
						System.out.println("\n");
					}
					System.exit(0);
					break;
				case '2':
					JOptionPane.showMessageDialog(null,
							"You chose the Righthand Robot", "Righthand Robot", 1);
					Robot botRight = new RightHandRobot(maze); //show the bot the maze.
					for (int k = 0; k < 10000 && !botRight.solved(); k++)
					//this limits the robot's moves, in case it takes too long to find the exit.
					{
						int direction = botRight.chooseMoveDirection();
						if (direction >= 0)  //invalid direction is -1
							botRight.move(direction);
						System.out.println(maze);
						System.out.println("\n");
					}
					System.exit(0);
					break;
			}
		}
		while (true);
	}
	
	/**
	 * Get the file that has the maze specifications.
	 * @return File chosen by user.
	 */
	public static File getFile()
	{
		JFileChooser chooser;
		try{

			// Get the filename.
			chooser = new JFileChooser();
			int status = chooser.showOpenDialog(null);
			if (status != JFileChooser.APPROVE_OPTION)
			{
				System.out.println("No File Chosen");
				System.exit(0);
			}
			return chooser.getSelectedFile();
		} catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);

		}
		return null; //should never get here, but makes compiler happy
	}

}
