package Lab9;

public class ExerciseGame {

    //create a form circle array object.
    private FormCircleArray fca;

    /**
     * construct the circle ARRAY.
     * @param x
     * @param y
     * @param wid
     * @param hei
     */
    public ExerciseGame(int x, int y, int wid, int hei)
    {
        fca = new FormCircleArray((int) (Math.random()*5), x, y, wid, hei);
    }

    /**
     * Process the move.
     * @param x
     * @param y
     * @return
     */
    public int[][] processMove(int x, int y)
    {
       fca.genNewArray((int) (Math.random()*5),x,y);
       return fca.getCircs();
    }
}
