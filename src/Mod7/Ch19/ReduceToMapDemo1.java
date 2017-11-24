import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
    This program demonstrates the Collectors.toMap method.
*/

public class ReduceToMapDemo1
{
    public static void main(String [] args)
    {
        // This is the stream to reduce.
        Stream<String> names = Stream.of("Larry", "Moe", "Al");
        
        // key of a string is its length.
        Function<String, Integer> keyMapper  = x -> x.length();
        
        // The value of a string is the string itself.
        Function<String, String> valueMapper = x -> x;        
        
        // Reduce the stream to a map.
        Map<Integer, String> namesMap = 
           names.collect(Collectors.toMap(keyMapper, valueMapper));
          
        // Print the map.
        System.out.printf("The map of stooges is %s\n", namesMap);                                               
    }    
}