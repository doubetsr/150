package Homework4;

import javax.swing.*;
import java.awt.*;
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

public MazeFrame () {
    this.setTitle("Exercise Window");
    this.setSize(1000,1000 );
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initializeWindow();
    this.setVisible(true);
    }

    public void initializeWindow()
    {
        guiPanel = new MazePanel();
        this.add(guiPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args)
    {
        MazeFrame ew = new MazeFrame();
    }
}
