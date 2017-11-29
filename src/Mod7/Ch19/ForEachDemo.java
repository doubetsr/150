import java.util.ArrayList;

/**
   This program demonstrates Iterable forEach().
*/

public class ForEachDemo
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
        nameList.forEach(
                x -> 
                 {
                     System.out.printf("%s %d\n", x, x.length());
                 });
    }    
}