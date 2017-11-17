package Lab2;//package Lab2Start;
/********************************************************************
 Car.java
 Author: Sam Doubet

 Represents a car that can accelerate, brake, and move
 Used in the race program
 ********************************************************************/

public class Car {
    //declare private member variables here
    private String owner;
    private int currentSpeed;  //in terms of mph
    private double distanceTraveled;  // in terms of miles
    private int maxSpeed; //in terms of mph
    private static final int DEFAULTMAXSPEED = 100;

    /**
     * Constructor initializes a car
     * @param newOwner - owner of the car
     * @param newMaxSpeed - max speed of the car
     */
    public Car(String newOwner, int newMaxSpeed)
    {
        owner = newOwner;
        currentSpeed = 0;
        maxSpeed = newMaxSpeed;
        distanceTraveled = 0;
    }

    /**
     * Default constructor
     */
    public Car() { this("no owner",DEFAULTMAXSPEED); }

    //public Car() { this.owner = otherowner, this.getMaxSpeed() = othermaxspeed}

    /**
     * Move the car the distance it can travel at its current speed for 1 minute
     * (update the distance traveled variable)
     */
    public void move()
    {
        this.distanceTraveled += (double) this.currentSpeed / 60;
    }


    /**
     * Add 5 miles per hour to current speed
     * Remember: The most the current speed can be is the maxSpeed of the car
     */
    public void accelerate(){
        if (this.currentSpeed <= (this.maxSpeed - 5)) {
            this.currentSpeed += 5;}

        else this.currentSpeed = this.maxSpeed;

    }

    /**
     * Subtracts 5 miles per hour from current speed
     * Remember: The minimum speed for the current speed is 0
     */
    public void brake() {
        if (this.currentSpeed >= 5) {
            this.currentSpeed -= 5;
        }

        else this.currentSpeed = 0;
    }

    /**
     * @return the current speed of the car
     */
    public int getCurrentSpeed()
    {
        return currentSpeed;
    }

    /**
     * @return the max speed of the car
     */
    public int getMaxSpeed()
    {
        return maxSpeed;
    }

    /**
     * @return the distance traveled for the car
     */
    public double getdistanceTraveled()
    {
        return distanceTraveled;
    }

    /**
     * Create a get method for accessing the owner.
     * @return
     */
    public String getOwner()
    {
        return owner;
    }

    /**
     *  Create a set method to edit the maxSpeed.  Note:  this is
     *  would normally set the maxSpeed to a value equal to
     *  the user input.  Since i didn't create the dialog for the
     *  user as it was not required this method will simply return
     *  the maxSpeed.
     * @return
     */
    public int setmaxSpeed() {return maxSpeed; }

    /**
     * Create a method to set the distanceTraveled back to 0.
     * @return
     */
    public double setdistanceTraveled() {return distanceTraveled = 0;}

    /**
     * Create a method to set the currentSpeed to user dialog.
     * Again, incomplete as the user dialog wasn't necissary for this assignment.
     * @return
     */
    public double currentSpeed(){return currentSpeed = 0;}


    /**
     * @return the car values as a String
     */
    public String toString()
    {
        String carValue = owner+"'s car current speed: "+currentSpeed +
                " MPH, distance traveled: "+distanceTraveled+ " miles.";
        return carValue;
    }

    /**
     * reset the distance traveled, to start a new race.
     */
    public void resetDistance()
    {
        distanceTraveled = 0;
    }

    /**
     * reset the speed, to start a new race.
     */
    public void resetCurrentSpeed()
    {
        currentSpeed = 0;
    }
}