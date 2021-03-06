package Homework2;

public abstract class Robot {

    Maze lost;
    char name = 'r';
    int rowLocation;
    int colLocation;

    public Robot (Maze maze){ lost = maze;

    rowLocation = lost.getStartRow();
    colLocation = lost.getStartCol();
    lost.setCell(rowLocation, colLocation,name);
    }

    public char getName (){ return name; }

    public int getRowLocation () { return rowLocation; }

    public int getColLocation () { return colLocation; }

    public void setName (char inName){ name = inName; }

    public void setRowLocation (int rowLoc) { rowLocation = rowLoc; }

    public void setColLocation (int colLoc) { colLocation = colLoc; }



    public abstract int chooseMoveDirection();


    public abstract boolean move(int direction);

    public boolean solved(){
        if (rowLocation == lost.getExitRow() && colLocation == lost.getExitCol()){
            return true;
        }

        else
            return false;

    }

}
