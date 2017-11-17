package Midterm;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Midterm will create TwoDPoint objects and
 * calculate the area of given points.
 * Code has been given to provide an example
 * using TwoDPoint a and TwoDPoint b.
 * Time permitting, Midterm will read from a
 * text file containing values stored on each
 * line as such:
 * (x1, y1): (1,1)
 * (x2, y2): (2,2)
 *
 */
public class Midterm {

    /**
     *  get input file
     *  @return Scanner file for input
     *  @throws IOException
     */
    private static File getInputFile() throws IOException {
        // Get the INPUT filename.
        JFileChooser chooser = new JFileChooser();
        File home = new File(System.getProperty("points x and y"));
        chooser.setCurrentDirectory(home);
        int status = chooser.showOpenDialog(null);
        if (status != JFileChooser.APPROVE_OPTION) {
            System.out.println("No File Chosen");
            System.exit(0);
        }

        // Open the file.
        return chooser.getSelectedFile();
        /**
         *  recording new point data into two dimensional array
         *  @return
         *  @throws FileNotFoundException
         */
    }


    /**
     * Main drive method of Midterm
     */
    public static void main(String[] args) throws IOException {

        //Create points a and b
        TwoDPoint a = new TwoDPoint(1, 1);
        TwoDPoint b = new TwoDPoint(5, 4);

        //Calculate the area of points a and b
        TwoDPoint areaValue = new TwoDPoint();  //Reference the area of any two values.

        //print the X, Y, and area values of points a and b.
        System.out.println("Point a has a x value of " + a.getX() +
                "and a y value of " + a.getY() + "\nPoint b has a x value of "
                + b.getX() + "and a y value of " + b.getX() +
                "\nThe area of the square created by the two points is: "
                + areaValue.getArea(a,b));

//    /*
//    The attached file contains a number of points, followed by the next point data on
//    each line.  Using this file,  create an array of point values and construct each
//    house from a line in the file, such as:
//    TwoDPoint point[i] = new TwoDPoint(x1,y1);
//    */
//
//
//    private static TwoDPoint[] readFile(File String inputFile;
//        inputFile) throws IOException
//    {
//        Scanner inputScanner = new Scanner(inputFile);
//        int h=0;//current month value to store temperatures
//        int numberOfPoints = inputScanner.nextInt();
//        inputScanner.nextLine(); //skip past the end of line
//        TwoDPoint [] houses = new TwoDPoint[numberOfPoints];
//        while (inputScanner.hasNext()) {
////owner: Cate house: (60,50)
//            String line = inputScanner.nextLine();
//            StringTokenizer tokenizer = new StringTokenizer(line, ":(,)
//                    ");        //FINISH
//                    tokenizer.nextToken(); //throw away the word "owner"
//            String owner = tokenizer.nextToken();
//            tokenizer.nextToken(); //throw away the word "house"
//            int x = Integer.parseInt(tokenizer.nextToken());
//            int y = Integer.parseInt(tokenizer.nextToken());
//            houses[h] = new TwoDPoint(x,y);
//            h++;
//        }
////remember to close the file
//        inputScanner.close();
//        return houses;
//    }
//
//        File inputFile = getInputFile(); // File is returned to inputFile
//        TwoDPoint[] myHouses = readFile(inputFile);
//        for (TwoDPoint h:myHouses)
//        {
//            System.out.println(h);
//        }
//}
    }
}

