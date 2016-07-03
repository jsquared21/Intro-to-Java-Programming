/** Returns true if two trees are equal. 
 Otherwise returns false (iterative) */
public boolean equals(BST<E> tree) {
	if (tree.size != size) return false;

	if (root == null) return true;
	Stack<TreeNode<E>> stack = new Stack<>();
	Stack<TreeNode<E>> stackO = new Stack<>();
	TreeNode<E> current = root;
	TreeNode<E> currentO = tree.root;
	while (!stack.empty() || current != null) {
		if (current != null) {
			stack.push(current);
			stackO.push(currentO);
			current = current.left;
			currentO = currentO.left;
		}
		else {
			TreeNode<E> node = stack.pop();
			TreeNode<E> nodeO = stackO.pop();
			if (node.element.compareTo(nodeO.element) != 0) return false;
			current = node.right;
			currentO = nodeO.right;
		}
	}
	
	return true;
}