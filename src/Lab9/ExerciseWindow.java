package Lab9;

import javax.swing.*;
import java.awt.*;

/**
 * CSIT 150 Fall 2017.
 * Special thanks to Andrew for helping me out.
 * @author canderson
 * @author Sam Doubet
 */

/**
 * create a JFrame object.
 */
public class ExerciseWindow extends JFrame {

    private int win_width = 400;
    private int win_height= 300;
    private ExerciseDisplay panel;

    /**
     * Constructor to create the object.
     */
    public ExerciseWindow (){

        this.setTitle("Exercise Window");
        this.setSize(win_width , win_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeWindow();
        this.setVisible(true);
    }

    /**
     * initializer to set the window.
     */
    public void initializeWindow()
    {
        panel = new ExerciseDisplay();
        this.add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args)
    {
        ExerciseWindow ew = new ExerciseWindow();
    }
}
