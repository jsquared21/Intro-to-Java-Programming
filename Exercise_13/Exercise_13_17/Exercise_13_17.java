/*********************************************************************************
* (Math: The Complex class) A complex number is a number in the form a + bi,     *
* where a and b are real numbers and i is 2-1. The numbers a and b are known as  *
* the real part and imaginary part of the complex number, respectively. You can  *
* perform addition, subtraction, multiplication, and division for complex        *
* numbers using the following formulas:                                          *
*                                                                                *
*                    a + bi + c + di = (a + c) + (b + d)i                        *
*                   a + bi - (c + di) = (a - c) + (b - d)i                       *
*                 (a + bi)*(c + di) = (ac - bd) + (bc + ad)i                     *
*         (a + bi)/(c + di) = (ac + bd)/(c2 + d2) + (bc - ad)i/(c2 + d2)         *
*                                                                                *
* You can also obtain the absolute value for a complex number using the          *
* following formula:                                                             *
*                                                                                *
*                            |a + bi| = √(a^2 + b^2)                             *
*                                                                                *
* (A complex number can be interpreted as a point on a plane by identifying the  *
* (a,b) values as the coordinates of the point. The absolute value of the        *
* complex number corresponds to the distance of the point to the origin, as      *
* shown in Figure 13.10b.)                                                       *
*                                                                                *
* Design a class named Complex for representing complex numbers and the methods  *
* add, subtract, multiply, divide, and abs for performing complexnumber          *
* operations, and override toString method for returning a string representation *
* for a complex number. The toString method returns (a + bi) as a string. If b   *
* is 0, it simply returns a. Your Complex class should also implement the        *
* Cloneable interface.                                                           *
*                                                                                *
* Provide three constructors Complex(a, b), Complex(a), and Complex(). Complex() *
* creates a Complex object for number 0 and Complex(a) creates a Complex object  *
* with 0 for b. Also provide the getRealPart() and getImaginaryPart() methods    *
* for returning the real and imaginary part of the complex number, respectively. *
*                                                                                *
* Write a test program that prompts the user to enter two complex numbers and    *
* displays the result of their addition, subtraction, multiplication, division,  *
* and absolute value.                                                            *
*********************************************************************************/
import java.util.Scanner;

public class Exercise_13_17 {
	/** Main method */
	public static void main(String[] args) throws CloneNotSupportedException {

		// Prompt the user to enter two complex numbers
		System.out.print("Enter the first complex number: ");
		Complex complexNumber1 = getComplex();
		System.out.print("Enter the second complex number: ");
		Complex complexNumber2 = getComplex();

		// displays the result of their addition, subtraction, 
		// multiplication, division, and absolute value
		System.out.print(complexNumber1 + " + " + complexNumber2 + " = ");
		print(complexNumber1.add(complexNumber2));

		System.out.print(complexNumber1 + " - " + complexNumber2 + " = "); 
		print(complexNumber1.subtract(complexNumber2));

		System.out.print(complexNumber1 + " * " + complexNumber2 + " = "); 
		print(complexNumber1.multiply(complexNumber2));

		System.out.print(complexNumber1 + " / " + complexNumber2 + " = "); 
		print(complexNumber1.divide(complexNumber2));

		System.out.println("|" + complexNumber1 + "| = " + 
			complexNumber1.abs());
	}

	/** Display result */
	public static void print(Complex n) {
		if (n.getImaginaryPart() == 0)
			System.out.println(n.getRealPart());
		else
			System.out.println(n.getRealPart() + " + " + 
			n.getImaginaryPart() + "i");
	}

	/** Return user input as a complex number */
	public static Complex getComplex() {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		double[] c = new double[2];
		for (int i = 0; i < c.length; i++)
		 	c[i] = input.nextDouble(); 
		return new Complex(c[0], c[1]); 
	}
}