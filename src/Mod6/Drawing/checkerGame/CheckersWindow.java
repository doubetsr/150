/*
 * CSIS 150 
 * 
 * Starting of Checkers Game
 * Cate Anderson
 * Created: 3-13-14
 * 
 * Window to hold the game display
 * 
 */
package Mod6.Drawing.checkerGame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * This is the skeleton for a checkers game
 * the board is drawn, along with all of the checkers.
 * The user can move the checkers anywhere.
 * The logic of the checkers game is not implemented.
 * 
 * @author harmssk
 *
 */
public class CheckersWindow extends JFrame
{
    int titleBarHeight = 20;
    CheckersBoard board;
    JTextField rowCountTxt;
    
   /**
    * constructor
    */ 
   public CheckersWindow()
   {
       this.setTitle("Checkers");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       board = new CheckersBoard(8);
       int width = board.getSize().width;
       int height = board.getSize().height+titleBarHeight+80;
       this.setSize(width,height);
       this.add(board, BorderLayout.CENTER);
       initButs();
       this.setVisible(true);
   }
   
   /**
    * initializes the components under the game board.
    */
   public void initButs()
   {
       JPanel butPan = new JPanel(new GridLayout(2,1));
       JPanel topPan = new JPanel();
       JPanel botPan = new JPanel();
       
       butPan.add(topPan);
       butPan.add(botPan);
       
       JLabel rowCountLab = new JLabel("cells per side: ");
       topPan.add(rowCountLab);
       rowCountTxt = new JTextField("8");
       topPan.add(rowCountTxt);
       JButton rowCountBut = new JButton("Set new row-columns");
       botPan.add(rowCountBut);
       
       rowCountBut.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent me) {
                    rowButClicked(me);
                }
            });
      
       
       this.add(butPan, BorderLayout.SOUTH);
   }
    
    /**
     * action to be performed if button is clicked to change the number of rows
     * on game board
     * @param me 
     */
    public void rowButClicked(MouseEvent me)
    {
         board.setDimensions(Integer.parseInt(rowCountTxt.getText()));
         
    };
    
    /**
     *  main method
     * @param args 
     */
    public static void main(String[] args)
    {
        CheckersWindow cw = new CheckersWindow();
    }
    
}
