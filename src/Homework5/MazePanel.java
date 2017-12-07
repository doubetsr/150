package Homework5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * MazePanel will handle the paintComponent that prints out the
 * Maze and the robot during each action and move performed.
 * CSIT 150 Homework 4
 *
 */
public class MazePanel extends JPanel implements KeyListener {

    //Create a Maze and Robot object.
    private Maze lostGui;
    private Robot robotGui;
    private Robot dirtyRobot;
    double userX = 0, userY = 0;
    private int direction;

    //Lay out the Default Constructor and assign values to null.
    //Values will be loaded in the MazeFrame.
    public MazePanel() {
        lostGui = null;
        robotGui = null;
        dirtyRobot = null;
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    /**
     * Override the paint component to obtain the desired results.
     * Remember:
     * char '*' is the maze boundary
     * char ' ' is the open path
     * char 'r' is the robot
     * char 'S' is the start
     * char 'X' is the finish
     * @param g
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (lostGui != null) {
            for (int i = 0; i < lostGui.getRows(); i++) {
                for (int j = 0; j < lostGui.getCols(); j++) {

                    //set the boundary blue
                    if (lostGui.getCell(i, j) == '*') {
                        g.setColor(Color.BLUE);
                        g.fillRect(j*40,i*40,40,40);
                    }

                    //set the robot circle as half the Width and Height of a cell.
                    //Also, set background to white.
                    else if (lostGui.getCell(i, j) == 'r') {
                        g.setColor(Color.WHITE);
                        g.fillRect(j*40,i*40,40,40);
                        g.setColor(Color.red);
                        g.fillOval(j*40+10,i*40+10,20,20);
                    }

                    //set the char "space" to White
                    else if (lostGui.getCell(i, j) == ' ') {
                        g.setColor(Color.WHITE);
                        g.fillRect(j*40,i*40,40,40);
                    }

                    //set the Start to another unused color
                    else if (lostGui.getCell(i, j) == 'S') {
                        g.setColor(Color.RED);
                        g.fillOval(40+10,40+10,20,20);
                    }

                    //set the Exit to another unused color
                    else if (lostGui.getCell(i, j) == 'X') {
                        g.setColor(Color.GREEN);
                        g.fillRect(j*40,i*40,40,40);
                    }

                    else if (lostGui.getCell(i, j) == 'd') {
                        g.setColor(Color.ORANGE);
                        g.fillOval(40+10,40+10,20,20);
                    }
                }
            }
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        repaint();
        robotGui.move(direction);
    }

    public void up(){
        if (!robotGui.solved()){
            direction = 1;
            robotGui.move(direction);
//            dirtyRobot.move(dirtyRobot.chooseMoveDirection());
            repaint();
        }
        //check to see if it hits enemy
        //check to see if it finished maze
    }

    public void right(){
        if (!robotGui.solved()){
            direction = 2;
            robotGui.move(direction);
//            dirtyRobot.move(dirtyRobot.chooseMoveDirection());
            repaint();
        }
    }

    public void down(){
        if (!robotGui.solved()){
        direction = 3;
            robotGui.move(direction);
//            dirtyRobot.move(dirtyRobot.chooseMoveDirection());
            repaint();
        }
    }

    public void left(){
        if (!robotGui.solved()){
            direction = 4;
            robotGui.move(direction);
//            dirtyRobot.move(dirtyRobot.chooseMoveDirection());
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            up();
        }
        if (code == KeyEvent.VK_DOWN) {
            down();
        }

        if (code == KeyEvent.VK_LEFT) {
            left();
        }
        if (code == KeyEvent.VK_RIGHT) {
            right();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Create a setMaze method to setup the maze object.
     * @param inMaze
     */
    public void setMaze (Maze inMaze){
        lostGui = inMaze;
    }

    /**
     * Create a setRobot method to setup the robot object.
     * @param inRobot
     */
    public void setRobot (Robot inRobot){
        robotGui = inRobot;
    }

    //implement HWK5 changes to add user control KeyEvent listeners.



    public double getUserX() {
        return userX;
    }

    public double getUserY() {
        return userY;
    }

    public void setUserX(double userX) {
        this.userX = userX;
    }

    public void setUserY(double userY) {
        this.userY = userY;
    }
}
