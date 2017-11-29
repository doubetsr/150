import java.util.*;

/**
   This program retrieves the mappings from a TreeMap
   using forEach.
*/

public class CarHashMap4a
{
   public static void main(String[] args)
   {
      // Create a HashMap to store Car objects.
      SortedMap<String, Car> carMap = new TreeMap<>();
      
      // Create some Car objects.
      Car vw = new Car("227H54", "1997 Volkswagen");
      Car mustang = new Car("448A69", "1965 Mustang");
      Car porsche = new Car("453B55", "2007 Porsche");
      Car bmw = new Car("177R60", "1980 BMW");
      
      // Put some mappings into the TreeMap. In each
      // mapping, the car's VIN is the key and the
      // Car object containing that VIN is the value.
      carMap.put(vw.getVin(), vw);
      carMap.put(mustang.getVin(), mustang);
      carMap.put(porsche.getVin(), porsche);
      carMap.put(bmw.getVin(), bmw);     
      
      // Iterate through the mappings, printing each one.
      System.out.println("Here are the mappings:");
      carMap.forEach( (key, value) ->
                          {
                             System.out.println("Key = " + key);
                             System.out.println("Value = " + value);
                             System.out.println();
                          });
   }
}