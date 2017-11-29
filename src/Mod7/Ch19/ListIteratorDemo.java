  import java.util.*;
  
  /**
      This program demonstrates the list iterator.
  */
  
  public class ListIteratorDemo
  {
      public static void main(String [] args)
     {
         // Create an array list to hold strings.
         String []names = {"Chris", "David", "Katherine", "Kenny"};
         List<String> nameList = new ArrayList<>(Arrays.asList(names));
         
         // Display the names in the list.
         System.out.println("Here are the original names.");
         System.out.println(nameList);
         
         // Get a list iterator.
         ListIterator<String> it = nameList.listIterator();
         
         // Add "Darlene" to the list right after "Chris".
         while (it.hasNext())
         {
             String str = it.next();            
             // If the last name retrieved was "Chris"
             // then insert "Darlene".
             if (str.equalsIgnoreCase("Chris"))
             {
                 it.add("Darlene");
                 // We are done
                 break;
            }            
         }
         //Display the names in the list again.
         System.out.println("\nHere are the new names now.");
         System.out.println(nameList);
     }
 }