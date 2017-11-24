import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
   This program illustrates the working of the 
   peek intermediate operation.
*/

public class PeekOpDemo
{
    public static void main(String [] args)
    {
        // Random number generator.
        Random randy = new Random();      
        
        // Potentially infinite stream of random 
        // numbers all of which are less than 10.
        IntStream infRandom = randy.ints(0, 10);        
        
        int [] evenRandomArr = 
                randy.ints(0, 10)
                     .peek(x -> {System.out.printf("ints: %d\n", x);})                
                     .filter(x -> x% 2 == 0)
                     .peek(x-> {System.out.printf("filter: %d\n", x);})
                     .limit(5)
                     .toArray();
        System.out.println("The result of stream operations is: ");
        System.out.println(Arrays.toString(evenRandomArr));
    }
}
