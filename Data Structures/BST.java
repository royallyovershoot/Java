/**
Implementing a simply BinarySearchTree
*/
/**
 * This class encapsulates a binary search tree.
 *
 * @author Steven Castellucci, 2015
 * @author Navid Mohaghegh - Debugged 2016
 */
public class BinarySearchTree<E extends Comparable<? super E>>
// E Ensure the parameterized type can be sorted.
{
    private Node<E> root;

    /**
     * Get the root of the BST
     * 
     * @return the root
     */
    public Node<E> getRoot()
    {
	return root;
    }

    /**
     * Initializes an empty binary search tree.
     */
    public BinarySearchTree()
    {
	root = null;
    }

    /**
     * Adds the passed value to the tree.
     * 
     * @param value
     *            the value to add to the tree
     */
    public void add(E value)
    {
	root = addNode(root, value);
    }

    // Solves 'add' recursively.
    private Node<E> addNode(Node<E> root, E value)
    {
	if (root == null) // Base case, add node here.
	{
	    return new Node<E>(value, null, null);
	}
	else if (root.data.compareTo(value) > 0) // Recursive, go left.
	{
	    root.leftSubTree = addNode(root.leftSubTree, value);
	    return root;
	}
	else // Recursive, go right.
	{
	    root.rightSubTree = addNode(root.rightSubTree, value);
	    return root;
	}
    }

    /**
     * Removes the passed value from the tree. The tree is not changed if it
     * does not contain the passed value.
     * 
     * @param value
     *            the value to remove from the tree.
     */
    public void remove(E value)
    {
	root = removeNode(root, value);
    }

    // Solves 'remove' recursively.
    private Node<E> removeNode(Node<E> root, E value)
    {
	if (null == root) return null; 
	
	if (root != null && root.data.compareTo(value) == 0)
	// Base case, remove this node.
	{
	    // Case 1 or 2 (i.e., 0 or 1 child)
	    if (root.leftSubTree == null)
	    {
		// null if Case 1, not null if Case 2
		return root.rightSubTree;
	    }
	    // Case 2 (i.e., 1 child on left)
	    else if (root.rightSubTree == null)
	    {
		return root.leftSubTree;
	    }
	    else // Case 3 (i.e., 2 children)
	    {
		root.data = largestValue(root.leftSubTree).data;
		root.leftSubTree = removeLargestNode(root.leftSubTree);
		return root;
	    }
	}
	else if (root.data.compareTo(value) > 0) // Recursive case, go left.
	{
	    root.leftSubTree = removeNode(root.leftSubTree, value);
	    return root;
	}
	else // Recursive case, go right.
	{
	    root.rightSubTree = removeNode(root.rightSubTree, value);
	    return root;
	}
    }

    // Returns the largest value in the subtree rooted at 'root'.
    private Node<E> largestValue(Node<E> root)
    {
	if (root.rightSubTree == null) // Base case, this node has largest.
	{
	    return root;
	}
	else // Recursive case, keep going right.
	{
	    return largestValue(root.rightSubTree);
	}
    }

    // Returns the smallest value in the subtree rooted at 'root'.
    private Node<E> smallestValue(Node<E> root)
    {
	if (root.leftSubTree == null) // Base case, this node has smallest.
	{
	    return root;
	}
	else // Recursive case, keep going left.
	{
	    return smallestValue(root.leftSubTree);
	}
    }

    // Removes the node with the largest value in the subtree rooted at 'root'.
    private Node<E> removeLargestNode(Node<E> root)
    {
	if (root.rightSubTree == null) // Case 1 or 2 (i.e., 0 or 1 child)
	{
	    return root.leftSubTree; // null if Case 1, not null if Case 2
	}
	else
	{
	    root.rightSubTree = removeLargestNode(root.rightSubTree);
	    return root;
	}
    }

    public String toString()
    {
	StringBuffer sb = new StringBuffer();
	infixPrint(root, sb);
	return sb.toString().trim();
    }

    public String toString(String traversal)
    {
	if (traversal == null)
	    return "";
	StringBuffer sb = new StringBuffer();

	if (traversal.equalsIgnoreCase("preorder"))
	{
	    preorderPrint(root, sb);
	}
	else if (traversal.equalsIgnoreCase("postorder"))
	{
	    postorderPrint(root, sb);
	}
	else if (traversal.equalsIgnoreCase("inorder"))
	{
	    infixPrint(root, sb);
	}

	return sb.toString().trim();
    }

    // Prints the elements in infix order.
    private void infixPrint(Node<E> root, StringBuffer sb)
    {
	if (root != null)
	{
	    infixPrint(root.leftSubTree, sb);
	    sb.append(root.data + " ");
	    infixPrint(root.rightSubTree, sb);
	}
    }

    private void preorderPrint(Node<E> root, StringBuffer sb)
    {
	if (root != null)
	{
	    sb.append(root.data + " ");
	    preorderPrint(root.leftSubTree, sb);
	    preorderPrint(root.rightSubTree, sb);
	}
    }

    private void postorderPrint(Node<E> root, StringBuffer sb)
    {
	if (root != null)
	{
	    postorderPrint(root.leftSubTree, sb);
	    postorderPrint(root.rightSubTree, sb);
	    sb.append(root.data + " ");
	}
    }

    /*
     * This static nested class encapsulates a node in the tree.
     */
    static class Node<E>
    {
	private E data;
	private Node<E> leftSubTree;
	private Node<E> rightSubTree;

	public Node(E data, Node<E> leftSubTree, Node<E> rightSubTree)
	{
	    this.data = data;
	    this.leftSubTree = leftSubTree;
	    this.rightSubTree = rightSubTree;
	}

	public E getData()
	{
	    return this.data;
	}
    }
    
    
    
    public static void main(String[] args)
    {
	// Use non-negative integers ... -1 at the end of your string
	String values = "50 27 74 8 44 83 73 93 31 32 -1";

	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	@SuppressWarnings("resource")
	java.util.Scanner input = new java.util.Scanner(values);
	for (int i = input.nextInt(); i != -1; i = input.nextInt())
	{
	    bst.add(i);
	}

	System.out.println("inorder:   " + bst.toString("inorder"));
	System.out.println("preorder:  " + bst.toString("preorder"));
	System.out.println("postorder: " + bst.toString("postorder"));

	bst.remove(27);
	System.out.println("BST - After Removing 27: " + bst);
	System.out.println("BST Root: " + bst.getRoot().getData());
    }    
}


