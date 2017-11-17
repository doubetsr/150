package Lab6;

import javax.swing.*;

/***********************************************************************************************************
 * CSIT 150 Lab 6 Spring 2017
 *
 * @author doubster
 *
 * Imagine that you are developing a software package that requires users to enter their own
 passwords. Your software requires that users’ passwords meet the following criteria:

 • The password should be at least six characters long.
 • The password should contain at least one uppercase and at least one lowercase letter.
 • The password should have at least one digit and one special character.
 (A special character is not alphabetic and is not a digit).
 • The password should not be in the array of not allowed passwords.
 In general, this array may include several words, or be null.
 For testing purposes, do not allow passwords to be one of  the following strings: "Password1","Mypassw0rd".
 Ask for the user name and password.
 Keep asking for a password until the user enters a password that meets the criteria above.
 Output the username and the password. Then, output the user and the hidden password “******”.

 Add JavaDoc comments to this program.
 ********************************************************************************************************/

public class Lab6Start {

    /**
     * Create an arrow to keep invalid passwords.
     */
    private static String[] notAllowed = {"Password1", "Mypassw0rd"};

    /**
     * create a boolean method to check if the password is allowed.
     * (not one of the notAllowed strings)
     * @param passWord
     * @param notAllowed
     * @return
     */
    public static boolean isAllowed(String passWord, String[] notAllowed) {
        boolean allowed = false;
        return allowed;
    }

    /**
     * Create a boolean method to check for length, uppercase, lowercase
     * digit, special, and if it is allowed.
     * @param passWord
     * @return
     */
    public static boolean isValidPassword(String passWord) {

        boolean validLength = false;
        boolean foundUpper = false;
        boolean foundLower = false;
        boolean foundDigit = false;
        boolean foundSpecial = false;
        boolean isAllowed = true;

        if (passWord.length() >=6 ){
            validLength = true;
        }

        for (int i = 0; i < passWord.length(); i++)

        {

            if (Character.isLowerCase(passWord.charAt(i)))
                foundLower = true;
            if (Character.isUpperCase(passWord.charAt(i)))
                foundUpper = true;
            if (Character.isDigit(passWord.charAt(i)))
                foundDigit = true;
            if (Character.isLetterOrDigit(passWord.charAt(i)))
                foundSpecial = true;
        }

        for (int i = 0; i < notAllowed.length; i++)
        {
            if (passWord.equals(notAllowed[i]))
                isAllowed = false;
        }

        return validLength && foundUpper && foundLower && foundDigit && foundSpecial && isAllowed;

    }


    /**
     * Setup a way to hide the password.
     * @param passWord
     * @return
     */
    public static StringBuffer hidePassword(String passWord) {
        StringBuffer hiddenPassword = new StringBuffer(passWord);
        for (int i=0; i < hiddenPassword.length(); i++)
            hiddenPassword.setCharAt(i, '*');
            return hiddenPassword;
    }

    /**
     * Run the code with a main method driver.
     * @param args
     */
    public static void main(String[] args) {

        boolean valid = true;
        String userName = "";
        String passWord = "";
        userName = JOptionPane.showInputDialog(null, "Enter your username: ");
        passWord = JOptionPane.showInputDialog(null, "Enter your password: ");
        valid = isValidPassword(passWord);
        while (!valid) {
            passWord = JOptionPane.showInputDialog(null, "Invalid password. Enter a new password: ");
            valid = isValidPassword(passWord);
        }
        StringBuffer hiddenPassword = hidePassword(passWord);
        System.out.println("The username: " + userName + " has password: " + passWord);
        System.out.println("The username: " + userName + " with hidden password: " + hiddenPassword);

    }
}
