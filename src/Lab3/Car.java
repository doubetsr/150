package Lab3;

/********************************************************************
 Car.java
 Author: Your name

 Represents a car that can accelerate, brake, and move
 Used in the racetest program
 ********************************************************************/

public class Car {
    private static final int DEFAULTMAXSPEED = 100;
    //declare private member variables here
    private String owner;
    private int currentSpeed;  //in terms of mph
    private double distanceTraveled;  // in terms of miles
    private int maxSpeed; //in terms of mph

    /**
     * Constructor initializes a car
     *
     * @param newOwner    - owner of the car
     * @param newMaxSpeed - max speed of the car
     */
    public Car(String newOwner, int newMaxSpeed) {
        owner = newOwner;
        currentSpeed = 0;
        maxSpeed = newMaxSpeed;
        distanceTraveled = 0;
    }

    public Car(Car another) {
        this.setOwner(another.getOwner());
        currentSpeed = another.getCurrentSpeed();
        maxSpeed = another.getMaxSpeed();
        distanceTraveled = another.getdistanceTraveled();
    }


    /**
     * Default constructor
     */
    public Car() {
        this("no owner", DEFAULTMAXSPEED);
    }

    /**
     * Move the car the distance it can travel at its current speed for 1 minute
     * (update the distance traveled variable)
     */
    public void move() {
        distanceTraveled += currentSpeed / 60.0;
    }

    /**
     * Add 5 miles per hour to current speed
     * Remember: The most the current speed can be is the maxSpeed of the car
     */
    public void accelerate() {
        currentSpeed += 5;
        if (currentSpeed > maxSpeed)
            currentSpeed = maxSpeed;
    }

    /**
     * Subtracts 5 miles per hour from current speed
     * Remember: The minimum speed for the current speed is 0
     */
    public  void brake() {
        currentSpeed -= 5;
        if (currentSpeed < 0)
            currentSpeed = 0;
    }

    /**
     * @return the current speed of the car
     */
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @return the max speed of the car
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Defines the maxSpeed.
     * @param speed
     */
    public void setMaxSpeed(int speed) {
        maxSpeed = speed;
    }

    /**
     * @return the distance traveled for the car
     */
    public double getdistanceTraveled() {
        return distanceTraveled;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String o) {
        owner = o;
    }

    /**
     * @return the car values as a String
     */
    public String toString() {
        String carValue = owner + "'s car current speed: " + currentSpeed +
                " MPH, distance traveled: " + distanceTraveled + " miles.";
        return carValue;
    }

    /**
     * reset the distance traveled, to start a new race.
     */
    public void resetDistance() {
        distanceTraveled = 0;
    }

    /**
     * reset the speed, to start a new race.
     */
    public void resetCurrentSpeed() {
        currentSpeed = 0;
    }
}
