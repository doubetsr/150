package Lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExerciseDisplay extends JPanel{

    private ExerciseGame game;
    private final int START_X = 200;
    private final int START_Y = 100;
    private final int START_Width = 50;
    private final int START_Height= 100;
    private int[][] oArray;


    /**
     * Constructor to create the display.
     */
    public ExerciseDisplay() {
        game = new ExerciseGame(START_X,START_Y ,START_Width,START_Height );
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {
                oArray = game.processMove(me.getX(),me.getY());
                System.err.print("\n mouse clicked");
                repaint();
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }
        });
    }

    /**
     * Add a paint component.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int dex = 0; dex < oArray.length; dex++) {
            g.setColor(Color.GREEN);
            g.drawOval(oArray[dex][0], oArray[dex][1], oArray[dex][2], oArray[dex][3]);//outline
            g.setColor(new Color(oArray[dex][4],oArray[dex][5],oArray[dex][6]));//set color to red, green, blue
            g.fillOval(oArray[dex][0], oArray[dex][1], oArray[dex][2], oArray[dex][3]);//draw oval
        }
    }


}
