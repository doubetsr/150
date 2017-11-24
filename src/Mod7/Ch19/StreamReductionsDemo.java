import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;
/**
   This program illustrates the use of a 
   number of stream reduction operators.
 */

public class StreamReductionsDemo
{
    public static void main(String[] args)
    {
        // Create the source.
        String[] stoogesArray0 =
        {
            "Larry", "Curly", "Moe"
        };
        System.out.printf("The Stream source is the array: %s \n",
                Arrays.toString(stoogesArray0));
        // Variable for the stream.
        Stream<String> stooges;

        // Get a stream and reduce with count.
        stooges = Stream.of(stoogesArray0);
        System.out.printf("The count is %d\n", stooges.count());

        // Get a stream and reduce with forEach.
        stooges = Stream.of(stoogesArray0);
        stooges.forEach(x ->
        {
            System.out.printf("%s has length %d\n", x, x.length());
        });

        System.out.println("The stream reduced to an array (2 ways):");

        // Get a stream and reduce with toArray().
        stooges = Stream.of(stoogesArray0);
        String[] stoogesArray1 = stooges.toArray(x -> new String[x]);
        System.out.println(Arrays.toString(stoogesArray1));

        // Get a stream and reduce with toArray().
        stooges = Stream.of(stoogesArray0);
        String[] stoogesArray2 = stooges.toArray(String[]::new);
        System.out.println(Arrays.toString(stoogesArray2));

        // Get a stream and reduce with min.
        stooges = Stream.of(stoogesArray0);
        Optional<String> min = stooges.min((x, y) -> x.compareTo(y));
        System.out.printf("First stooge by alphabetic order: %s\n",
                                                          min.get());
        // Get a stream and reduce with min.
        stooges = Stream.of(stoogesArray0);
        Optional<String> min1 = stooges.min(String::compareTo);
        System.out.printf("First stooge by alphabetic order: %s\n", 
                                                          min1.get());
        // Get a stream and reduce with max.
        stooges = Stream.of(stoogesArray0);
        Optional<String> max = stooges.max(String::compareTo);
        System.out.printf("Last stooge by alphabetic order: %s\n", 
                                                          max.get());
    }
}