package Homework1;

import javax.swing.*;

public class GameBoard {
    char[][] board;
    int x;

    public GameBoard() {
        board = new char[3][3];
        fillBoard();
    }

    public void fillBoard() {
        int k = 1;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                board[i][j] = (char) (k + 48);
                k++;
            }
    }

    public String printBoard(String x) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        return x;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == 'X' || board[i][j] == 'O')
                {
                    return false;
                }
        return true;
    }

    public void addBoard(char[][] board) {

        this.board = board;
    }


    public void playerMove(char pos, Player p){

        int row;
        int col;
        if (x == 1) {
            row = (pos - 1) / 3;
            col = (pos - 1) % 3;

            board[row][col] = p.getName();
        }
    }

    public void checkOpen(char open){
        if (open != 'X' || open != 'O')
            x = 1;
        else
            x = 0;
    }

    public boolean checkForWinner(Player p)
    {
       for (int i=0; i < 3; i++)
            if (board[i][0] == board[i][1]
                    && board[i][1] == board[i][2])
            {
           return true;
            }

        for (int j=0; j < 3; j++)
            if (board[0][j] == board[1][j]
                    && board[1][j] == board[2][j])
            {
            return true;
            }
        if (board[0][0] == board[1][1]
                && board[1][1] == board[2][2])
        {
            return true;
        }

        if (board[0][2] == board[1][1]
                && board[1][1] == board[2][0])
        {
            return true;
        }
        return false;
    }

    public String displayIntro() {

        String introduction = "Welcome to Tic-Tac-Toe"
                + "\nYou should enter the letter corresponding to \n" +
                "the move you would like to make and then click on OK. \n\n"
                + "You will be given additional instructions to follow \n" +
                "and when they are done, the results will be displayed\n." +
                "\nThe program will always return to the player menu.\n\n" +
                "To make a new game or reset the board enter N\n\n";

        JOptionPane.showMessageDialog(null, introduction);

        return introduction;
    }

    @Override
    public String toString() {

        return printBoard("");
    }
}
