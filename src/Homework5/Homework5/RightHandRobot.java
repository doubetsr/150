package Homework5.Homework5;

/**
 * Note that all robots have a current location.
 * A RightHandRobot has both a location and
 * a direction which it is facing. When initially constructed,
 * we will assume the robot is facing South (
 * because we will specify that all Start locations
 * are in row 0 of the maze). After that, its direction is
 * determined by its previous move. A RightHandRobot’s goal
 * is to search for the exit while always trying to move right,
 * if possible. If it cannot move right, it will try to move
 * straight ahead. If it cannot move straight, it will try
 * to move left. As a last resort, it will back up.
 *
 * Representing the direction the robot is facing
 * Obviously, you will need some sort of data representation
 * for the direction the robot is facing. There are many ways
 * to do this, but one simple method would be to use a character
 * for ‘N’, ‘S’, ‘W’, and ‘E’
 *
 * For example, a RightHandRobot that is facing south, will first
 * try to move west. If it cannot move west, it will then try to
 * move south (straight). If it cannot move straight, it will try
 * to move left (east). If it cannot move east, it will
 * then go back north. Once the robot moves a certain direction,
 * it then is facing in that direction. So – this kind of robot
 * always needs to know the direction it is currently facing before
 * it can decide which move to try first.
 *
 * *************************************************************************
 * NEW HW3 REQUIIREMENT The RightHandRobot Class inherits from FacingRobot
 The move and chooseMoveDirection methods are defined here, but the methods and variables used to keep track of
 the direction the robot is facing are defined in and inherited from FacingRobot.
 ****************************************************************************
 * Bonus 10 points: Use an enumeration (from chapter 9) to keep track
 * of the direction the RightHandRobot robot is facing. (We will cover
 * enumerations later, but they would be useful here.)
 *
 *
 */

public class RightHandRobot  extends FacingRobot {

    /**
     * A RandomRobot determines which of the four directions it can legally move in, and then chooses one of them at random.
     * Note that a RandomRobot may move back to where it came from.
     */

    /**
     * Introduce the robot to the maze.
     */


    public RightHandRobot (Maze maze){
        super(maze);
    }

    /**
     * Give the robot a move direction based
     * on the way the robot is facing.
     * If the move isn't open rotate
     * counterclockwise(W,S,E,N) until there is an
     * open move.  The starting move will be
     * moving right from the direction facing.
     * @return
     */
    public int chooseMoveDirection()
    {
        int move = 1; //variable assigned for move direction.

        if (super.getFacing() == 1) //Facing North
        {
            if (lost.openCell(rowLocation, colLocation + 1)) {
                move = 2;  //Move East
            }
            else if (lost.openCell(rowLocation -1, colLocation)) {
                move = 1; //Move North
            }
            else if  (lost.openCell(rowLocation, colLocation -1)) {
                move = 4;  //Move West
            }
            else if  (lost.openCell(rowLocation + 1, colLocation)) {
                move = 3;  //Move South
            }
        }
        if (super.getFacing() == 2) //Facing East
        {
            if  (lost.openCell(rowLocation + 1, colLocation)) {
                move = 3; //Move South
            }
            else if (lost.openCell(rowLocation, colLocation + 1)) {
                move = 2; //Move East
            }
            else if (lost.openCell(rowLocation -1, colLocation)) {
                move = 1;  //Move North
            }
            else if  (lost.openCell(rowLocation, colLocation -1)) {
                move = 4; //Move West
            }
        }
        if (super.getFacing() == 3)  //Facing South
        {
            if  (lost.openCell(rowLocation, colLocation -1))
            {
                move = 4; //Move West
            }
            else if  (lost.openCell(rowLocation + 1, colLocation)) {
                move = 3; //Move South
            }
            else if (lost.openCell(rowLocation, colLocation + 1)) {
                move = 2; //Move East
            }
            else if (lost.openCell(rowLocation -1, colLocation)) {
                move = 1; //Move North
            }
        }
        if (super.getFacing() == 4) //Facing West
        {
            if (lost.openCell(rowLocation -1, colLocation)) {
                move = 1; //Move North
            }
            else if  (lost.openCell(rowLocation, colLocation -1)) {
                move = 4; //Move West
            }
            else if  (lost.openCell(rowLocation + 1, colLocation)) {
                move = 3; //Move South
            }
            else if (lost.openCell(rowLocation, colLocation + 1)) {
                move = 2; //Move East
            }
        }
        return move;
    }

    /**
     * Use the return value from chooseMoveDirection
     * to initiate the move in the maze.
     * Based on the move, the robot will change the
     * direction it is facing.
     * @param direction
     * @return
     */
    public boolean move(int direction){
        boolean check = false;
        { if (direction == 1) {
            if (lost.openCell(rowLocation -1,colLocation)){
                lost.setCell(rowLocation, colLocation,' ');
                rowLocation = rowLocation - 1;
                lost.setCell(rowLocation, colLocation,name);
                super.setFacing(1);
                check = true;
            }
        }
        else if (direction == 2) {
            if (lost.openCell(rowLocation,colLocation +1)){
                lost.setCell(rowLocation, colLocation,' ');
                colLocation = colLocation + 1;
                lost.setCell(rowLocation, colLocation,name);
                super.setFacing(2);
                check = true;
            }
        }
        else if (direction == 3) {
            if (lost.openCell(rowLocation + 1,colLocation)){
                lost.setCell(rowLocation, colLocation,' ');
                rowLocation = rowLocation + 1;
                lost.setCell(rowLocation, colLocation,name);
                super.setFacing(3);
                check = true;
            }
        }
        else if (direction == 4){
            if (lost.openCell(rowLocation,colLocation - 1)){
                lost.setCell(rowLocation, colLocation,' ');
                colLocation = colLocation - 1;
                lost.setCell(rowLocation, colLocation,name);
                super.setFacing(4);
                check = true;
            }
        }
            return check;}
    }
}





