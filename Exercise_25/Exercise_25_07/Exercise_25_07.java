/*********************************************************************************
* (Find the leaves) Add a method in the BST class to return the number of the    *
* nonleaves as follows:                                                          *
*                                                                                *
* ** Returns the number of nonleaf nodes *                                       *
* public int getNumberOfNonLeaves()                                              *
*********************************************************************************/
public class Exercise_25_07 {
	public static void main(String[] args) {
		Integer[] numbers = {60, 55, 45, 47, 59, 100, 76, 107, 101};
		
		// Create Integer BST
		BST<Integer> intTree = new BST<>(numbers);

		// Traverse tree postorder
		System.out.println("Number of nonleaf nodes: " + 
			intTree.getNumberOfNonLeaves());
	}
}