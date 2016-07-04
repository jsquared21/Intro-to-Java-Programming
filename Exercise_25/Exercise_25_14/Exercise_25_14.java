/*********************************************************************************
* (Generic BST using Comparator) Revise BST in Listing 25.5, using a generic     *
* parameter and a Comparator for comparing objects. Define a new constructor     *
* with a Comparator as its argument as follows:                                  *
*                                                                                *
* BST(Comparator<? super E> comparator)                                          *
*********************************************************************************/

public class Exercise_25_14 {
	public static void main(String[] args) throws CloneNotSupportedException {
		// Create a BST
		BST<GeometricObject> tree = 
			new BST<GeometricObject>(new GeometricObjectComparator());

		// Create 4 GeometricObjects
		GeometricObject object1 = new Circle(5);
		GeometricObject object2 = new Rectangle(4, 5);
		GeometricObject object3 = new Circle(6.5);
		GeometricObject object4 = new Rectangle(2.4, 5);

		// Insert objects in tree
		tree.insert(object1);
		tree.insert(object2);
		tree.insert(object3);
		tree.insert(object4);
		
		// Display the tree
		System.out.println("Create a tree of geometric objects and display it: ");
		tree.preorder();

		// Clone the tree and test for equality
		System.out.println("\n\nClone the tree ...");
		BST<GeometricObject> tree2 = tree.clone();
		System.out.println("Is tree #1 equal to tree #2? " + tree.equals(tree2));

		// Insert a new object in clone and test for equality
		System.out.println("\nInsert a new geometric object in tree2 ...");
		tree2.insert(new Circle(4));
		System.out.println("Is tree #1 equal to tree #2? " + tree.equals(tree2));
	}
}