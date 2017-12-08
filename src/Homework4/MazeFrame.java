//package Homework4;
//
//import Homework5.LookAheadRobot;
//import Homework5.RightHandRobot;
//import Homework5.Robot;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//
///**
// * CSIT 150 HWK 5
// * MazeFrame extends the JFrame and uses MazePanel to create a GUI to watch
// * the Robot Solve the Maze.  There are 3 menu items including File, Maze, and Robot.
// * File has two options Solve and Exit.  Solve will not be available until the Maze
// * and Robot are selected.  Exit will close the Maze.  Maze will have one option to
// * load a text file with the proper layout showing start, exit, rows, and columns for
// * the maze.  See Maze.java for more information.  The Robot menu will have 2 robots,
// * LookAhead and RightHand.
// *
// * @author doubetsr
// * @assisted Matt (brother) helped me find squiggly errors and fix my paintimmediately method.
// * @assisted Andrew, gave me the idea to use an if then statement
// */
//
//public class MazeFrame extends JFrame {
//
//    private File guiFile;  //Load the Maze file object.
//    private Maze guiMaze;  //communicate the Maze with the Robot.
//    private Robot guiRobot;  //communicates the Maze with the Robot.
//    private MazePanel guiPanel; //Creates a Panel
//    private Boolean bCheck;
//    private char robotChar;
//    JMenuItem fileSolveMenuItem;
//    JMenuItem fileExitMenuItem;
//    JMenuItem mazeLoadFileMenuItem;
//    JMenuItem robotLookAheadMenuItem;
//    JMenuItem robotRightMenuItem;
//    JMenu fileMenu;
//    JMenu robotMenu;
//    JMenu mazeMenu;
//    JMenuBar menuBar;
//
//    /**
//     * Lay out the constructor for MazeFrame that extends the JFrame.
//     * Note there are 2 added methods building the file menu
//     * and initializing the window to keep things cleaner.
//     */
//    public MazeFrame () {
//        this.setTitle("Exercise Window");
//        this.setSize(300,300);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        menuBar = new JMenuBar();
//        setJMenuBar(menuBar);
//        buildFileMenu();
//        initializeWindow();
//        this.setVisible(true);
//    }
//
//    /**
//     * Build the file menu as described in the opening of this file.
//     */
//    private void buildFileMenu(){
//        // Create
//        fileMenu = new JMenu("File");
//        mazeMenu = new JMenu("Maze");
//        robotMenu = new JMenu("Robot");
//
//        // Create the menu items
//        fileSolveMenuItem = new JMenuItem("Solve");
//        fileExitMenuItem = new JMenuItem("Exit");
//        mazeLoadFileMenuItem = new JMenuItem("Load Maze");
//        robotLookAheadMenuItem = new JMenuItem("LookAhead");
//        robotRightMenuItem = new JMenuItem("RightHand");
//
//        // Add these menu items into fileMenu
//        fileMenu.add(fileSolveMenuItem);
//        fileMenu.addSeparator();
//        fileMenu.add(fileExitMenuItem);
//
//        // Add these menu items into mazeMenu
//        mazeMenu.add(mazeLoadFileMenuItem);
//
//        // Add these menu items into robotMenu
//        robotMenu.add(robotRightMenuItem);
//        robotMenu.addSeparator();
//        robotMenu.add(robotLookAheadMenuItem);
//        robotMenu.addSeparator();
//
//        // Hook up the menu items with the listener
//        MyListener listener = new MyListener();
//        fileExitMenuItem.addActionListener(listener);
//        mazeLoadFileMenuItem.addActionListener(listener);
//        fileSolveMenuItem.addActionListener(listener);
//        robotLookAheadMenuItem.addActionListener(listener);
//        robotRightMenuItem.addActionListener(listener);
//
//        //set values false
//        fileSolveMenuItem.setEnabled(false);
//        robotMenu.setEnabled(false);
//
//        menuBar.add(fileMenu);
//        menuBar.add(mazeMenu);
//        menuBar.add(robotMenu);
//    }
//
//    /**
//     * Create an action listener method to communicate with
//     * the user when they select different items in the menu.
//     */
//    private class MyListener implements ActionListener {
//        public void actionPerformed(ActionEvent e){
//
//            //listener to Exit
//            if (e.getSource() == fileExitMenuItem) {
//                System.exit(0);
//            }
//
//            //listener to load the maze.
//            else if(e.getSource() == mazeLoadFileMenuItem){
//                // Show a dialog to allow the user to choose files
//                JFileChooser fc = new JFileChooser("./");  //set starting point
//                int status = fc.showOpenDialog(null);
//                if(status == JFileChooser.APPROVE_OPTION){
//                    // Show the file that the user has selected
//                    guiFile = fc.getSelectedFile();
//                    guiMaze = new Maze(guiFile);
//                    guiPanel.setMaze(guiMaze);
//                    setSize(guiMaze.getCols()*40 + 16,guiMaze.getRows()*40 + 60);
//                    repaint();
//                }
//                robotMenu.setEnabled(true);
//            }
//
//            //listener to load the lookahead robot.
//            else if (e.getSource() == robotLookAheadMenuItem){
//                robotChar = '1';
//                fileSolveMenuItem.setEnabled(true);
//            }
//
//            //listener to load the righthad robot.
//            else if (e.getSource() == robotRightMenuItem){
//                robotChar = '2';
//                fileSolveMenuItem.setEnabled(true);
//            }
//
//            //listener to initiate the robot to solve the maze.
//            else if (e.getSource() == fileSolveMenuItem){
//                run();
//            }
//        }
//    }
//
//    /**
//     * Method to initialize the window and give it a Layout.
//     */
//    public void initializeWindow()
//    {
//        // Set the layout of the window
//        setLayout(new BorderLayout());
//        guiPanel = new MazePanel();
//        this.add(guiPanel, BorderLayout.CENTER);
//    }
//
//    /**
//     * Run method that will signal the Robot to execute the maze.
//     */
//    public void run(){
//         bCheck = true;
//            try {
//                Thread.sleep(500);
//                do {
//                    switch (robotChar) {
//                        case '1':
//                            guiRobot = new LookAheadRobot(guiMaze); //show the bot the maze
//                            guiPanel.setRobot(guiRobot);
//                            for (int k = 0; k < 10000 && !guiRobot.solved(); k++)
//                            //this limits the robot's moves, in case it takes too long to find the exit.
//                            {
//                                int direction = guiRobot.chooseMoveDirection();
//                                if (direction >= 0) { //invalid direction is -1
//                                    guiRobot.move(direction);
//                                    guiPanel.paintImmediately(guiPanel.getBounds());
//                                    repaint();
//                                    Thread.sleep(500);
//                                }
//                            }
//                            bCheck = false;
//                            break;
//                        case '2':
//
//                            guiRobot = new RightHandRobot(guiMaze); //show the bot the maze.
//                            guiPanel.setRobot(guiRobot);
//                            for (int k = 0; k < 10000 && !guiRobot.solved(); k++)
//                            //this limits the robot's moves, in case it takes too long to find the exit.
//                            {
//                                int direction = guiRobot.chooseMoveDirection();
//                                if (direction >= 0) {  //invalid direction is -1
//                                    guiRobot.move(direction);
//                                    guiPanel.paintImmediately(guiPanel.getBounds());
//                                    Thread.sleep(500);
//                                }
//                            }
//                            bCheck = false;
//                            break;
//                    }
//                    Thread.sleep(500);
//                }
//                while (bCheck);
//                resetMaze();
//            } catch (Exception e) {
//                System.out.println("This shouldn't happen.");
//            }
//        }
//
//    /**
//     * Method to reset the Maze.
//     */
//    public void resetMaze(){
//
//        guiMaze = null;
//        guiRobot = null;
//        fileSolveMenuItem.setEnabled(false);
//        robotMenu.setEnabled(false);
//        repaint();
//    }
//
//    /**
//     * Main method to run the application.
//     * @param args
//     */
//    public static void main(String[] args)
//    {
//        MazeFrame ew = new MazeFrame();
//    }
//}