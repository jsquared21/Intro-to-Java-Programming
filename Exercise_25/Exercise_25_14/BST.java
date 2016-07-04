import java.util.Stack;
import java.util.Comparator;

public class BST<E> extends AbstractTree<E> implements Cloneable{
	private Comparator<? super E> comparator;
	protected TreeNode<E> root;
	protected int size = 0;

	/** Create a default binary search tree */
	public BST() {
	}

	/** Create a binary search tree from an array of objects */
	public BST(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	public BST(Comparator<? super E> comparator) {
		this.comparator = comparator;
	}

	public boolean search(E e) {
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			if (comparator.compare(e, current.element) < 0) {
				current = current.left; // Go left
			}
			else if (comparator.compare(e, current.element) > 0) {
				current = current.right; // Go right
			}
			else // Element matches current.element
				return true; // Element is found
		}

		return false; // Element is not in the tree
	}

	public boolean insert(E e) {
		if (root == null)
			root = createNewNode(e); // Create a new root
		else {
			// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				if (comparator.compare(e, current.element) < 0) {
					parent = current;
					current = current.left;
				}
				else if (comparator.compare(e, current.element) > 0) {
					parent = current;
					current = current.right;
				}
				else
					return false; // Duplicate node not inserted
			}
			// Create the new node and attach it to the parent
			if (comparator.compare(e, parent.element) < 0)
				parent.left = createNewNode(e);
			else
				parent.right = createNewNode(e);
		}

		size++;
		return true; // Element inserted successfully
	}

	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<>(e);
	}

	@Override /** Inorder traversal from the root */
	public void inorder() {
		inorder(root);
	}

	/** Inorder traversal from a subtree */
	protected void inorder(TreeNode<E> root) {
		if (root == null) return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}

	@Override /** Postorder traversal from the root */
	public void postorder() {
		postorder(root);
	}

	/** Postorder traversal from a subtree */
	protected void postorder(TreeNode<E> root) {
		if (root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}

	@Override /** Preorder traversal from the root */
	public void preorder() {
		preorder(root);
	}

	/** Preorder traversal from a subtree */
	protected void preorder(TreeNode<E> root) {
		if (root == null) return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}

	/** This inner class is static, because it does not access
		any instance members defined in its outer class */
	public static class TreeNode<E> {
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;

		public TreeNode(E e) {
			element = e;
		}
	}

	@Override /** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public TreeNode<E> getRoot() {
		return root;
	}

	/** Return a path from the root leadting to the specified element */
	public java.util.ArrayList<TreeNode<E>> path(E e) {
		java.util.ArrayList<TreeNode<E>> list = 
			new java.util.ArrayList<>();
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (comparator.compare(e, current.element) < 0) {
				current = current.left;
			}
			else if (comparator.compare(e, current.element) > 0) {
				current = current.right;
			}
			else 
				break;
		}

		return list; // Return an array list of nodes
	}

	@Override /** Delete an element from the binary search tree.
	 * Return true if the element is deleted successfully.
	 * Return false if the element is not in the tree. */
	public boolean delete(E e) {
		//Locate the node to be deleted and also locate its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null) {
			if (comparator.compare(e, current.element) < 0) {
				parent = current;
				current = current.left;
			}
			else if (comparator.compare(e, current.element) > 0) {
				parent = current;
				current = current.right;
			}
			else
				break; // Element is in the tree pointed at by current
		}

		if (current == null)
			return false; // Element is not in the tree

		// Case 1: current has no left child
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {
				root = current.right;
			}
			else {
				if (comparator.compare(e, parent.element) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		}
		else {
			// Case 2: The current node has a left child.
			// Locate the rightmost node in the left subtree of 
			// the current node an also its parent.
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;

			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}

		size--;
		return true; // Element deleted successfully
	}

	@Override /** Obtain an iterator. Use inorder. */
	public java.util.Iterator<E> iterator() {
		return new InorderIterator();
	}

	// Inner class InorderIterator
	private class InorderIterator implements java.util.Iterator<E> {
		// Store the elements in a list
		private java.util.ArrayList<E> list =
			new java.util.ArrayList<>();
		private int current = 0; // Point to the current element in list

		public InorderIterator() {
			inorder(); // Traverse binary tree and store elements in list
		}

		/** Inorder traversal from the root */
		private void inorder() {
			inorder(root);
		}

		/** Inorder traversal from a subtree */
		private void inorder(TreeNode<E> root) {
			if (root == null) return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}

		@Override /** More elements for traversing? */
		public boolean hasNext() {
			if (current < list.size())
				return true;

			return false;
		}

		@Override /** Get the current element and move to the next */
		public E next() {
			return list.get(current++);
		}

		@Override /** Remove the current element */
		public void remove() {
			delete(list.get(current)); // Delete the current element
			list.clear(); // Clear the list
			inorder(); // Rebuild the list
		}
	}

	/** Remove all elements from the tree */
	public void clear() {
		root = null;
		size = 0;
	}

	/** Displays the nodes in a breadth-first traversal */
	public void breadthFirstTraversal() {
		if (root == null) return;
		java.util.Queue<TreeNode<E>> queue = new java.util.LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			TreeNode<E> current = queue.element();
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
			System.out.print(queue.remove().element + " ");
		}
	}

	/** Returns the height of this binary tree */
	public int height() {
		return height(root);
	}

	/** Height from a subtree */
	protected int height(TreeNode<E> root) {
		if (root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	/** Returns true if the tree is a full binary tree */
	public boolean isFullBST() {
		return size == Math.pow(2, height()) - 1 ? true : false;
	}

	/** Returns the number of leaf nodes */
	public int getNumberOfLeaves() {
		return getNumberOfLeaves(root);
	}

	/** Returns the number of leaf nodes */
	protected int getNumberOfLeaves(TreeNode<E> root) {
		if (root == null) return 0;
		
		// If node has no children return 1 
		// else return the sum of all the leaves
		return root.left == null && root.right == null ? 1 : 
			getNumberOfLeaves(root.left) + getNumberOfLeaves(root.right);
	}

	/** Returns the number of nonleaf nodes */
	public int getNumberOfNonLeaves() {
		return getNumberOfNonLeaves(root);
	} 

	/** Returns the number of nonleaf nodes */
	protected int getNumberOfNonLeaves(TreeNode<E> root) {
		if (root == null) return 0;
		
		// If node has children return 0
		// else return 1 plus the sum of the nonleaves
		return (root.left == null && root.right == null) ? 0 : 
			1 + getNumberOfNonLeaves(root.left) + 
			getNumberOfNonLeaves(root.right) ;
	}

	/** Returns true if two trees are equal. 
	 Otherwise returns false (recursive) */
	public boolean equals(BST<E> tree) {
		if (tree.size != size) return false;
		return equals(root, tree.root);
	}

	/** Equals helper */
	protected boolean equals(TreeNode<E> root1, TreeNode<E> root2) {
		if (root1 == root2) return true;
		if (root1 == null || root2 == null) return false;
		return root1.element.equals(root2.element) &&
		equals(root1.left, root2.left) &&
		equals(root1.right, root2.right);
	}

	@Override /** Override the protected clone method  
		defined in the Object class, and deep copy BST */
	public BST<E> clone() throws CloneNotSupportedException {
		BST<E> cloneBST = new BST<>(comparator);
		clone(cloneBST, root);
		return cloneBST;
	}

	/** Clone helper */
	protected void clone(BST<E> clone, TreeNode<E> root) {
		if (root == null) return;
		clone.insert(root.element);
		clone(clone, root.left);
		clone(clone, root.right);
	}

	/** Returns an iterator for traversing the elements in preorder */
	public java.util.Iterator<E> preorderIterator() {
		return new PreorderIterator();
	}

	// Inner class preorderIterator
	private class PreorderIterator implements java.util.Iterator<E> {
		// Store the elements in a list
		private java.util.ArrayList<E> list =
			new java.util.ArrayList<>();
		private int current = 0; // Point to the current element in list

		public PreorderIterator() {
			preorder(); // Traverse binary tree and store elements in list
		}

		/** Preorder traversal from the root */
		private void preorder() {
			preorder(root);
		}

		/** preorder traversal from a subtree */
		private void preorder(TreeNode<E> root) {
			if (root == null) return;
			list.add(root.element);
			preorder(root.left);
			preorder(root.right);
		}

		@Override /** More elements for traversing? */
		public boolean hasNext() {
			if (current < list.size())
				return true;

			return false;
		}

		@Override /** Get the current element and move to the next */
		public E next() {
			return list.get(current++);
		}

		@Override /** Remove the current element */
		public void remove() {
			delete(list.get(current)); // Delete the current element
			list.clear(); // Clear the list
			preorder(); // Rebuild the list
		}
	}
}