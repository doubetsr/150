import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
   This program illustrates intermediate Stream operations.
*/

public class StreamIntermediateOps
{
    public static void main(String [] args)
    {
        // Random number generator.
        Random randy = new Random();      
        
        // Potentially infinite stream of random 
        // numbers all of which are less than 10.
        IntStream infRandom = randy.ints(0, 10);
        
        // Filter out all the odd numbers, keep only even numbers.
        IntStream intEvenRandom = infRandom.filter( x -> x % 2 == 0);
        
        // Keep only the first 15 of the infinite 
        // stream of random even numbers.
        IntStream first15 = intEvenRandom.limit(15);
        
        // Reduce to an array and print.
        int [] evenRandomArr = first15.toArray();
        System.out.println("The result of stream operations is: ");
        System.out.println(Arrays.toString(evenRandomArr));      
    }
}