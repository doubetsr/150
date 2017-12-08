package Homework5.Homework5;

public class UserRobot extends FacingRobot {

    private char holdChar = ' ';

    public void setHoldChar(){
        if (lost.getCell(rowLocation, colLocation) == 'e'){
            holdChar = 'f';
        }
        else if (
                lost.getCell(rowLocation,colLocation) == ' '){
            holdChar = 'e';
        }

        else if (lost.getCell(rowLocation,colLocation) == 'f'){
            holdChar = 'g';
        }
        else if (lost.getCell(rowLocation,colLocation) == 'g'){
            holdChar ='h';
        }
        else if (lost.getCell(rowLocation,colLocation) == 'h'){
            holdChar = 'h';
        }
    }

    public UserRobot (Maze maze){
        super(maze);
    }


    public int chooseMoveDirection()
    {
        return 0;
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
                lost.setCell(rowLocation, colLocation,holdChar);
                rowLocation = rowLocation - 1;
                setHoldChar();
                lost.setCell(rowLocation, colLocation,name);
                check = true;
            }
        }
        else if (direction == 2) {
            if (lost.openCell(rowLocation,colLocation +1)){
                lost.setCell(rowLocation, colLocation,holdChar);
                colLocation = colLocation + 1;
                setHoldChar();
                lost.setCell(rowLocation, colLocation,name);
                check = true;
            }
        }
        else if (direction == 3) {

            //if current row +1 is open do the following
            if (lost.openCell(rowLocation + 1,colLocation)){

                //set current row to holdChar
                lost.setCell(rowLocation, colLocation,holdChar);

                //set current row to new row location
                rowLocation = rowLocation + 1;

                //set holdChar to new value.
                setHoldChar();
                lost.setCell(rowLocation, colLocation,name);
                check = true;
            }
        }
        else if (direction == 4){
            if (lost.openCell(rowLocation,colLocation - 1)){
                lost.setCell(rowLocation, colLocation,holdChar);
                colLocation = colLocation - 1;
                setHoldChar();
                lost.setCell(rowLocation, colLocation,name);
                check = true;
            }
        }
            return check;}
    }
}

