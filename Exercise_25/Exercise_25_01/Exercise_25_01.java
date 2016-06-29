/*********************************************************************************
* (Add new methods in BST) Add the following new methods in BST.                 *
*                                                                                *
* ** Displays the nodes in a breadth-first traversal *                           *
* public void breadthFirstTraversal()                                            *
*                                                                                *
* ** Returns the height of this binary tree *                                    *
* public int height()                                                            *
*********************************************************************************/
public class Exercise_25_01 {
	public static void main(String[] args) {
		// Create a BST
		BST<String> tree = new BST<>();
		tree.insert("George");
		tree.insert("Micheal");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");

		// Traverse tree breadth-first
		System.out.print("\nBreadth-first: ");
		tree.breadthFirstTraversal();

		// Height of tree
		System.out.print("\nHeight of tree: ");	
		System.out.println(tree.height());

		// Create Integer BST
		Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
		BST<Integer> intTree = new BST<>(numbers);
		
		// Traverse tree breadth-first
		intTree.breadthFirstTraversal();

		// Height of tree
		System.out.print("\nHeight of tree: ");	
		System.out.println(intTree.height());
	}
}