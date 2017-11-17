package Lab4;

/**
 *  Create a class named Employee.
 *  It implements the interface of Rules.
 *  It has two data members: name and salary.
 *  It has a constructor that accepts data and initializes the name and salary.
 *  It has a default constructor.
 *  It has a getName() method that outputs the name of the Employee.
 *  It has a getSalary() method that outputs the salary of the Employee.
 *  It has a toString() method to output the Employee information.
 */

//  Create a class named Employee.
public class Employee implements Rules {

    private String name;
    private double salary;

    //Create a class named Employee
    public Employee ()
    {
        name = "New Employee";
        salary = 0;
    }

    /**
     * Create a Constructor that accepts accepts the name and salary.
     * @param inName
     * @param inSalary
     */
    public Employee(String inName, double inSalary){
        setName(inName);
        setSalary(inSalary);
    }

    /**
     * Mutator to set the name.
     * @param inName
     */
    public void setName(String inName){
        name = inName;
    }

    /**
     * Mutator to set the salary.
     * @param inSalary
     */
    public void setSalary (double inSalary){
        salary = inSalary;
    }

    /**
     * Accessor to return the name.
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Accessor to return the Salary.
     * @return
     */
    public double getSalary(){
        return salary;
    }

    /**
     * toString to set the output of the object information.
     * @return
     */
    public String toString(){
        return "Employees:  " + name + "earns" + salary;
    }
}
