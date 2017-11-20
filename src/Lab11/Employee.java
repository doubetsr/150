package Lab11;

import java.time.LocalDate;

/**
 * Created by Josh on 3/10/2017.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private int employeeNumber;
    private int accessCode;

   public Employee(String firstName, String lastName, int employeeNumber, int accessCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.accessCode = accessCode;
     }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(int accessCode){ this.accessCode = accessCode;}

    @Override
    public String toString() {
        return "Employee{" +
                "First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Employee Number=" + employeeNumber +
                ", Access Code=" + accessCode +
                  '}';
    }
}
