import java.util.ArrayList;
import java.util.function.Predicate;

/**
   This program demonstrates the Collection removeIf.
*/

public class FilterDemo
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
        // Use forEach with lambda expression to print.
        Predicate<String> filter = x -> x.length() <= 4;
        
        // Remove strings with length at most 4 from nameList
        nameList.removeIf(filter);
        
        // Print the array list to show remaining strings.
        System.out.println(nameList);                
    }    
}