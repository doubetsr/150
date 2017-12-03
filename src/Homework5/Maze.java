package Homework5;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is a "wrapper" class around a 2D array that contains the maze character data.
 *
 * CSIT 150
 * Homework 2
 * @author Sam Doubet with help from Dr. Sherri Harms.
 */

public class Maze {

    int rows, cols, startrow, startcol, exitrow, exitcol;
    char[][] cell;

    /**
     * Constructor that reads the maze from a file.
     */
    public Maze(File inputFile) {

            try {
            Scanner readFile = new Scanner(inputFile);

            rows = readFile.nextInt();
            cols = readFile.nextInt();
            startrow = readFile.nextInt();
            startcol = readFile.nextInt();
            exitrow = readFile.nextInt();
            exitcol = readFile.nextInt();
            readFile.nextLine(); //rest the buffer
            cell = new char[rows][cols];

            int r = 0;
            while (r < rows) {
                String line = readFile.nextLine();
                for (int c = 0; c < cols; c++) {
                    cell[r][c] = line.charAt(c);
                }
                r++;
            }
        }
        catch(IOException | InputMismatchException e){
                System.out.println("Caught Exception" + e.getMessage());
                System.exit(0);
        }

    }

    /**
     * Returns the number of rows in the maze.
     *
     * @return
     */
    public int getRows() {
        return rows;
    }

    /**
     * returns the number of columns in the maze.
     *
     * @return
     */
    public int getCols() {
        return cols;
    }

    /**
     * returns the starting cell row.
     *
     * @return
     */
    public int getStartRow() {
        return startrow;
    }

    /**
     * returns the starting cell column.
     *
     * @return
     */
    public int getStartCol() {
        return startcol;
    }

    /**
     * returns the exit cell's row.
     *
     * @return
     */
    public int getExitRow() {
        return exitrow;
    }

    /**
     * returns the exit cell's column
     *
     * @return
     */
    public int getExitCol() {
        return exitcol;
    }

    /**
     * returns the character stored in "this" cell.
     *
     * @param row
     * @param col
     * @return
     */
    public char getCell(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols)
            return cell[row][col];
        else
            return '*';
    }

    /**
     * sets the value stored in "this" cell.
     *
     * @param row
     * @param col
     * @return
     */
    public boolean openCell(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (cell[row][col] == '*')
                return false;
            else if (row == startrow && col == startcol)
                return false;
            else if (row == exitrow && col == exitcol)
                return true;
            else
                return true;
        } else return false;
    }

    /**
     * Sets the value stored in this cell.
     *
     * @param row
     * @param col
     * @param newCh
     */
    public void setCell(int row, int col, char newCh) {

        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            cell[row][col] = newCh;
        }

    }

    /**
     * ToString to print out the maze and where the robot is.
     * @return
     */
    public String toString() {
        String output = "";

        int k = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                output += cell[i][j];
            output += "\n";
        }

        return output;
    }
}