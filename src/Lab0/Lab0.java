package Lab0;

import javax.swing.*;
/**
 * Created by harmssk on 8/21/2017.  Original code edited by Sam Doubet.
 * The purpose of the code has been changed to execute state data calculations.
 */
public class Lab0 {

    public static void main(String[] args) throws Exception {

        String statesintro = "This program will provide information " +
                "derived from state data." + "\nYou may use the options to " +
                "calculate minimum and maximum values.\n" +
                "The state data includes state name, " +
                "population, median income, and land.\n";

        String menu = "Enter the Letter corresponding to the task \n" +
                "you would like to complete, or Q to quit!\n" +
                "\nA - Find state with maximum land mass." +
                "\nB - Find state with minimum land mass." +
                "\nC - Find state with maximum population." +
                "\nD - Find state with minimum population." +
                "\nE - Find state with maximum average income." +
                "\nF - Find state with minimum average income." +
                "\n\nQ - Quit.";

        do {
            String response = JOptionPane.showInputDialog(null,
                    statesintro + menu, "Menu", 1);
            char letter = response.toUpperCase().charAt(0);
            switch (letter) {
                case 'A':
                    JOptionPane.showMessageDialog(null, "You chose A", "Chose A", 1);
                    break;
                case 'B':
                    JOptionPane.showMessageDialog(null, "You chose B", "Chose B", 1);
                    break;
                case 'C':
                    JOptionPane.showMessageDialog(null, "You chose C", "Chose C", 1);
                    break;
                case 'D':
                    JOptionPane.showMessageDialog(null, "You chose D", "Chose D", 1);
                    break;
                case 'E':
                    JOptionPane.showMessageDialog(null, "You chose E", "Chose E", 1);
                    break;
                case 'F':
                    JOptionPane.showMessageDialog(null, "You chose F", "Chose F", 1);
                    break;
                case 'Q':
                    JOptionPane.showMessageDialog(null, "Program terminating",
                            "Ending", 1);
                    System.exit(0);
                    break;
            }
            statesintro = "";
        }
        while (true);
    }

}