/**********************************************************************************
* (The Fan class) Design a class named Fan to represent a fan. The class contains:*
*                                                                                 *
* ■ Three constants named SLOW, MEDIUM, and FAST with the values 1, 2, and 3 to   *
*   denote the fan speed.                                                         *
* ■ A private int data field named speed that specifies the speed of the fan (the *
*   default is SLOW).                                                             *
* ■ A private boolean data field named on that specifies whether the fan is on    *
*   (the default is false).                                                       *
* ■ A private double data field named radius that specifies the radius of the fan *
*   (the default is 5).                                                           *
* ■ A string data field named color that specifies the color of the fan           *
*   (the default is blue).                                                        *
* ■ The accessor and mutator methods for all four data fields.                    *
* ■ A no-arg constructor that creates a default fan.                              *
* ■ A method named toString() that returns a string description for the fan. If   *
*   the fan is on, the method returns the fan speed, color, and radius in one     *
*   combined string. If the fan is not on, the method returns the fan color and   *
*   radius along with the string “fan is off” in one combined string.             *
*                                                                                 *
* Draw the UML diagram for the class and then implement the class. Write a test   *
* program that creates two Fan objects. Assign maximum speed, radius 10, color    *
* yellow, and turn it on to the first object. Assign medium speed, radius 5,      *
* color blue, and turn it off to the second object. Display the objects by        *
* invoking their toString method.                                                 *
/*********************************************************************************/

public class Exercise_09_08 {
	/** Main method */
	public static void main(String[] args) {
		final int SLOW = 1;		// Fan speed slow
		final int MEDIUM = 2;	// Fan speed medium
		final int FAST = 3;		// Fan speed fast

		// Create two Fan objects
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();

		// Assign maximum speed, radius 10, color yellow,  
		// and turn it on to the first object
		fan1.setSpeed(FAST);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.turnOn();

		// Assign medium speed, radius 5, color blue,
		// and turn it off to the second object
		fan2.setSpeed(MEDIUM);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.turnOff();

		// Display the objects by invoking their toString method
		System.out.println(fan1.toString());
		System.out.println(fan2.toString());
	}
}