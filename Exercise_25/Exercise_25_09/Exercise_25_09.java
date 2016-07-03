/*********************************************************************************
* (Tree clone and equals) Implement the clone and equals methods in the BST      *
* class . Two BST trees are equal if they contain the same elements. The clone   *
* method returns an identical copy of a BST.                                     *
*********************************************************************************/
public class Exercise_25_09 {
	public static void main(String[] args) throws Exception {
		Integer[] numbers = {60, 55, 45, 47, 59, 100, 76, 107, 101};
		Integer[] numbers2 = {60, 55, 45, 48, 59, 100, 76, 107, 101};
		
		// Create two Integer BST
		BST<Integer> intTree = new BST<>(numbers);
		BST<Integer> intTree2 = new BST<>(numbers2);

		// Display BST in preorder
		System.out.print("intTree: ");
		intTree.preorder();
		System.out.print("\nintTree2: ");
		intTree2.preorder();


		// Clone intTree
		BST<Integer> intTreeCopy = intTree.clone();

		// Test for equality
		System.out.println("\nIs intTree equal to intTree2? " + 
			intTree.equals(intTree2));
		System.out.println("Is intTree equal to intTreeCopy? " + 
			intTree.equals(intTreeCopy));

		// Display BST in preorder
		System.out.print("intTreeCopy: ");
		intTreeCopy.preorder();
		System.out.println();
	}
}