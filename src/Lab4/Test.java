package Lab4;

/**
 * Test program to test:
 * Interface: Rules
 * Class: Employee
 * Inherited Class: Faculty
 *
 * UNK CSIT 150 LAb 4 spring 2017
 * @author Dr. Harms
 * @editor Sam Doubet
 */
public class Test
{

	public static void main(String[] args)
	{

		System.out.println("//**********   Faculty Class Test Start **********//");
		// Create a faculty member and his/her set of courses
		System.out.println("Faculty test, should show name and courses.");
		String[] testCourses = new String[] {"150","441"};
		Faculty sherri = new Faculty("Sherri",65000, testCourses);
		System.out.println(sherri);//be sure you have a toString method for faculty
		System.out.println("Faculty get name and get salary tests.");
		System.out.println("Faculty Name: "+sherri.getName()); // print the faculty name
		System.out.println("Faculty Salary: "+sherri.getSalary()); // print the salary of faculty
		System.out.println("Test faculty constructor, should show name and courses (should NOT contain XYZ).");
		testCourses[1] = "XYZ";
		System.out.println(sherri);
		System.out.println("Test faculty getCourses should show name and courses (should NOT contain ABC).");
		testCourses = sherri.getCourses();  //remember to return a copy
		testCourses[1] = "ABC";
		System.out.println(sherri);
		System.out.println("See the copy of the testCourses array (should contain ABC).");
		for (String c:testCourses)
		{
			System.out.print(c+" ");
		}
		System.out.println();
		System.out.println("Test faculty set courses, should show name and courses (should contain three new courses).");
		String addCourses[] = {"130","425","834"}; // create courses array  
		sherri.setCourses(addCourses); // set the courses for faculty
		System.out.println(sherri);

		System.out.println("Test faculty set courses, should show name and courses (should NOT contain PQR).");
		addCourses[1] = "PQR";
		System.out.println(sherri);
		System.out.println("//**********   Faculty Class Test End **********//");
		System.out.println();

		System.out.println("//********** Faculty as Employee Test Begin **************************//");
		// Create a faculty member as an Employee
		System.out.println("Test faculty as an employee. Should show name and courses.");
		String[] shahramCourses = new String[] {"188","223","448"};
		Employee shahram = new Faculty("Shahram",65000, shahramCourses);
		System.out.println(shahram);
		System.out.println("Test faculty as an employee get name and get salary tests.");
		System.out.println("Employee Name: "+shahram.getName()); // print the faculty name
		System.out.println("Employee Salary: "+shahram.getSalary()); // print the salary of faculty
		System.out.println("Test faculty as an employee, get courses.");
		if (shahram instanceof Faculty)// why is this needed?
		{
			testCourses = ((Faculty)shahram).getCourses();//cast
			for (String c:testCourses)
				System.out.print(c+" ");
			System.out.println();

			System.out.println("Test faculty set courses, should show name and courses (should contain four new courses).");
			String springCourses[] = {"111","301","428","458"}; // create courses array  
			((Faculty)shahram).setCourses(springCourses); // set the courses for faculty
			System.out.println(shahram);
		}
		System.out.println("//********** Faculty as Employee Test End **************************//");
		System.out.println();

		System.out.println("//********** Faculty as a member of Rules interface Test Begin **************************//");
		// Create a faculty member as an Rules
		System.out.println("Test faculty as a member of Rules interface. Should show name and courses.");
		String[] johnCourses = new String[] {"180","330","408"};
		Rules john = new Faculty("John",65000, johnCourses);
		System.out.println(john);
		System.out.println("Test faculty as an a member of Rules interface get name and get salary tests.");
		System.out.println("Rules Name: "+john.getName()); // print the faculty name
		System.out.println("Rules Salary: "+john.getSalary()); // print the salary of faculty
		System.out.println("Test faculty as a member of Rules interface, get courses.");
		if (john instanceof Faculty)
		{
			testCourses = ((Faculty)john).getCourses(); //cast
			for (String c:testCourses)
				System.out.print(c+" ");
			System.out.println();
		}
		System.out.println("Test faculty set courses, should show name and courses (should contain three new courses).");
		String fallCourses[] = {"330","404","496-497"}; // create courses array
		((Faculty)john).setCourses(fallCourses); // set the courses for faculty
		System.out.println(john);
		System.out.println("//********** Faculty as a member of Rules interface Test End **************************//");
		System.out.println();

		System.out.println("//********** Employee Test Begin **************************//");
		System.out.println("Employee test, should show name and salary.");
		Employee carol = new Employee("Carol",35000); // employee object
		System.out.println(carol);
		System.out.println("Employee get name and get salary tests.");
		System.out.println("Employee Name: "+carol.getName());
		System.out.println("Employee Salary: "+carol.getSalary());
		System.out.println("//********** Employee Test End **************************//");
		System.out.println();

		System.out.println("//********** Employee as a member of Rules Interface Test Begin **************************//");
		System.out.println("Rules test, should show name and salary.");
		Rules josh= new Employee("Josh",25000); // employee object
		System.out.println(josh);
		System.out.println("Rules get name and get salary tests.");
		System.out.println("Rules Name: "+josh.getName()); 
		System.out.println("Rules Salary: "+josh.getSalary());
		System.out.println("//********** Employee as a member of Rules Interface Test End **************************//");
	}
}