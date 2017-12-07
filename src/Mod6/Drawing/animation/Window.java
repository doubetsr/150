/* This is the frame for a sample animation for continuous motion using a timer;
    CSIT 150
Auther: C. Anderosn
Date: 2-23-14
Revised 3-10-15
*/
package Mod6.Drawing.animation;

import javax.swing.*;


public class Window extends JFrame{
    private int startX = 800;
    private int startY = 600;
    
    public Window()
    {
      
        MovingPic mp = new MovingPic(startX,startY);
        add(mp);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(startX,startY);
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Window win = new Window();
                
            }
        });
    }
}