import java.util.*;

/**
   This program demonstrates how a TreeSet can use 
   a Comparator to sort its elements.
 */
public class TreeSetDemo2
{
    public static void main(String[] args)
    {
        // Create a TreeSet and pass an instance of
        // CarComparator to it.
        SortedSet<Car> carSet
                = new TreeSet<>(new CarComparator());

        // Add some Car objects to the TreeSet.
        carSet.add(new Car("227H54", "1997 Volkswagen"));
        carSet.add(new Car("453B55", "2007 Porsche"));
        carSet.add(new Car("177R60", "1980 BMW"));
        carSet.add(new Car("448A69", "1965 Mustang"));

        // Display the elements in the TreeSet.
        System.out.println("Here are the cars sorted in "
                + "order of their VINs:");
        for (Car car : carSet)
        {
            System.out.println(car);
        }
    }
}
