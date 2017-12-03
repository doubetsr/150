package Homework4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MazeFrame extends JFrame {

    private File guiFile;
    private Maze guiMaze;
    private Robot guiRobot;
    private MazePanel guiPanel;
    private Boolean bCheck;
    private char robotChar;
    JMenuItem fileSolveMenuItem;
    JMenuItem fileExitMenuItem;
    JMenuItem mazeLoadFileMenuItem;
    JMenuItem robotLookAheadMenuItem;
    JMenuItem robotRightMenuItem;
    JMenu fileMenu;
    JMenu robotMenu;
    JMenu mazeMenu;
    JMenuBar menuBar;


    public MazeFrame () {
        this.setTitle("Exercise Window");
        this.setSize(840,680);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        buildFileMenu();
        initializeWindow();
        this.setVisible(true);

    }

    private void buildFileMenu(){
        // Create
        fileMenu = new JMenu("File");
        mazeMenu = new JMenu("Maze");
        robotMenu = new JMenu("Robot");

        // Create the menu items
        fileSolveMenuItem = new JMenuItem("Solve");
        fileExitMenuItem = new JMenuItem("Exit");
        mazeLoadFileMenuItem = new JMenuItem("Load Maze");
        robotLookAheadMenuItem = new JMenuItem("Random");
        robotRightMenuItem = new JMenuItem("RightHand");

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

        // Hook up the menu items with the listener
        MyListener listener = new MyListener();
        fileExitMenuItem.addActionListener(listener);
        mazeLoadFileMenuItem.addActionListener(listener);
        menuBar.add(fileMenu);
        menuBar.add(mazeMenu);
        menuBar.add(robotMenu);
    }


    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == fileExitMenuItem)
                System.exit(0);
            else if(e.getSource() == mazeLoadFileMenuItem){
                // Show a dialog to allow the user to choose files
                JFileChooser fc = new JFileChooser("./");  //set starting point
                int status = fc.showOpenDialog(null);
                if(status == JFileChooser.APPROVE_OPTION){
                    // Show the file that the user has selected
                    guiFile = fc.getSelectedFile();
                    String filename = guiFile.getPath();
                    JOptionPane.showMessageDialog(null, filename);
                    guiMaze = new Maze(guiFile);
                    guiPanel.setMaze(guiMaze);
                }
                else if (e.getSource() == robotLookAheadMenuItem){
                    robotChar = 1;
                }
                else if (e.getSource() == robotRightMenuItem){
                    robotChar = 2;
                }
                else if (e.getSource() == fileSolveMenuItem){
                    run();
                }
            }
        }
    }

    public void initializeWindow()
    {
        // Set the layout of the window
        setLayout(new BorderLayout());
        guiPanel = new MazePanel();
        this.add(guiPanel, BorderLayout.CENTER);
    }

    public void run(){

        bCheck = true;

        try{
            Thread.sleep(500);
            do {
                switch (robotChar) {
                    case '1':
                        guiRobot = new LookAheadRobot(guiMaze); //show the bot the maze
                        for (int k = 0; k < 10000 && !guiRobot.solved(); k++)
                        //this limits the robot's moves, in case it takes too long to find the exit.
                        {
                            int direction = guiRobot.chooseMoveDirection();
                            if (direction >= 0)  //invalid direction is -1
                                guiRobot.move(direction);
                            guiPanel.paintImmediately(guiRobot.getRowLocation(),guiRobot.getColLocation(),20,20);
                        }
                        System.exit(0);
                        break;
                    case '2':
                        JOptionPane.showMessageDialog(null,
                                "You chose the Righthand Robot", "Righthand Robot", 1);
                        guiRobot = new RightHandRobot(guiMaze); //show the bot the maze.
                        for (int k = 0; k < 10000 && !guiRobot.solved(); k++)
                        //this limits the robot's moves, in case it takes too long to find the exit.
                        {
                            int direction = guiRobot.chooseMoveDirection();
                            if (direction >= 0)  //invalid direction is -1
                                guiRobot.move(direction);
                            guiPanel.paintImmediately(guiRobot.getRowLocation(),guiRobot.getColLocation(),20,20);
                        }
                        System.exit(0);
                        break;
                }
                Thread.sleep(100);
            }
            while (true);
        } catch (Exception e) {
            System.out.println("This shouldn't happen.");
        }
    }

    public void resetMaze(){
        repaint();
    }

    public static void main(String[] args)
    {
        MazeFrame ew = new MazeFrame();
    }
}


//    If a robot has already finished the maze, display a JOptionPane telling the user to choose a new robot. Otherwise, this method starts the robot through the maze:
//        1. Set your boolean variable to indicate the robot is moving.
//        2. Call Thread.sleep(500) . This will delay the running of the program long enough so that you can see the display from its beginning. (The 500 is in milliseconds, so it's not long.) We need this because otherwise the robot moves too fast for the human eye. Remember to handle expectations appropriately.
//        3. Copy the for loop from HW3 MazeDriver project's main() method – with changes:
//         After the robot moves, instead of printing, you will need to redraw the visual. Use a special method in JPanel called paintImmediately() paintImmediately() . Go to the documentation and read about paintImmediately – you will be calling it with your MazePanel object that is placed in the frame, and you'll need to give it the dimensions associated with your MazePanel object when you call it.
//         End your loop body with another call to Thread.sleep(100) . It will give you time to see the route your robot takes along the way to the exit location.