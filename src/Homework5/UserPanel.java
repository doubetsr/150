package Homework5;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class UserPanel extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);
    double x = 0, y = 0, velX = 0, velY = 0;
    Maze lostGui;
    Robot robotGui;


    public UserPanel(){
        setBackground(Color.WHITE);
        t.start();
        addKeyListener(this);
        this.setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        lostGui = null;
        robotGui = null;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(40,40,40,40);
        g.setColor(Color.red);
        g.fillOval(40+10,40+10,20,20);
    }

    public void actionPerformed(ActionEvent e){
        repaint();
        x += velX;
        y += velY;

        if(x<0){
            velX = 0;
            x = 0;
        }

        if(x>750){
            velX = 0;
            x = 750;
        }

        if(y<0);{
            velY = 0;
            y = 0;
        }

        if(y>550){
            velY = 0;
            y = 550;
        }
    }

    public void up(){
        velY = -1.5;
        velX = 0;
    }

    public void down(){
        velY = 1.5;
        velX = 0;
    }

    public void left(){
        velX = -1.5;
        velY = 0;
    }

    public void right(){
        velX = 1.5;
        velY = 0;
    }

    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP){
            up();
        }

        if (code == KeyEvent.VK_DOWN){
            down();
        }

        if (code == KeyEvent.VK_LEFT){
            left();
        }

        if (code == KeyEvent.VK_RIGHT){
            right();
        }
    }

    public void keyTyped(KeyEvent e){}

    public void keyReleased(KeyEvent e){

//      velX = 0;
//      velY = 0;
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP){
            velY = 0;
        }
        if (code == KeyEvent.VK_DOWN){
            velY = 0;
        }
        if (code == KeyEvent.VK_LEFT){
            velX = 0;
        }
        if (code == KeyEvent.VK_RIGHT){
            velX = 0;
        }
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
    public static void setRobot(Robot inRobot){
        robotGui = inRobot;
    }

}
