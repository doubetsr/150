import java.util.*;

/**
   This program demonstrates how a LinkedHashSet 
   preserves the order in which elements are added.
 */
public class LinkedHashSetDemo
{
    public static void main(String[] args)
    {
        // List of fruits to put in hash sets.
        List<String> fruitList = 
              Arrays.asList("Apple", "Strawberry", "Pear", "Banana");
        
        // Create the HashSet.        
        Set<String> set1 = new HashSet<>(fruitList);
      
        // Now create the LinkedHashSet.
        Set<String> set2 = new LinkedHashSet<>(fruitList);        

        // Display the elements in the HashSet.
        System.out.println("Here are the elements in "
                + "the HashSet:");
        System.out.println(set1);

        // Now display the elements in the LinkedHashSet.
        System.out.println("\nAnd here are the elements "
                + "in the LinkedHashSet:");
         System.out.println(set2);
    }
}