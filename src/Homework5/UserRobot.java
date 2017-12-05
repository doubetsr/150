package Homework5;

public class UserRobot extends FacingRobot {

    private int setMove;

    public UserRobot (Maze maze){
        super(maze);
    }

    public int getSetMove() {
        return setMove;
    }

    public void setSetMove(int setMove) {
        this.setMove = setMove;
    }

    public int chooseMoveDirection()
    {
        int move = setMove;
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

