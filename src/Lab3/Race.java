package Lab3;

/**
 *
 */

import java.text.NumberFormat;

/**
 * Race class used to simulate a race of cars
 * the cars are stored in an array
 * Uses a dice to decide which car and what action to take as the race progresses
 *
 * CSIT 150 lab 3
 *
 * @author Harms
 */

public class Race {
    private static final double DEFAULTRACEDISTANCE = 500;
    private Car[] raceCars;
    private double distance;
    private String raceType;
    private Car winner;
    private int carCount;

    /**
     * Make a default array of cars
     * Be careful - each car is NULL at this point.
     */
    public Race() {
        raceCars = null;
        distance = 0.0;
        raceType = "unknown";
        winner = null;
        carCount = 0;
    }

    /**
     * creates the race that can handle inCarCount number of cars
     *
     * @param inCarCount
     */
    public Race(int inCarCount) {
        raceCars = new Car[inCarCount];
        distance = 0.0;
        raceType = "unknown";
        winner = null;
        carCount = 0;
    }

    /**
     * Mutator method to set the distance.
     * @param inDistance
     */
    public void setDistance(double inDistance) { distance = inDistance; }

    /**
     * Mutator method to set the RaceType.
     * @param inType
     */
    public void setRaceType(String inType) { raceType = inType; }


    /**
     * Returns winning Car.
     * @return
     */
    public String getWinner() {
        String x;
        if (winner != null)
            x = winner.toString();
        else {
            x = "Race winner is unknown at this time";
        }
        return x;
    }


    /**
     * Accessor to access the total amount of cars.
     * @return
     */
    public int getCarCount() { return carCount; }

    /**
     * Method that creates a copy of the input car parameter in the raceCar array
     * and adds it into the next open slot.
     * @param car
     */
    public void addCar(Car car) {
        if (raceCars == null || carCount == raceCars.length)
            increaseSize();

        //put the new car in the next open spot
        raceCars[carCount] = new Car(car);

        carCount++;
    }

    /**
     * Accessor method to obtain the array of cars.
     * @return
     */
    public Car[] getRaceCars(){
        Car[] temp = new Car[raceCars.length];
        for (int i=0; i < raceCars.length; i++)
            temp[i] = new Car (raceCars[i]);
        return temp;
    }

    /**
     * Accessor to obtain the distance.
     * @return
     */
    public double getDistance() { return distance; }

    /**
     * Accessor to obtain the raceType.
     * @return
     */
    public String getRaceType(){ return raceType; }

    /**
     * DEEP copy of Cars
     */
    public Car[] getCars() {

            Car[] pinkSlip = new Car[carCount];
            for (int i=0;i<carCount;i++)
                pinkSlip[i] = new Car(raceCars[i]);
            return pinkSlip;
 }

    public String toString(){
        return "Race Winner is:  " + winner;
    }

    public void runRace() {

        Dice raceDice = new Dice(carCount*3);
        boolean running = true;
        while (running == true) {
            int diceRoll = raceDice.roll();
            int carToMove = (diceRoll - 1) / 3;
            int action = (diceRoll - 1) % 3;

            if (action == 0) {
                raceCars[carToMove].move();
                if (raceCars[carToMove].getdistanceTraveled() > distance){
                    winner = raceCars[carToMove];
                    running = false;
                }
            } else if (action == 1) {
                raceCars[carToMove].brake();
            } else if (action == 2) {
                raceCars[carToMove].accelerate();
            }
        }
    }

    //-----------------------------------------------------------------
    //  Doubles the size of the race cars by creating a larger array
    //  and copying the existing cars into it.
    //-----------------------------------------------------------------
    private void increaseSize ()
    {
        if (raceCars == null)
        {
            raceCars = new Car[2];
            for (int i = 0; i<2; i++)
                raceCars[i] = new Car();
        }
        else
        {
            Car[] temp = new Car[raceCars.length * 2];

            for (int crew = 0; crew < raceCars.length; crew++)
                temp[crew] = raceCars[crew];

            raceCars = temp;
        }
    }
}
