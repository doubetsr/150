/**
 * Animation demonstration Code
 * CSIT 150 
 * Catherine Anderson
 * created Spring 2014
 * revised Spring 2015
 * 
 * Creates a board where the ball moves 300 steps when the mouse is clicked
 * anywhere.  It will "bounce" off the walls.
 * 
 */
package Mod6.Drawing.animation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DrawingBoard extends JPanel
{
    int currentStart_X = 1;
    int currentStart_Y = 1;
    int x_one = 1;
    int y_one =1;
    
    int sleepTime = 30;
    int cycles = 300;
    int stepSize = 15;
    
    int board_x = 10;
    int board_y = 10;
    int boardWidth = 500;
    int boardHeight = 500;
    int ball_width =20;
    
    Random randGen;
    
    public DrawingBoard()
    {
        this.addKeyListener(null);
        randGen = new Random();
        currentStart_X = 150;
        currentStart_Y = 20;
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                moveIT(me);
            }
        });
    }
    
    public void moveIT(MouseEvent me)
    {  
        if(randGen.nextBoolean())
        {   x_one*=-1;
        }
        if(randGen.nextBoolean())
        {   y_one*=-1;
        }
        for(int dex = 1; dex< cycles; dex++)
        {  currentStart_X+=stepSize*x_one;
           if(currentStart_X < board_x)
           {    currentStart_X = board_x;
                x_one *=-1;
           }
           if(currentStart_X > boardWidth -ball_width/2)
           {    currentStart_X = boardWidth-stepSize;
                x_one *=-1;
           }
           currentStart_Y+=10*y_one;
           if(currentStart_Y < board_y)
           {    currentStart_Y = board_y;
                y_one *=-1;
           }
           if(currentStart_Y >  boardHeight-ball_width)
           {    currentStart_Y = boardHeight - stepSize;
                y_one *=-1;
           }
           try
           {   this.paintImmediately(board_x,board_y,boardWidth,boardHeight);
               Thread.sleep(sleepTime);
           }catch(Exception e)
           {
               e.printStackTrace();
               System.exit(1);
           }
        }
        repaint();
    }
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect (board_x,board_y,boardWidth,boardHeight);
       
        g.setColor(Color.blue);
        g.fillOval(currentStart_X, currentStart_Y, ball_width, ball_width);
          
    }
}
