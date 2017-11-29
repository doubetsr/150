
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
   This program demonstrates the rangeClosed and map, and mapToInt
   operations on a stream.
   It is not listed in the book.
 */

public class MapDemo
{
    public static void main(String []args)
    {
        // Read an integer n and create a stream of 1..n
        // and then map each integer x to the xth odd number 2*x-1.
        System.out.print("Enter a positive integer: ");
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        IntStream odds = IntStream.rangeClosed(1, n).map(x -> 2*x -1);
        System.out.println("The first " + n + " odd integers:");
        System.out.println(Arrays.toString(odds.toArray()));
        
        // Create a stream of strings.
        Stream<String> names = Stream.of("Abby", "Bob", "Christopher",
                    "David", "Elizabeth");
        System.out.println("Here is a stream of strings: ");
        System.out.println(Arrays.toString(names.toArray()));
        
        // Map a stream of strings to a stream of their lengths.
         names = Stream.of("Abby", "Bob", "Christopher",
                    "David", "Elizabeth");
        IntStream lengths = names.mapToInt(x -> x.length());
        System.out.println("The stream of lengths of the strings is:");
        System.out.println(Arrays.toString(lengths.toArray()));        
    }
    
}
