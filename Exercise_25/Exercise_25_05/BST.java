import java.util.Stack;

public class BST<E extends Comparable<E>>
		extends AbstractTree<E> {
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

	@Override /** Return true if the element is in the tree */
	public boolean search(E e) {
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left; // Go left
			}
			else if (e.compareTo(current.element) > 0) {
				current = current.right; // Go right
			}
			else // Element matches current.element
				return true; // Element is found
		}

		return false; // Element is not in the tree
	}

	@Override /** Insert element e into the binary search tree.
	 *	Return true if the element is inserted successfully. */
	public boolean insert(E e) {
		if (root == null)
			root = createNewNode(e); // Create a new root
		else {
			// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}
				else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				}
				else
					return false; // Duplicate node not inserted
			}
			// Create the new node and attach it to the parent
			if (e.compareTo(parent.element) < 0)
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

	/** Inorder traversal from a subtree without using recursion */
	protected void inorder(TreeNode<E> root) {
		if (root == null) return;
		Stack<TreeNode<E>> stack = new Stack<>();
		TreeNode<E> current = root;
		while (!stack.empty() || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				TreeNode<E> node = stack.pop();
				System.out.print(node.element + " ");
				current = node.right;
			}
		}
	}

	@Override /** Postorder traversal from the root */
	public void postorder() {
		postorder(root);
	}

	/** Postorder traversal from a subtree without using recursion */
	protected void postorder(TreeNode<E> root) {
		if (root == null) return;

		// Create two stacks
		Stack<TreeNode<E>> stack1 = new Stack<>();
		Stack<TreeNode<E>> stack2 = new Stack<>();

		// push root to stack1
		stack1.push(root);
		while (!stack1.empty()) {
			// Pop node from stack1 and push onto stack2
			TreeNode<E> node = stack1.pop();
			stack2.push(node);

			if (node.left != null)
				stack1.push(node.left);
			if (node.right != null)
				stack1.push(node.right);
		}

		// Display elements in stack2
		while (!stack2.empty()) {
			System.out.print(stack2.pop().element + " ");
		}
	}

	@Override /** Preorder traversal from the root */
	public void preorder() {
		preorder(root);
	}

	/** Preorder traversal from a subtree without using recursion */
	protected void preorder(TreeNode<E> root) {
		if (root == null) return;

		Stack<TreeNode<E>> stack = new Stack<>();
		stack.push(root);

		while (!stack.empty()) {
			TreeNode<E> node = stack.pop();
			System.out.print(node.element + " ");

			// Push the right child onto the stack 
			// first so the left isgit processed first
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	/** This inner class is static, because it does not access
		any instance members defined in its outer class */
	public static class TreeNode<E extends Comparable<E>> {
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
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) {
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
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) {
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
				if (e.compareTo(parent.element) < 0)
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
}