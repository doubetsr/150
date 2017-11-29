import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
   This program demonstrates how to use the Stream 
   reduce method.
*/

public class ReducetoSetDemo
{
    public static void main(String [] args)
    {
        Stream<String> stooges = Stream.of("Larry", "Curly", "Moe");
        
        // The accumulator for the reduction.
        BiFunction<Set<String>, String, Set<String>> accumulator = 
               (s, x) -> { s.add(x); return s;};
        
        // The combiner for the reduction
        BinaryOperator<Set<String>> combiner = 
                (s, t) -> { t.addAll(s); return t;};
        
        // Reduce the stream to a set.         
        Set<String> stoogeSet = stooges.reduce(new HashSet<String>(), 
                                               accumulator, combiner);
        // Print the set
        System.out.printf("The set of stooges is %s\n", stoogeSet);                 
    }
}