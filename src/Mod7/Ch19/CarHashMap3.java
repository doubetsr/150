import java.util.*;

/** 
   This program retrieves the mappings from a HashMap
   as a Set of Map.Entry objects.
*/

public class CarHashMap3
{
   public static void main(String[] args)
   {
      // Create a HashMap to store Car objects.
      Map<String, Car> carMap = new HashMap<>();
      
      // Create some Car objects.
      Car vw = new Car("227H54", "1997 Volkswagen");
      Car mustang = new Car("448A69", "1965 Mustang");
      Car porsche = new Car("453B55", "2007 Porsche");
      Car bmw = new Car("177R60", "1980 BMW");
      
      // Put some mappings into the HashMap. In each
      // mapping, the car's VIN is the key and the
      // Car object containing that VIN is the value.
      carMap.put(vw.getVin(), vw);
      carMap.put(mustang.getVin(), mustang);
      carMap.put(porsche.getVin(), porsche);
      carMap.put(bmw.getVin(), bmw);
      
      // Get a set containing the mappings in this map.
      Set<Map.Entry<String, Car>> cars = carMap.entrySet();
      
      // Iterate through the mappings, printing each one.
      System.out.println("Here are the mappings:");
      for (Map.Entry<String, Car> entry : cars)
      {
         System.out.println("Key = " + entry.getKey());
         System.out.println("Value = " + entry.getValue());
         System.out.println();
      }
   }
}