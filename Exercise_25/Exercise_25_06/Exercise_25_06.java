/*********************************************************************************
* (Find the leaves) Add a method in the BST class to return the number of the    *
* leaves as follows:                                                             *
*                                                                                *
* ** Returns the number of leaf nodes *                                          *
* public int getNumberOfLeaves()                                                 *
*********************************************************************************/
public class Exercise_25_06 {
	public static void main(String[] args) {
		Integer[] numbers = {60, 55, 45, 47, 59, 100, 76, 107, 101};
		
		// Create Integer BST
		BST<Integer> intTree = new BST<>(numbers);

		// Traverse tree postorder
		System.out.println("Number of leaf nodes: " + 
			intTree.getNumberOfLeaves());
	}
}