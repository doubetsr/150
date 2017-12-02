/*
 * CSIS 150 
 * 
 * Starting of Checkers Game
 * Cate Anderson
 * Created: 3-13-14
 * 
 * Game file, controls the logic behind the game
 * 
 */
package Mod6.Drawing.checkerGame;

/**
 * This is where the checkers logic would go.
 * It keeps track of the array of checkers
 * as well as the selected checker token
 * but the logic for the game needs to be added.
 * @author harmssk
 *
 */
public class CheckerGame {
     
    private int dimensions;
    private CheckerToken [][] gameArray;
    private CheckerToken selectedToken;
    private int[] lastPosition;
    
    /** 
     * The user can set the dimensions (number of rows and cols) in the checkersWindow
     * The default is 8.
     * @param d
     */
    public CheckerGame(int d)
    {
        dimensions = d;
        initGame();
    }
    
    /**
     *  Initiates the games board for a new game
     *  Demonstrates one king for the black player
     */
    public void initGame()
    {
        lastPosition = new int[2];
        gameArray = new CheckerToken[dimensions][dimensions];
        for(int col = 0; col < dimensions; col+=2 )
        {   gameArray[0][col] = new CheckerToken("0-"+col, 0); 
        }   
        for(int col = 1; col < dimensions; col+=2 )
        {   gameArray[1][col] = new CheckerToken("1-"+col, 0);
            if( col == 5)
                gameArray[1][col].setStatus('K');
        }         
        for(int col = 0; col < dimensions; col+=2 )
        {   gameArray[2][col] = new CheckerToken("2-"+col, 0);
        }
        for(int col = 0; col < dimensions; col+=2 )
        {   gameArray[dimensions-3][col] = new CheckerToken("0-"+col, 1);
        }   
        for(int col = 1; col < dimensions; col+=2 )
        {   gameArray[dimensions-2][col] = new CheckerToken("1-"+col, 1);
        }         
        for(int col = 0; col < dimensions; col+=2 )
        {   gameArray[dimensions-1][col] = new CheckerToken("2-"+col, 1);
        }
    }
    
    /**
     * Takes coordinates sent from board. if cell is empty, nothing happens.
     * If cell contains a token.  The token becomes "selected token" and it is 
     * from the game array.
     * @param r
     * @param c 
     */
    public void markSelectedToken(int r, int c)
    {   
        selectedToken = gameArray[r][c];
        if(selectedToken != null)
        {   lastPosition[0] = r;
            lastPosition[1] = c;
            gameArray[r][c] = null;
        }
    }
    
    /**
     * If cell coordinates contain a cell, nothing happens and selected cell is
     * returned to it's last position. If coordinates do not contain a cell, selected cell is
     * added to the gameArray at the coordinates passed to the method.
     * @param r
     * @param c 
     */
    public void setSelectedToken(int r, int c)
    {   
        if(gameArray[r][c] == null)
        {
            gameArray[r][c] = selectedToken;
            selectedToken = null;
        }
        else
        {
            gameArray[lastPosition[0]][lastPosition[1]] = selectedToken;
            selectedToken = null;
        }
        
    }
   
    
    /** 
     * returns token from cell passed to method. 
     * @param r
     * @param c
     * @return 
     */
    public CheckerToken getToken(int r, int c)
    {  // System.err.print("\n "+r+"  "+c+"\n");
        return gameArray[r][c];
    }
    
   
    
}
