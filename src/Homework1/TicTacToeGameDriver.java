package Homework1;

import javax.swing.*;

public class TicTacToeGameDriver {



    public static void main(String[] args) throws Exception {

        String input, playerA, playerB;
        char switchTurn = 'O';

        Player A = new Player('A');

        playerA = JOptionPane.showInputDialog(null,
                "Enter name for Player 1", "Menu", 1);

        A.setName('X');

        Player B = new Player('A');

        playerB = JOptionPane.showInputDialog(null,
                "Enter name for Player 1", "Menu", 1);

        A.setName('O');

        GameBoard GameBoard = new GameBoard();

        System.out.println(GameBoard.toString());

        String introduction = "Welcome to Tic-Tac-Toe"
                + "\nYou should enter the character corresponding to \n" +
                "the move you would like to make and then click on OK. \n\n" +
                "\nThe program will always return to the player menu.\n\n" +
                "To make a new game or reset the board enter N\n" +
                "To exit the game press ";

        String menu = "Enter the Letter corresponding to the move \n" +
                "you would like to make. R will reset the board.  Q will quit the game.\n" +
//                "\nS - To start over." +
                "\n\nQ - to quit.";


        do {
            String response = JOptionPane.showInputDialog(null,
                    introduction + menu, "Menu", 1);
            char letter = response.toUpperCase().charAt(0);

            switchTurn = (switchTurn == 'X') ? 'O' : 'X';

            switch (letter) {
                case '1':
                    GameBoard.checkOpen('1');
                    GameBoard.playerMove('1', A);
                    GameBoard.checkForWinner (A);
                    break;

                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    break;
                case '5':
                    break;
                case '6':
                    break;
                case '7':
                    break;
                case '8':
                    break;
                case '9':
                    break;
                case 'R':
                    break;
                case 'Q':
                    JOptionPane.showMessageDialog(null, "Program terminating",
                            "Ending", 1);
                    System.exit(0);
                    break;
            }

        }

                while (true) ;
//            check values to see if the game is over;
//            if winner return the winner and end game;
//            else if all X and O return draw;
//            "else continue do while loop"
//            introduction = "";
//            display gameboard;

    }
}


