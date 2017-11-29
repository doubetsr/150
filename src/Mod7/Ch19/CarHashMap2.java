import java.util.*;

/**
   This program retrieves a set of keys and a
   collection of values from a HashMap.
*/

public class CarHashMap2
{
   public static void main(String[] args)
   {
      // Create a HashMap to store Car objects.
      Map<String, Car> carMap =  new HashMap<>();
      
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
      
      // Get a set containing the keys in this map.
      Set<String> keys = carMap.keySet();
      
      // Iterate through the keys, printing each one.
      System.out.println("Here are the keys:");
      for (String k : keys)
         System.out.println(k);
         
      // Get a collection containing the values.
      Collection<Car> values = carMap.values();
      
      // Iterate through the values, printing each one.
      System.out.println("\nHere are the values:");
      for (Car c : values)
         System.out.println(c);
   }
}