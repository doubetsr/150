package Lab5;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *This lab will read a text file and test the string values
 * to see if they are a palindrome.  There will be two methods
 * that perform the same task.  Palindrome, the first method
 * will perform the task in a recursive model.  PalindromeIterative
 * will perform the task iteratively.
 */

//This is the fifth lab named Lab5
public class Lab5 {
    public static void main(String[] args) throws IOException {
        File inputFile = getInputFile();
        readFile(inputFile);
    }

    /**
     * Create a method to retrieve the file.  This will prompt the user
     * to use File Explorer to select the file.
     * @return
     * @throws IOException
     */
    private static File getInputFile() throws IOException {
        // Get the INPUT filename.
        JFileChooser chooser = new JFileChooser();
        File home = new File(System.getProperty("user.home"));
        chooser.setCurrentDirectory(home);
        int status = chooser.showOpenDialog(null);

        if (status != JFileChooser.APPROVE_OPTION) {
            System.out.println("No File Chosen");
            System.exit(0);
        }

        // Open the file.
        return chooser.getSelectedFile();
    }

    /**
     * This method reads the file and outputs the desired results.
     * @param inputFile
     * @throws IOException
     */
    private static void readFile(File inputFile) throws IOException {
        Scanner inputScanner = new Scanner(inputFile);
        while (inputScanner.hasNext()) {
            String test = inputScanner.nextLine();
            if (isPal(test))
                System.out.println(test + " is a palindrome");
            if (isPalIterative(test))
                System.out.println(test + " is a palindrome");
        }
        inputScanner.close();
    }

    /**
     * This method will call itself and test for palindromes in the file.
     * @param test
     * @return
     */
    private static boolean isPal(String test) {
        test = test.toLowerCase();
        if (test.length() > 1) {
            if (test.charAt(0) == test.charAt(test.length() - 1)) {
                return isPal(test.substring(1, test.length() - 1));
            } else
                return false;
        } else
            return true;
    }

    /**
     * This method will use a boolean expression to iteratively test
     * the file for palindromes.
     * @param test
     * @return
     */
    private static boolean isPalIterative(String test) {
        test = test.toLowerCase();
        boolean isPal = true;
        while (isPal && test.length() > 1) {
            if (test.charAt(0) != test.charAt(test.length() - 1))
                isPal = false;
            else
                test = (test.substring(1, test.length() - 1));

        }
        return isPal;
    }
}