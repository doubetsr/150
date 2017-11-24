package Lab11;/*
Good links to understand Java 8 Streams:
    https://www.tutorialspoint.com/java8/java8_streams.htm
    http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
    https://zeroturnaround.com/rebellabs/java-8-streams-cheat-sheet/
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Josh on 3/10/2017.
 */
public class Lab11 {
    public static void main(String[] args) {

        //Create our employees list and fill it with users for streaming
        //Step 1: add an accessCode to each of these employees, after updating the Employee class.
        ArrayList<Employee> employees = new ArrayList();
        employees.add(new Employee("Tim", "Johnson", 0, 12));
        employees.add(new Employee("Joe", "Darnelle", 1,2));
        employees.add(new Employee("John", "Daniels", 2, 4));
        employees.add(new Employee("Roger", "Smith", 3,5));
        employees.add(new Employee("Richard", "Carlson", 4,2));
        employees.add(new Employee("Corey", "Lambdon", 5,3));
        employees.add(new Employee("Ian", "Bronson", 6,8));
        employees.add(new Employee("Taylor", "Johnson", 7,9));
        employees.add(new Employee("Stephanie", "Roberts", 8,7));
        employees.add(new Employee("Helen", "Williams", 9,2));

        System.out.println("Print out each employee information");
        System.out.println("Pre Java 8 way using a foreach loop");
        for(Employee e : employees) {
            System.out.println(e.toString());
        }
        System.out.println("\nJava 8 way using streams and lambdas");
        employees.stream().forEach(e -> System.out.println(e.toString()));

        //Step 2.
        System.out.println("\nLimit to 5 Employees");
        System.out.println("Pre Java 8 way using for loop");
        //add the statement here to use a for loop to output the first 5 employees
        for (int f=0; f<5; f++) {
            System.out.print("\n" + employees.get(f));
        }

        System.out.println("\n\nJava 8 way using streams and lambda\n");
        //add the statement here to use streams to output the first 5 employees
        employees.subList(0,4).forEach(e -> System.out.println(e.toString()));

        //Step 3. Uncomment this code to verify that the getAccessCode works.

        System.out.println("\nFilter Employees based on Access Code value of 2. The .collect() allows us to " +
                "collect the results of a stream back into a list using the Collectors functionality");
        System.out.println("Pre Java 8");
        List<Employee> filterEmployees = new ArrayList<>();
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getAccessCode() == 2) {
                filterEmployees.add(employees.get(i));
            }
        }
        for(int i = 0; i < filterEmployees.size(); i++) {
            System.out.println(filterEmployees.get(i).toString());
        }

        System.out.println("\nJava 8");
        List<Employee> filteredEmployees = new ArrayList<>();
        filteredEmployees = employees.stream().filter(e -> e.getAccessCode() == 2).collect(Collectors.toList());
        filteredEmployees.stream().forEach(e -> System.out.println(e.toString()));


    /*see if any employee has a employee number 1 */
        System.out.println("\nJava 8 way using .anyMatch()");
        System.out.println(employees.stream().anyMatch(e -> e.getEmployeeNumber() == 1));

        //here is the pre Java 8 way to do this:
        System.out.println("\nDo an 'any match' against a condition on our employees list");
        System.out.println("Pre Java 8");
        boolean anyMatch = false;
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getEmployeeNumber() == 1) {
                anyMatch = true;
                break;
            }
        }
        System.out.println(anyMatch);

      /*Step 4. Similar to thea anyMatch above, see if all employees have an employee number of 1.*/
        System.out.println("\nJava 8 way using .allMatch()");
        //add code here

        System.out.println(employees.stream().allMatch(e -> e.getEmployeeNumber() == 1));

        System.out.println("\nDo an 'all match' against a condition on our employees list");
        System.out.println("Pre Java 8");
        boolean allMatch = false;
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getEmployeeNumber() != 1) {
                allMatch = false;
                break;
            }
        }
        System.out.println(allMatch);

        /*Step 5. Similar to thea allMatch above, use .noneMatch.*/
        System.out.println("\nJava 8 way using .noneMatch()");
        //add code here
        System.out.println(employees.stream().noneMatch(e -> e.getEmployeeNumber() == 1));

        System.out.println("\nDo an 'none match' against a condition on our employees list");
        System.out.println("Pre Java 8");
        boolean noneMatch = false;
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getEmployeeNumber() == 1) {
                noneMatch = false;
                break;
            }
        }
        System.out.println(noneMatch);

        /*Step 6 Use streams to do multiple things at one time.*/
        //Uncomment the code

        System.out.println("\nFilter the employees list and save the employees whose first name contains an 'o' as a list" +
        "\nThen filter the result of the first filter whose accessCode is 2 and store this as a list" +
        "\nFinally, print out the resulting final list");
        System.out.println("Pre Java 8 method - less efficient as you have to create multiple lists and loops");
        List<Employee> filter1 = new ArrayList<>();
        List<Employee> filter2 = new ArrayList<>();
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getFirstName().contains("o")) {
                filter1.add(employees.get(i));
            }
        }
        for(int i = 0; i < filter1.size(); i++) {
            if(filter1.get(i).getAccessCode() == 2) {
                filter2.add(filter1.get(i));
            }
        }
        for(int i = 0; i < filter2.size(); i++) {
            System.out.println(filter2.get(i).toString());
        }


        System.out.println("\nJava 8 method - much more efficient and manageable");
        //Step 6. insert code here
//        System.out.println(employees.stream().filter(e -> e.getAccessCode() == 2) && );

    }


}