package Lab4;

/**
 * It inherits class Employee
 * It has an extra private field named courses,
 * which is an array that holds the courses taught by this faculty member.
 * For each course, just store the course name as a String.)
 * It has a constructor that accepts three parameters: name, salary, and courses.
 * Notice that name and salary can be initialized using the constructor of the superclass.
 * Notice that the input parameter courses is plural.
 * It overrides the getName() method of Employee,
 * and precedes the name with the word “Professor”,
 * similar to the GraduateStudent getName() method demonstrated in class.
 * It has a public accessor to the field courses. Be sure to return a copy
 * It has a public mutator to the field courses. Be careful with the array size,
 * and with storing copies. See the CD Collection.
 * It has a toString() method to output the Faculty information.
 */

public class Faculty extends Employee {
    /**
     * Create an array for courses to be stored as a String
     */
        private String[] courses;

    /**
     *Class which inherits Employee and adds private field courses
     */
    public Faculty(){
            super();  //call automatically
            courses = new String[4];
        }

    /**
     * A constructor that accepts name, salary, and courses.
     * @param inName
     * @param inSalary
     * @param inCourses
     */
        public Faculty(String inName, double inSalary, String[] inCourses){
            super(); //auto
            setName(inName);
            setSalary(inSalary);
            setCourses(inCourses);
        }

        public String getName(){
            return "Professor" + super.getName();
        }

    /**
     * Accessor to obtain inheritted and new fields.
     * @return
     */
    public String[] getCourses(){
        String[] temp = new String[courses.length];
        for (int i=0; i < courses.length; i++)
            temp[i] = courses[i];
        return temp;
        }

    /**
     * Mutator to adjust the fields to the correct information.
     * @param inCourses
     */
    public void setCourses(String[] inCourses){

            courses = new String[inCourses.length];
            for (int i=0; i < inCourses.length; i++)
                courses[i] = inCourses[i];
        }

    /**
     * toString to set the output of the object with the new information.
     * @return
     */
    public String toString(){
            return getName() + "earns" + getSalary();
        }
}
