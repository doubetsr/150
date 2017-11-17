package Lab9;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * CSIT 150 fall 2017
 * Special thanks to Andrew for the help.
 * @author canderson
 * @author Sam Doubet
 */

/**
 * Main class to define the variables and hold the methods.
 */
public class FormCircleArray {

    int[][] circs;
    int startX;
    int startY;
    int width;
    int height;

    /**
     * Constructor to create the circle.
     * @param rSeed
     * @param tall
     * @param wide
     * @param startsX
     * @param startsY
     */
    public FormCircleArray(int rSeed, int tall, int wide, int startsX, int startsY)
    {
        generateCircArray(rSeed, tall, wide, startsX, startsY);
        startX = startsX;
        startY = startsY;
        width = wide;
        height = tall;


    }

    /**
     * method to create a new array
     * @param rs
     * @param nexX
     * @param newY
     * @return
     */
    public int[][] genNewArray(int rs, int nexX, int newY)
    {
        generateCircArray( rs, height, width, startX, startY);
        return circs;
    }

    /**
     * method to fill the new array.
     * @param rs
     * @param tall
     * @param wide
     * @param startsX
     * @param startsY
     */
    private void generateCircArray(int rs, int tall, int wide, int startsX, int startsY)
    {
        circs = new int[rs][7];
        startX = startsX;
        startY = startsY;
        width = wide;
        height = tall;
        int colorNum1 = 10; //Red
        int colorNum2 = 50; //Green
        int colorNum3 = 150; //Blue

        for(int dex = 0; dex < circs.length; dex++)
        {
            circs[dex][0] = startX;
            circs[dex][1] = startY;
            circs[dex][2] = width;
            circs[dex][3] = height;
            circs[dex][4] = colorNum1;
            circs[dex][5] = colorNum2;
            circs[dex][6] = colorNum3;

            startX = startX + 10;
            startY += 10;
            width += 10;
            height += 5;
            colorNum1+= 10;
            if(colorNum1 >254)
                 colorNum1 = 10;
            colorNum2+= 10;
            if(colorNum2 >254)
                 colorNum2 = 10;
            colorNum3+= 10;
            if(colorNum3 >254)
                 colorNum3 = 10;
        }
    }

    /**
     * An accessor to access the array.
     * @return
     */
    public int[][] getCircs()
    {
        return circs;
    }

}
