package Homework4;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {

    private Maze lostGui;
    private Robot robotGui;
    private int[][] rectArray = new int[20][20];

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (int i = 0; i < lostGui.getRows(); i++) {
            for (int j = 0; j < lostGui.getCols(); j++) {
                if (lostGui.getCell(i,j) == '*')
                {
                    g.setColor(Color.BLUE);
                    g.drawRect(rectArray[i][j], rectArray[i][j], rectArray[i][j], rectArray[i][j]);//outline
                }

                else if (lostGui.getCell(i,j) == 'r')
                {
                    g.setColor(Color.red);
                    g.drawRect(rectArray[i][j], rectArray[i][j], rectArray[i][j], rectArray[i][j]);//outline
                    g.setColor(new Color(rectArray[i][j], rectArray[i][j], rectArray[i][j]));//set color to red, green, blue
                    g.fillRect(rectArray[i][j], rectArray[i][j], rectArray[i][j], rectArray[i][j]);//draw oval
                }

                else if (lostGui.getCell(i,j) == ' ') {
                    g.setColor(Color.GRAY);
                    g.drawRect(rectArray[i][j], rectArray[i][j], rectArray[i][j], rectArray[i][j]);//outline
                }

                else if (lostGui.getCell(i,j) == 'S') {
                    g.setColor(Color.white);
                    g.drawRect(rectArray[i][j], rectArray[i][j], rectArray[i][j], rectArray[i][j]);//outline
                }

                else if (lostGui.getCell(i,j) == 'X') {
                    g.setColor(Color.GREEN);
                    g.drawRect(rectArray[i][j], rectArray[i][j], rectArray[i][j], rectArray[i][j]);//outline
                }
            }
        }
    }


//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        if (robotGui != null) {
//            g.setColor(Color.red);
//            int row = robotGui.getX();
//            int col = robotGui.getY();
//            g.fillOval(row, col, robotGui.getBallWidth(), robotGui.getBallWidth());
//        }
//    }

//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        // drawing board
//        for(int row = 0; row < dimensions; row++)
//        {
//            int count = 0;
//            for(int col = 0; col < dimensions; col++)
//            {
//                if(row%2==0 && col==0)
//                    count =1;
//                count ++;
//                g.setColor(colors[count%2]);
//                g.fillRect(cellWidth*col, cellWidth*row, cellWidth, cellWidth);
//            }
//        }
//
//        //drawing tokens
//        g.setFont(font);
//        for(int row = 0; row < dimensions; row++)
//        {
//            int count = 0;
//            for(int col = 0; col < dimensions; col++)
//            {
//                CheckerToken curTok =game.getToken(row, col);
//                if(curTok != null)
//                {
//                    //g.setColor(chColors[(curTok.getPlayer()+1)%2]);
//                    g.setColor(chColors[curTok.getPlayer()]);
//                    g.fillOval(cellWidth*col+offset, cellWidth*row+2*offset, cellWidth-(2*offset), cellWidth-(4*offset));
//
//                    g.setColor(colors[1]);
//                    g.drawOval(cellWidth*col+offset, cellWidth*row+2*offset, cellWidth-(2*offset), cellWidth-(4*offset));
//
//                    g.setColor(chColors[curTok.getPlayer()]);
//                    g.fillOval(cellWidth*col+offset, cellWidth*row+offset, cellWidth-(2*offset), cellWidth-(4*offset));
//
//                    g.setColor(colors[1]);
//                    g.drawOval(cellWidth*col+offset, cellWidth*row+offset, cellWidth-(2*offset), cellWidth-(4*offset));
//                    if( curTok.getStatus() == 'K')
//                    {
//                        g.setColor(chColors[curTok.getPlayer()]);
//                        g.fillOval(cellWidth*col+offset, cellWidth*row, cellWidth-(2*offset), cellWidth-(4*offset));
//
//                        g.setColor(colors[1]);
//                        g.drawOval(cellWidth*col+offset, cellWidth*row, cellWidth-(2*offset), cellWidth-(4*offset));
//                        g.drawString(""+curTok.getStatus(),cellWidth*col+titleOffSet, cellWidth*row+3*offset);
//                    }
//                    else
//                    {
//                        g.drawString(""+curTok.getStatus(),cellWidth*col+titleOffSet, cellWidth*row+3*offset);
//                    }
//                }
//            }
//        }
//    }


    public void setMaze (Maze inMaze){
        Maze lostGui = inMaze;
    }

    public void setRobot (Robot inRobot){
        Robot robotGui = inRobot;
    }


}
