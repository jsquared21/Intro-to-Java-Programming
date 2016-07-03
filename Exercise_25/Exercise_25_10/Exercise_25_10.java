/*********************************************************************************
* (Preorder iterator) Add the following method in the BST class that returns an  *
* iterator for traversing the elements in a BST in preorder.                     *
*                                                                                *
* ** Returns an iterator for traversing the elements in preorder *               *
* java.util.Iterator<E> preorderIterator()                                       *
*********************************************************************************/
import java.util.Iterator;

public class Exercise_25_10 {
	public static void main(String[] args) {
		BST<String> tree = new BST<>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");

		// Obtain an interator for traversing 
		// the elements in the BST in preorder
		Iterator<String> iterator = tree.preorderIterator();

		// Traverse all the strings in the tree 
		// and display the strings in uppercase
		while (iterator.hasNext())
			System.out.print(iterator.next().toUpperCase() + " ");
		System.out.println();
	}
}