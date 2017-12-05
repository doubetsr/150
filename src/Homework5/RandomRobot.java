package Homework5;

/**
 * A RandomRobot determines which of the four directions it can legally move in, and then chooses one of them at random.
 * Note that a RandomRobot may move back to where it came from.
 */

public class RandomRobot extends Robot {

    /**
     * Introduce the robot to the maze.
     * @param maze
     */
    public RandomRobot (Maze maze){
    super(maze);
    }

    /**
     * Give the robot a way to choose a direction.
     * In this case, it will be random.
     * @return
     */
    public int chooseMoveDirection()
    {
            int move = (int) (Math.random() * 4) + 1;
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
                check = true;
                }
            }

            else if (direction == 2) {
                if (lost.openCell(rowLocation,colLocation +1)){
                    lost.setCell(rowLocation, colLocation,' ');
                    colLocation = colLocation + 1;
                    lost.setCell(rowLocation, colLocation,name);
                    check = true;
                }
            }

            else if (direction == 3) {
                if (lost.openCell(rowLocation + 1,colLocation)){
                    lost.setCell(rowLocation, colLocation,' ');
                    rowLocation = rowLocation + 1;
                    lost.setCell(rowLocation, colLocation,name);
                    check = true;
                }
            }
            else if (direction == 4){
                if (lost.openCell(rowLocation,colLocation - 1)){
                    lost.setCell(rowLocation, colLocation,' ');
                    colLocation = colLocation - 1;
                    lost.setCell(rowLocation, colLocation,name);
                    check = true;
                }
            }

            return check;}
        }
    }


