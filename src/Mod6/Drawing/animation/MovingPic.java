/* This is a sample animation for continuous motion using a timer;
    CSIT 150
Auther: C. Anderosn
Date: 2-23-14
Revised 3-10-15
*/
package Mod6.Drawing.animation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingPic extends JPanel implements ActionListener, KeyListener 
{
    int maxX, maxY, minX, minY;
    
    Timer t = new Timer(5, this);// this is the method that provide continuous motion for a
                                 // specific amount of time;
    int x=0,y=0,velx=0,vely=0;
    int impulse;
    int step = 1;
    int ballSize = 40;
    public MovingPic(int x, int y)
    {
        maxX =x;
        minX = 0;
        minY = 0;
        maxY = y;
        
        t.start();  // this is the method that provide continuous motion for a
                    // specific amount of time;
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
       
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawString("Click arrow keys to start ball and change direction!!", 200, 200);
        Graphics2D g2 = (Graphics2D)g;
        g2.fillOval(x,y,ballSize,ballSize);
    }
    
    public void up()
    {
        vely = -step;
        velx = minX; 
    }
    
    public void down()
    {
        vely = step;
        velx = minX; 
    }
    
    public void left()
    {
        vely = minY;
        velx = -step; 
    }
    
    public void right()
    {  
        vely = minY;
        velx = step; 
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        repaint();
        x+=velx;
        y+=vely;
        if (x > maxX)
            x=minX;
        if (x < minX-ballSize)
            x=maxX;
        if( y > maxY)
            y = minY;
        
        if( y < minY-ballSize)
            y = maxY;
        
    }
    
    public void keyPressed(KeyEvent ke)
    {
        int code = ke.getKeyCode();
        if( code == KeyEvent.VK_UP)
            up();
        else if( code == KeyEvent.VK_DOWN)
            down();
        else if( code == KeyEvent.VK_RIGHT)
            right();
        else if( code == KeyEvent.VK_LEFT)
            left();
    }
    
    public void keyReleased(KeyEvent ke)
    {
        
    }
    
    public void keyTyped(KeyEvent ke)
    {
        
    }
    
}
