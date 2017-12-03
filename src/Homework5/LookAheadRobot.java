package Homework5;

/**
 *NEW HW3 REQUIIREMENT: The LookAheadRobot Class
 * A LookAheadRobot has both a location and a direction which it is facing. A LookAheadRobot’s goal is to
 * search for the exit while always trying to recursively move as far as it can in one direction. On a move, it goes in
 * the same direction until it cannot go any further. When planning its move direction, it will try to choose to go
 * straight. If it cannot go straight, it will try to turn right. If it cannot turn right, it will try to turn left. As a last resort,
 * it will turn around. Once the robot moves as far as it can in certain direction, its move is finished, and it stays facing
 * in that direction. This kind of robot always needs to know the direction it is currently facing before it can decide
 * which move to try first. It also inherits from the FacingRobot.
 *
 * NOTE:  To "move as far as it can in one direction" as requested won't work in the bigger maze.
 * This is because the bot needs to know when it crosses a path that it should consider a different move.
 * Currently, if the robot hits a pocket dead end and the result of moving the opposite direction
 * ends in a pocket dead end the robot is stuck in.  I altered the code to read
 * or listen for a location based upon the bots current location.  Assume we have a left, right, and straight
 * direction.  If 2 or more of them are open, the bot should stop it's move and chooseMoveDirection again.
 */
public class LookAheadRobot extends FacingRobot {

    private int location;

    /**
     * Introduce the robot to the maze.
     * @param maze
     */
    public LookAheadRobot (Maze maze){
        super(maze);
    }

    /**
     * Give the robot a way to choose a direction.
     * In this case, it will be random.
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
                if (lost.openCell(rowLocation -1, colLocation -1) == true
                        || lost.openCell(rowLocation -1, colLocation +1)){
                super.setFacing(1);
                check = true;
                }
                else
                move(direction);
                super.setFacing(1);
                check = true;

            }
        }

        else if (direction == 2) {
            if (lost.openCell(rowLocation,colLocation +1)){
                lost.setCell(rowLocation, colLocation,' ');
                colLocation = colLocation + 1;
                lost.setCell(rowLocation, colLocation,name);
                if (lost.openCell(rowLocation -1, colLocation +1) == true
                        || lost.openCell(rowLocation +1, colLocation +1)){
                    super.setFacing(2);
                    check = true;
                }
                else
                    move(direction);
                super.setFacing(2);
                check = true;

            }
        }

        else if (direction == 3) {
            if (lost.openCell(rowLocation + 1,colLocation)){
                lost.setCell(rowLocation, colLocation,' ');
                rowLocation = rowLocation + 1;
                lost.setCell(rowLocation, colLocation,name);
                if (lost.openCell(rowLocation +1, colLocation -1) == true
                        || lost.openCell(rowLocation +1, colLocation +1)){
                    super.setFacing(3);
                    check = true;
                }
                else
                    move(direction);
                super.setFacing(3);
                check = true;

            }
        }
        else if (direction == 4){
            if (lost.openCell(rowLocation,colLocation - 1)){
                lost.setCell(rowLocation, colLocation,' ');
                colLocation = colLocation - 1;
                lost.setCell(rowLocation, colLocation,name);
                if (lost.openCell(rowLocation -1, colLocation -1) == true
                        || lost.openCell(rowLocation +1, colLocation -1)){
                    super.setFacing(4);
                    check = true;
                }
                else
                    move(direction);
                super.setFacing(4);
                check = true;

            }
        }

            return check;}
    }
}


