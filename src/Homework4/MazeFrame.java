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
    JMenuItem fileOpenMenuItem;
    JMenuItem fileSaveMenuItem;
    JMenuItem robotMenuItem;
    JMenuItem exitMenuItem;
    JMenu fileMenu;
    JMenuBar menuBar;


public MazeFrame () {
    this.setTitle("Exercise Window");
    this.setSize(500,500 );
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



        // Create the menu items
        fileOpenMenuItem = new JMenuItem("Open a file");
        fileSaveMenuItem = new JMenuItem("Save");
        exitMenuItem = new JMenuItem("exit");

        // Add these menu items into fileMenu
        fileMenu.add(fileOpenMenuItem);
        fileMenu.add(fileSaveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // Hook up the menu items with the listener
        MyListener listener = new MyListener();
        exitMenuItem.addActionListener(listener);
        fileOpenMenuItem.addActionListener(listener);
 //       fileSaveMenuItem.addActionListener(listener);
        menuBar.add(fileMenu);

    }

    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == exitMenuItem)
                System.exit(0);
            else if(e.getSource() == fileOpenMenuItem){
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
                    repaint();

                }
            }
//            else if(e.getSource() == fileSaveMenuItem){
//                writeFile();  //save the file
//            }
//            else if(e.getSource() == colorMenuItem){
//                // Show a dialog to allow the user to choose a color
//                Color selected = JColorChooser.showDialog(null, "choose a color", Color.BLACK);
//                if (selected != null){
//                    // Set the background of the window
//                    colorPanel.setBackground(selected);
//                }
//            }
        }
    }

    public void initializeWindow()
    {
        // Set the layout of the window
        setLayout(new BorderLayout());
        guiPanel = new MazePanel();
        this.add(guiPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args)
    {
        MazeFrame ew = new MazeFrame();
    }
}
