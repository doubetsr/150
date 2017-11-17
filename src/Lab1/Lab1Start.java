package Lab1;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/***
 * Lab 1 is an example of using a two-dimensional array of temperatures.
 * This lab uses the same data file as Lab 15 from the fall 2012 CSIT 130 class.
 * Many thanks to John Russell for helping me through this assignment.
 * @author harmssk
 * @author doubetsr
 * @date September 5th 2017
 *
 */


public class Lab1Start {

    final static int MONTHS = 12;
    final static int NUMYEARS = 6;

    /**
     * get input file from user
     * @return Scanner file for input
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
     * Main method.
     * @param args
     */
    public static void main(String[] args) throws IOException {
        DecimalFormat formatter = new DecimalFormat("0.00");
        File inputFile = getInputFile();

        //Store the month names
        String[] months = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October",
                "November", "December"};

        //FINISH

        //Store the temperatures for the first day of the month for six years
        //into a two dimensional array, by calling the readFile method
        double[][] temperatures = readFile(inputFile);

        //starting output message
        System.out.println("Month\t\tTemperatures\t\t\t\t\t\t\t\t\tAverage");

        //for each month (create and call methods as needed)
        //calculate the monthly average of the temperatures in the array
        // bonus: calculate the monthly standard deviation of the temperatures in the array
        //output the month name, the average temperature and for bonus the standard deviation.
        for (int i = 0; i < months.length; i++) {
            System.out.printf("%-12s",months[i] + ":");
            System.out.printf(getMonthValues(temperatures, i) + formatter.format(getRowAverage(temperatures[i])) +"\n");
        }

        //output the column averages - create methods as needed
        System.out.println("Average column (Yearly) temperatures");
        System.out.printf("\t\t\t");
        for (int i = 0; i < NUMYEARS; i++) {
            System.out.printf(formatter.format(getColumnAverage(temperatures, i)) + "\t");
        }

        System.out.println("\nThank you.");
    }

    /**
     * Calculate the average of temperatures for a month, stored a 1 dim array
     *
     * @param monthTemps
     * @return average of the numbers in the array
     */
    private static double calcRowAverage(double[] monthTemps) {
        double sum = 0;
        for (int i = 0; i < monthTemps.length; i++) {
            sum += monthTemps[i];
        }
        return sum / monthTemps.length;
    }

    /**
     * read the temperature data into a two-dimensional array
     *
     * @param inputFile
     * @return
     * @throws FileNotFoundException
     */
    private static double[][] readFile(File inputFile) throws IOException {
        Scanner inputScanner = new Scanner(inputFile);
        int m = 0;//current month value to store temperatures
        double[][] temperatures = new double[MONTHS][NUMYEARS];
        while (inputScanner.hasNext()) {
            String monthData = inputScanner.nextLine();
            String[] splitData = monthData.split(",");
            //FINISH
            //For each temperature
            //read temperature value from the splitData and store into the correct spot in the array
            for (int i = 1; i < splitData.length; i++) {
                temperatures[m][i - 1] = Double.parseDouble(splitData[i]);
            }

            //get ready to read the next line in the file (for the next month)
            m++;
        }
        //remember to close the file
        inputScanner.close();

        return temperatures;
    }

    /**
     * Create a method to get the average temperatures
     * in the row of a two dimentional array.
     * loop
     * @param rows
     * @return
     */
    private static double getRowAverage(double[] rows)
    {
        double sum = 0;
        for (int r=0;r<rows.length;r++)
            sum +=rows[r];
        return sum/rows.length;
    }

    /**
     * Create a method to get the average temperatures
     * in the column of a two dimentional array.
     * @param column
     * @param c
     * @return
     */
    private static double getColumnAverage(double[][] column, int c) {
        double sum = 0;
        for (int r=0;r<column.length;r++)
            sum +=column[r][c];
        return sum/column.length;
    }

    /**
     * Create a method to obtain the month values.
     * @param temperatures
     * @param r
     * @return
     */
    private static String getMonthValues(double[][] temperatures, int r) {
        String values = "";
        for (int c = 0; c < temperatures[r].length; c++)
            values += temperatures[r][c] + "\t";
        return values;
    }

}