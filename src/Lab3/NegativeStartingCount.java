package Lab3;

/**
 * NegativeStartingCount exceptions are thrown by the
 * Race class when a negative starting count of cars is
 * passed to the constructor.
 */
public class NegativeStartingCount extends Exception {
    /**
     * This constructor uses a generic
     * error message.
     */
    public NegativeStartingCount() {
        super("Error: Negative starting count of cars");
    }

    /**
     * This constructor specifies the bad starting
     * balance in the error message.
     *
     * @param The bad starting count of cars.
     */
    public NegativeStartingCount(int carCount) {
        super("Error: Negative starting count of cars: " + carCount);
    }
}
