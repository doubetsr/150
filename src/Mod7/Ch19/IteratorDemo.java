import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
   This program demonstrates Iterators.
*/

public class IteratorDemo
{
    public static void main(String [] args)
    {
        // Array of names.
        String [] names = {"Anna", "Bob", "Carlos", "Debby"};
        
        // Create list and add names.
        ArrayList<String> nameList = new ArrayList<>();
        for (String name : names)
        {
            nameList.add(name);
        }
        
        // Define an action for the "remaining" elements.      
        Consumer<String> action = x -> 
                 {
                     System.out.printf("%s\n", x);
                 };  
        
        // Get the iterator to the list.
        Iterator<String> iter = nameList.iterator();
        
        // Process list elements with the iterator.
        while (iter.hasNext())
        {
            String name = iter.next();
            System.out.printf("%s %d\n", name, name.length());
            if (name.equals("Bob"))
            {
                // Act differently for names after "Bob".
                iter.forEachRemaining(action);
            }               
        }
    }    
}