import java.util.*;

/**
   This program demonstrates how a TreeSet sorts 
   its elements in ascending order.
 */
public class TreeSetDemo1
{
    public static void main(String[] args)
    {
        // Create a TreeSet and store some values in it.
        SortedSet<String> mySet = new TreeSet<>();
        mySet.add("Pear");
        mySet.add("Apple");
        mySet.add("Strawberry");
        mySet.add("Banana");

        // Display the elements in the TreeSet.
        System.out.println("Here are the TreeSet elements "
                + "in ascending order:");        
        System.out.println(mySet);        

        // Add a new element to the TreeSet.
        System.out.println("\nAdding Blueberry to the set.");
        mySet.add("Blueberry");

        // Display the elements again.
        System.out.println("\nHere are the TreeSet elements "
                + "again:");
        System.out.println(mySet);       
    }
}