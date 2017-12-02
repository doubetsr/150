package Mod6.Drawing.BouncingBall;


/** A Ball that bounces on the screen.
 * @author Harms
 */
public class Ball {

	private int x; // ball's current row
	private int y; // ball's current column
	private int ballWidth;
	private int maxScreenWidth;
	private int maxScreenHeight;
	private boolean goingDown;
	private boolean goingRight;

	/**
	 * Construct robot to move on a maze 
	 * @param refMaze
	 */
	public Ball(int width, int height) {
		maxScreenHeight=height;
		maxScreenWidth=width;
		x = maxScreenWidth/2;
		y = maxScreenHeight/2;
		ballWidth = 15;
		goingDown = true;
		goingRight = true;
	}

	public void move(int xIncrease, int yIncrease)
	{
		if (goingRight)
			x+=xIncrease;
		else
			x-=xIncrease;
		if(goingDown)
			y+=yIncrease;
		else
			y-=yIncrease;

		if (x>=maxScreenWidth)
			goingRight = false;
		if (x<=0)
			goingRight=true;
		if (y>= maxScreenHeight)
			goingDown = false;
		if (y<= 0)
			goingDown = true;

	}

	/**
	 * Set new row for ball
	 * @param newRow
	 */
	public void setRow(int newRow)
	{
		x = newRow;
	}

	/**
	 * set new col for ball
	 * @param newCol
	 */
	public void setCol(int newCol){
		y = newCol;
	}

	/**
	 * Get current row of ball
	 * @return current row of ball
	 */
	public int getX(){
		return x;
	}

	/**
	 * Get current col of ball
	 * @return current col of ball
	 */
	public int getY() {
		return y;
	}
	
	public int getBallWidth()
	{
		return ballWidth;
	}

}
