/*********************************************************************************
* (Implement inorder traversal without using recursion) Implement the inorder    *
* method in BST using a stack instead of recursion. Write a test program that    *
* prompts the user to enter 10 integers, stores them in a BST, and invokes the   *
* inorder method to display the elements.                                        *
*********************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_25_03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Integer[] numbers = new Integer[10];

		// Prompt the user to enter 10 integers
		System.out.print("Enter 10 integers: ");
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = input.nextInt();
		
		// Create Integer BST
		BST<Integer> intTree = new BST<>(numbers);

		// Traverse tree inorder
		System.out.print("Tree inorder: ");
		intTree.inorder();
		System.out.println();
	}
}