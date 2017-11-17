package Lab0;
import java.io.*;
import java.util.*;

/**
 * UNK CSIT 150
 * Lab 0
 * Fall 2017
 *
 * Based on CSIT 130 lab 14
 * Edited by Sam Doubet to calculate state information.
 *
 * Algorithm for finding highest value in an array
 *
 * int numbers = new int[50];
 * int highest = numbers[0];
 * for (int index = 1; index < numbers.length; index++){
 *     if (numbers[index] > highest)
 *          highest = numbers [index];
 * }
 *
 * Algorithm for finding the lowest value in an array
 * int numbers = new int[50];
 * int lowest = numbers[0];
 * for (int index = 1; index < numbers.length; index++){
 *     if (numbers[index] < lowest)
 *          highest = numbers [index];
 * }
 */

public class StateDataAnalyzer {

    private static int NUMBER_STATES = 50;

    /**
     * Load state names from the file
     * @param fileName
     * @return array of strings with the state names
     * @throws Exception
     */
    public static String[] loadNamesFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        String[] array = new String[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for(int row = 0; row < NUMBER_STATES; row++)
        {
            array[row] = fileScan.next();
            fileScan.nextLine();
        }
        return array;
    }

    /**
     * load the per capita income for each state
     * @param fileName
     * @return array of doubles with the state per capita income
     * @throws Exception
     */
    public static double[] loadPercapitaFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for(int row = 0; row < NUMBER_STATES; row++)
        {   fileScan.next();
            array[row] = fileScan.nextDouble();
            fileScan.nextLine();
        }
        return array;
    }

    /**
     * load the state population from a file
      * @param fileName
     * @return array of integers with each state population
     * @throws Exception
     */
    public static int[] loadPopulationFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        int[] array = new int[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for(int row = 0; row < NUMBER_STATES; row++)
        {   fileScan.next();
            fileScan.next();
            array[row] = fileScan.nextInt();
            fileScan.nextLine();
        }
        return array;
    }

    /**
     * load the land size from a file
     * @param fileName
     * @return array of doubles with each states land size
     * @throws Exception
     */
    public static double[] loadLandSizeFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];

        Scanner fileScan = new Scanner(file);
        for(int row = 0; row < NUMBER_STATES; row++)
        {   fileScan.next();
            fileScan.next();
            fileScan.next();
            array[row] = fileScan.nextDouble();
        }
        return array;
    }

//    /**Create a method to calculate the largest value.
//     * Create a method to calculate the largest value.
//     * Allow the program to choose which array will be
//     * chosen to calculate the largest value.
//     */
//    public findMaxIndex(double[] array){
//        int numbers = new int 50;
//        int highest = numbers[0];
//    for (int index = 1; index < numbers.length; index++) {
//        if (numbers[index] > highest)
//            highest = numbers[index];
//  }
//  }
//
//    /**Create a method to calculate the smallest value.
//     * Create a method to calculate the smallest value.
//     * Allow the program to choose which array will be
//     * chosen to calculate the smallest value.
//     */
//    public findMMinIndex(double[] array){
//        int numbers = new int 50;
//        int highest = numbers[0];
//        for (int index = 1; index < numbers.length; index++) {
//            if (numbers[index] > highest)
//                highest = numbers[index];
//        }
//    }
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String fileName        = "State_Data.csv";
        String[] stateNames    = loadNamesFromFile(fileName);
        double[] percapitaData = loadPercapitaFromFile(fileName);
        int[] populationData   = loadPopulationFromFile(fileName);
        double[] landSizeData  = loadLandSizeFromFile(fileName);

        //This code will print the data to console to ensure you are reading
        //  the data in and that the arrays are loaded.
        //  This should be deleted once you have suceeded in laoding the data.
        System.out.print("\nState data");
        System.out.print("\n\t\t "+"Per Capita");
        System.out.print("\nName"+"\t "+"Income"+"\t\t "+"Population"+"\t\t "+"Land Size");

        for(int row = 0; row < NUMBER_STATES; row++)
        {
            System.out.print("\n"+stateNames[row]+"\t  "+percapitaData[row]+"\t  "+populationData[row]+"\t  "+landSizeData[row]);
        }

        //display introduction (by method)
        //create program loop with menu


    }

}
