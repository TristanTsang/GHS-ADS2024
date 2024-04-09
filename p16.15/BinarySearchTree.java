//-----------------------------------------------------------------------------
//Tristan Tsang
//Eckard PD4B
//April 16th, 2024
//P16.15 Preorder Postorder Inorder traversal
//-----------------------------------------------------------------------------
public class BinarySearchTree {

  //-----------------------------------------------------------------------------
  //Constructor
  //-----------------------------------------------------------------------------
  public BinarySearchTree() {
    root = null;
  }

  //-----------------------------------------------------------------------------
  //Adds a new node with data to the tree
  //-----------------------------------------------------------------------------
  public void add(Comparable obj) {
    Node newNode = new Node();
    newNode.data = obj;
    newNode.left = null;
    newNode.right = null;
    if (root == null) root = newNode; else root.addNode(newNode);
  }

  //-----------------------------------------------------------------------------
  //Tries to find an item in the tree if it does returns true else false
  //-----------------------------------------------------------------------------
  public boolean find(Comparable obj) {
    Node current = root;
    while (current != null) {
      int d = current.data.compareTo(obj);
      if (d == 0) return true; else if (d > 0) current =
        current.left; else current = current.right;
    }
    return false;
  }

  //-----------------------------------------------------------------------------
  //Attempts to remove a given item in the tree
  //-----------------------------------------------------------------------------
  public void remove(Comparable obj) {
    // Find node to be removed

    Node toBeRemoved = root;
    Node parent = null;
    boolean found = false;
    while (!found && toBeRemoved != null) {
      int d = toBeRemoved.data.compareTo(obj);
      if (d == 0) found = true; else {
        parent = toBeRemoved;
        if (d > 0) toBeRemoved = toBeRemoved.left; else toBeRemoved =
          toBeRemoved.right;
      }
    }

    if (!found) return;

    // toBeRemoved contains obj

    // If one of the children is empty, use the other

    if (toBeRemoved.left == null || toBeRemoved.right == null) {
      Node newChild;
      if (toBeRemoved.left == null) newChild =
        toBeRemoved.right; else newChild = toBeRemoved.left;

      if (parent == null) root = newChild; else if (
        parent.left == toBeRemoved
      ) parent.left = // Found in root
        newChild; else parent.right = newChild;
      return;
    }

    // Neither subtree is empty

    // Find smallest element of the right subtree

    Node smallestParent = toBeRemoved;
    Node smallest = toBeRemoved.right;
    while (smallest.left != null) {
      smallestParent = smallest;
      smallest = smallest.left;
    }

    // smallest contains smallest child in right subtree

    // Move contents, unlink child

    toBeRemoved.data = smallest.data;
    if (smallestParent == toBeRemoved) smallestParent.right =
      smallest.right; else smallestParent.left = smallest.right;
  }

  //-----------------------------------------------------------------------------
  //Prints the tree via inorder traversal
  //-----------------------------------------------------------------------------
  public void print() {
    if (root != null) root.printNodes();
    System.out.println();
  }

  //-----------------------------------------------------------------------------
  //Prints tree via pre order traversal
  //-----------------------------------------------------------------------------
  public void printPreOrder() {
    root.printPreOrder();
    System.out.println();
  }

  //-----------------------------------------------------------------------------
  //prints tree via post order traversal
  //-----------------------------------------------------------------------------
  public void printPostOrder() {
    root.printPostOrder();
    System.out.println();
  }

  //-----------------------------------------------------------------------------
  //Node inner class
  //-----------------------------------------------------------------------------
  private Node root;

  /**
      A node of a tree stores a data item and references
      of the child nodes to the left and to the right.
   */
  private class Node {

    /**
         Inserts a new node as a descendant of this node.
         @param newNode the node to insert
      */
    public void addNode(Node newNode) {
      int comp = newNode.data.compareTo(data);
      if (comp < 0) {
        if (left == null) left = newNode; else left.addNode(newNode);
      } else if (comp > 0) {
        if (right == null) right = newNode; else right.addNode(newNode);
      }
    }

    //-----------------------------------------------------------------------------
    //Prints in order
    //-----------------------------------------------------------------------------
    public void printNodes() {
      if (left != null) left.printNodes();
      System.out.print(data + " ");
      if (right != null) right.printNodes();
    }

    //-----------------------------------------------------------------------------
    //Prints pre order
    //-----------------------------------------------------------------------------
    public void printPreOrder() {
      System.out.print(data + " ");
      if (left != null) left.printPreOrder();
      if (right != null) right.printPreOrder();
    }

    //-----------------------------------------------------------------------------
    //Prints post order
    //-----------------------------------------------------------------------------
    public void printPostOrder() {
      if (left != null) left.printPostOrder();
      if (right != null) right.printPostOrder();
      System.out.print(data + " ");
    }

    public Comparable data;
    public Node left;
    public Node right;
  }
}
