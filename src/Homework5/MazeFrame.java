package Homework5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

/**
 * CSIT 150 HWK 5
 * MazeFrame extends the JFrame and uses MazePanel to create a GUI to watch
 * the Robot Solve the Maze.  There are 3 menu items including File, Maze, and Robot.
 * File has two options Solve and Exit.  Solve will not be available until the Maze
 * and Robot are selected.  Exit will close the Maze.  Maze will have one option to
 * load a text file with the proper layout showing start, exit, rows, and columns for
 * the maze.  See Maze.java for more information.  The Robot menu will have 2 robots,
 * LookAhead and RightHand.
 *
 * @author doubetsr
 * @assisted Matt (brother) helped me find squiggly errors and fix my paintimmediately method.
 * @assisted Andrew, gave me the idea to use an if then statement
 */

public class MazeFrame extends JFrame {

    private File guiFile;  //Load the Maze file object.
    private Maze guiMaze;  //communicate the Maze with the Robot.
    private Robot guiRobot;  //communicates the Maze with the Robot.
    private Robot dirtyRobot;
    private MazePanel guiPanel; //Creates a Panel
    private Boolean bCheck;
    private char robotChar;
    JMenuItem fileSolveMenuItem;
    JMenuItem fileExitMenuItem;
    JMenuItem mazeLoadFileMenuItem;
    JMenuItem robotLookAheadMenuItem;
    JMenuItem robotRightMenuItem;
    JMenuItem robotUserMenuItem;
    JMenuItem aboutHelpMenuItem;
    JMenu fileMenu;
    JMenu robotMenu;
    JMenu mazeMenu;
    JMenu helpMenu;
    JMenuBar menuBar;

    /**
     * Lay out the constructor for MazeFrame that extends the JFrame.
     * Note there are 2 added methods building the file menu
     * and initializing the window to keep things cleaner.
     */
    public MazeFrame () {
        this.setTitle("Exercise Window");
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        buildFileMenu();
        initializeWindow();
        this.setVisible(true);
    }

    /**
     * Build the file menu as described in the opening of this file.
     */
    private void buildFileMenu(){
        // Create
        fileMenu = new JMenu("File");
        mazeMenu = new JMenu("Maze");
        robotMenu = new JMenu("Robot");
        helpMenu = new JMenu("Help");

        // Create the menu items
        fileSolveMenuItem = new JMenuItem("Solve");
        fileExitMenuItem = new JMenuItem("Exit");
        mazeLoadFileMenuItem = new JMenuItem("Load Maze");
        robotLookAheadMenuItem = new JMenuItem("LookAhead");
        robotRightMenuItem = new JMenuItem("RightHand");
        robotUserMenuItem = new JMenuItem("User Controlled");
        aboutHelpMenuItem = new JMenuItem("About");

        // Add these menu items into fileMenu
        fileMenu.add(fileSolveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(fileExitMenuItem);

        // Add these menu items into mazeMenu
        mazeMenu.add(mazeLoadFileMenuItem);

        // Add these menu items into robotMenu
        robotMenu.add(robotRightMenuItem);
        robotMenu.addSeparator();
        robotMenu.add(robotLookAheadMenuItem);
        robotMenu.addSeparator();
        robotMenu.add(robotUserMenuItem);

        // Add menu items into helpMenu
        helpMenu.add(aboutHelpMenuItem);

        // Hook up the menu items with the listener
        MyListener listener = new MyListener();
        fileExitMenuItem.addActionListener(listener);
        mazeLoadFileMenuItem.addActionListener(listener);
        fileSolveMenuItem.addActionListener(listener);
        robotLookAheadMenuItem.addActionListener(listener);
        robotRightMenuItem.addActionListener(listener);
        robotUserMenuItem.addActionListener(listener);
        aboutHelpMenuItem.addActionListener(listener);

        //set values false
        fileSolveMenuItem.setEnabled(false);
        robotMenu.setEnabled(false);

        menuBar.add(fileMenu);
        menuBar.add(mazeMenu);
        menuBar.add(robotMenu);
        menuBar.add(helpMenu);
    }

    /**
     * Create an action listener method to communicate with
     * the user when they select different items in the menu.
     */
    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            //listener to Exit
            if (e.getSource() == fileExitMenuItem) {
                System.exit(0);
            }

            //listener to load the maze.
            else if (e.getSource() == mazeLoadFileMenuItem) {

                guiRobot = null;
                // Show a dialog to allow the user to choose files
                JFileChooser fc = new JFileChooser("./");  //set starting point
                int status = fc.showOpenDialog(null);
                if (status == JFileChooser.APPROVE_OPTION) {
                    // Show the file that the user has selected
                    guiFile = fc.getSelectedFile();
                    guiMaze = new Maze(guiFile);
                    guiPanel.setMaze(guiMaze);
                    setSize(guiMaze.getCols() * 40, guiMaze.getRows() * 40 + 50);
                    repaint();
                }
                robotMenu.setEnabled(true);
            }

            //listener to load the lookahead robot.
            else if (e.getSource() == robotLookAheadMenuItem) {
                guiRobot = new LookAheadRobot(guiMaze); //show the bot the maze
                guiPanel.setRobot(guiRobot);
                fileSolveMenuItem.setEnabled(true);
                repaint();
            }

            //listener to load the righthand robot.
            else if (e.getSource() == robotRightMenuItem) {
                guiRobot = new RightHandRobot(guiMaze); //show the bot the maze.
                guiPanel.setRobot(guiRobot);
                fileSolveMenuItem.setEnabled(true);
                repaint();
            }

            else if (e.getSource() == aboutHelpMenuItem){
                JOptionPane.showMessageDialog(null,"How run an automated robot:\n" +
                        "Select 'Maze' in the menu options.  Click on load maze and select the desired maze.\n" +
                        "Then click on the Load Maze.  Next, select the robot button in the menu and select\n" +
                        "(RightHand or LookAhead).  Finally, click on the 'File' menu options and select solve.\n" +
                        "After the maze is solved select a new maze to continue or exit from the 'File' menu.\n\n" +

                        "How to Play the maze game:\n" +
                        "Click on load maze and select the desired maze.\n" +
                        "Then click on the Load Maze.  Next, select the robot button in the menu and select\n" +
                        "(RightHand or LookAhead).  Once the userRobot is loaded begin by pressing an arrow key.\n" +
                        "To move in the desired location press the key to which direction you would like to go.\n" +
                        "Example:  To move down press the down key on the keyboard.");
            }

            //listener to initiate the robot to solve the maze.
            else if (e.getSource() == fileSolveMenuItem) {
                    run();
            }

            //listener to initiate the user controlled robot.
            else if (e.getSource() == robotUserMenuItem) {
                JOptionPane.showMessageDialog(null,
                        "To enter the maze press down.  After your first move you will see a green square\n" +
                        "at your previous location.  Each time you move off of a square it will change colors.\n" +
                        "The order is green, yellow, orange, and red.  Each color represents points for when you\n" +
                        "finish the game or are stuck.\n\nGreen: +1\n Yellow: +2\nOrange: +4\nRed: +7.\n\n" +
                        "Watch out, once a square is red you can't move back through it.  Once you finish the maze\n" +
                        "or are stuck press any key to move to see the score screen.  TIP:  If you trap yourself\n" +
                        "the Score won't show until you can no longer make any additional moves to a new location.\n" +
                        "To reset the game select a new maze.");
                guiRobot = new UserRobot(guiMaze);
                guiPanel.setRobot(guiRobot);
                guiPanel.setDirtyRobot();
                robotMenu.setEnabled(false);
                repaint();
            }
        }
    }

    /**
     * Method to initialize the window and give it a Layout.
     */
    public void initializeWindow()
    {
        // Set the layout of the window
        setLayout(new BorderLayout());
        guiPanel = new MazePanel();
        this.add(guiPanel, BorderLayout.CENTER);
    }

    /**
     * Run method that will signal the Robot to execute the maze.
     */
    public void run(){
        bCheck = true;
        try {
            Thread.sleep(100);
                        for (int k = 0; k < 10000 && !guiRobot.solved(); k++)
                        //this limits the robot's moves, in case it takes too long to find the exit.
                        {
                            int direction = guiRobot.chooseMoveDirection();
                            if (direction >= 0) {  //invalid direction is -1
                                guiRobot.move(direction);
                                guiPanel.paintImmediately(guiPanel.getBounds());
                                Thread.sleep(100);
                            }
                        }
                Thread.sleep(500);
            resetMaze();
        } catch (Exception e) {
            System.out.println("This shouldn't happen.");
        }
    }

    /**
     * Method to reset the Maze.
     */
    public void resetMaze(){

        guiMaze = null;
        guiRobot = null;
        fileSolveMenuItem.setEnabled(false);
        robotMenu.setEnabled(false);
        repaint();
    }

    /**
     * Main method to run the application.
     * @param args
     */
    public static void main(String[] args)
    {
        MazeFrame ew = new MazeFrame();
    }
}