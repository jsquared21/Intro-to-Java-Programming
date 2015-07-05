/*********************************************************************************
* (The Course class) Revise the Course class as follows:                         *
*                                                                                *
* ■ The array size is fixed in Listing 10.6. Improve it to automatically         *
*   increase the array size by creating a new larger array and copying the       *
*   contents of the current array to it.                                         *
* ■ Implement the dropStudent method.                                            *
* ■ Add a new method named clear() that removes all students from the            *
*   course.                                                                      *
*                                                                                *
* Write a test program that creates a course, adds three students, removes one,  *
* and displays the students in the course.                                       *
*********************************************************************************/
public class Exercise_10_09 {
	/** Main method */
	public static void main(String[] args) {
		// Create a course
		Course math101 = new Course("math101");

		// Add three students
		math101.addStudent("Mark");
		math101.addStudent("Tom");
		math101.addStudent("Joan");

		// remove one student
		math101.dropStudent("Tom");

		// Displays the students in the course
		System.out.println("\nThe students in the course " + 
			math101.getCourseName() + ":");
		String[] students = math101.getStudents();
		for (int i = 0; i < math101.getNumberOfStudents(); i++) {
			System.out.print(students[i] + " ");
		}
		System.out.println();
	}
}