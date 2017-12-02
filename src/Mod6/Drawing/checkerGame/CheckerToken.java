/*
 * CSIS 150 
 * 
 * Starting of Checkers Game
 * Cate Anderson
 * Created: 3-13-14
 * 
 * Game token
 * 
 */
package Mod6.Drawing.checkerGame;
import java.awt.*;
/**
 * This is the class for one checker
 * Note, this should be modified to 
 * allow the player to be either r or b
 * instead of just p
 * @author canderson
 */
public class CheckerToken {
    
    private int player;
    private String name;
    private char status;  //p for player, k for king, d for double king
    
    public CheckerToken(String n, int p)
    {
        player =  p;
        name = n;
        if (player == 0)
        	status = 'b';
        else 
        	status = 'r';
    }

    /**
     * @return the status
     */
    public char getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.status = status;
    }

    /**
     * @return the player
     */
    public int getPlayer() {
        return player;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
   
}
