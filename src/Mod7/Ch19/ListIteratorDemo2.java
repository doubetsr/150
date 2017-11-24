 import java.util.*;
  
  /**
     This program demonstrates setting and removing list 
     elements with a ListIterator.
   */
  
  public class ListIteratorDemo2
  {
     public static void main(String[] args)
     {
         // Create an ArrayList to hold String objects.
         List<String> nameList = new ArrayList<>();
 
         // Add some names to the ArrayList.
         nameList.add("Chris");
         nameList.add("David");
         nameList.add("Katherine");
         nameList.add("Kenny");
 
         // Display the names in the list
         System.out.println("Here are the original names.");
         System.out.println(nameList);
         
         // Get a list iterator.
         ListIterator<String> it = nameList.listIterator();
 
         // Replace the first element with "Alfonso".
         if (it.hasNext())
         {
             // Get the first element.
             it.next();
 
             // Replace it.
             it.set("Alfonso");
         }
         // Move the iterator to the end of the list.
         while (it.hasNext())
         {
             it.next();
         }
 
         // Remove the last element that was retrieved.
         it.remove();
 
         // Display the names in the list again. The list
         // should read Alfonso, David, and Katherine.
         System.out.println("\nHere are the names now.");
        System.out.println(nameList);
     }
 }
