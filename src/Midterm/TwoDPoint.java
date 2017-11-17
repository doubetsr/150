package Midterm;

/**
 * The purpose of TwoDPoints is to store information for
 * points.  A point will have an x and y value.
 */
public class TwoDPoint {

    double x;  //store the value of x
    double y;  //store the value of y

    /**
     * Create a constructor to take in the values x and y
     * @param xValue
     * @param yValue
     */
    public TwoDPoint (double xValue,double yValue )
    {
        this.x = xValue;
        this.y = yValue;
    }

    /**
     * Create a default constructor to set the values
     * of X and Y when none are given.
     */
    public TwoDPoint (){
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Return the value of x.
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * Return the value of Y.
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * Create a method to Calculate the Area.
     * @param a
     * @param b
     * @return
     */
    public double getArea(TwoDPoint a, TwoDPoint b){
        double area;
        area = (b.getX() - a.getX()) * (b.getY() - a.getY());

        return area;
    }

    /**
     * Set the value of x
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * set the value of y
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Create a default toString to handle the
     * default values from a storage.
     * @return
     */
    public String toString() {
        String values = "The value of X is:" + x + "The value of Y is:" + y;
        return values;
    }
}
