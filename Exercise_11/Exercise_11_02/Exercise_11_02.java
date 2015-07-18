/*********************************************************************************
* (The Person, Student, Employee, Faculty, and Staff classes) Design a           *
* class named Person and its two subclasses named Student and Employee.          *
* Make Faculty and Staff subclasses of Employee. A person has a name,            *
* address, phone number, and email address. A student has a class status         *
* (freshman, sophomore, junior, or senior). Define the status as a constant. An  *
* employee has an office, salary, and date hired. Use the MyDate class defined   *
* in Programming Exercise 10.14 to create an object for date hired. A faculty    *
* member has office hours and a rank. A staff member has a title. Override the   *
* toString method in each class to display the class name and the person’s name. *
* Draw the UML diagram for the classes and implement them. Write a test program  *
* that creates a Person, Student, Employee, Faculty, and Staff, and invokes      *
* their toString() methods.                                                      *
*********************************************************************************/
public class Exercise_11_02 {
	// Main method
	public static void main(String[] args) {
		// Create a Person, Student, Employee, Faculty, and Staff objects
		Person person = new Person("John", "12 Bell street", 
			"3473339999", "john12@aol.com");

		Student student = new Student("Mary", "100 Town Ave", "5149993333", 
			"mary100@aol.com", Student.FRESHMAN);

		Employee employee = new Employee("Mike", "34 West street", "6189999999",
			"mike80@aol.com", 910, 60000);

		Faculty faculty = new Faculty("Sue", "28 Well street", "4133333333",
			"sue28@aol.com", 101, 50000, "4pm to 6pm", "Professor");

		Staff staff = new Staff("Tom", "90 Country road", "2030000000",
			"tomcat@aol.com", 12, 65000, "Executive Assistant");

		// Invoke toString of Person, Student, Employee, Faculty and Staff
		System.out.println(person.toString());
		System.out.println(student.toString());
		System.out.println(employee.toString());
		System.out.println(faculty.toString());
		System.out.println(staff.toString());
	}
}