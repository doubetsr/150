package Homework3;

public abstract class FacingRobot extends Robot {
    private int facing;

    public FacingRobot (Maze maze){
        super(maze);
        facing = 3;
    }

    public abstract int chooseMoveDirection();

    public abstract boolean move(int direction);

    public int getFacing() {
        return facing;
    }

    public void setFacing(int facing) {
        this.facing = facing;
    }
}