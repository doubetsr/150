package Homework5;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MazePanel extends JPanel {

    private Maze lostGui;
    private Robot robotGui;

    public MazePanel() {

        lostGui = null;
        robotGui = null;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //System.out.println("paint component running!");
        if (lostGui != null) {
            for (int i = 0; i < lostGui.getRows(); i++) {
                for (int j = 0; j < lostGui.getCols(); j++) {
                    if (lostGui.getCell(i, j) == '*') {
                        g.setColor(Color.BLUE);
                        g.fillRect(j*40,i*40,40,40);
                    } else if (lostGui.getCell(i, j) == 'r') {
//                        g.setColor(Color.WHITE);
//                        g.fillRect(j*40,i*40,40,40);
                        g.setColor(Color.red);
                        g.fillOval(j*40+10,i*40+10,20,20);

                    } else if (lostGui.getCell(i, j) == ' ') {
                        g.setColor(Color.WHITE);
                        g.fillRect(j*40,i*40,40,40);


                    } else if (lostGui.getCell(i, j) == 'S') {
                        g.setColor(Color.ORANGE);
                        g.fillRect(j*40,i*40,40,40);

                    } else if (lostGui.getCell(i, j) == 'X') {
                        g.setColor(Color.GREEN);
                        g.fillRect(j*40,i*40,40,40);

                    }
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
        lostGui = inMaze;
    }

    public void setRobot (Robot inRobot){
        robotGui = inRobot;
    }


}
