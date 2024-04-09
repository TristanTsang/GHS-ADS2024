//-----------------------------------------------------------------------------
//Tristan Tsang
//Eckard 4B
//March 14th,2024
//A Binary search tree for integers
//-----------------------------------------------------------------------------
public class IntTree {

  //-------------------------------------------------------------------------
  // Constructor
  //-------------------------------------------------------------------------
  public IntTree() {
    root = null;
  }

  //-------------------------------------------------------------------------
  // Adds node into the tree
  //-------------------------------------------------------------------------
  public void insert(Integer n) {
    Node node = new Node(n);
    if (root == null) root = node; else root.addNode(node);
  }

  //-------------------------------------------------------------------------
  // Finds node in the tree and returns true if it contains the node
  //-------------------------------------------------------------------------
  public boolean find(Integer n) {
    Node current = root;
    while (current != null) {
      int d = current.data.compareTo(n);
      if (d == 0) return true; else if (d > 0) current =
        current.left; else current = current.right;
    }
    return false;
  }

  //-------------------------------------------------------------------------
  // removes node from tree
  //-------------------------------------------------------------------------
  public void remove(Integer n) {
    // Find node to be removed
    Node toBeRemoved = root;
    Node parent = null;
    boolean found = false;
    while (!found && toBeRemoved != null) {
      int d = toBeRemoved.data.compareTo(n);
      if (d == 0) found = true; else {
        parent = toBeRemoved;
        if (d > 0) toBeRemoved = toBeRemoved.left; else toBeRemoved =
          toBeRemoved.right;
      }
    }
    if (!found) return;

    if (toBeRemoved.left == null || toBeRemoved.right == null) {
      Node newChild;
      if (toBeRemoved.left == null) newChild =
        toBeRemoved.right; else newChild = toBeRemoved.left;
      if (parent == null) root = newChild; else if (
        parent.left == toBeRemoved
      ) parent.left = newChild; else parent.right = newChild;
      return;
    }

    Node smallestParent = toBeRemoved;
    Node smallest = toBeRemoved.right;
    while (smallest.left != null) {
      smallestParent = smallest;
      smallest = smallest.left;
    }

    toBeRemoved.data = smallest.data;
    if (smallestParent == toBeRemoved) smallestParent.right =
      smallest.right; else smallestParent.left = smallest.right;
  }

  //-------------------------------------------------------------------------
  // prints the nodes of the tree in inorder
  //-------------------------------------------------------------------------
  public void print() {
    if (root != null) root.printNodes();
    System.out.println();
  }

  private Node root;

  //-------------------------------------------------------------------------
  // Node inner class of tree
  //-------------------------------------------------------------------------
  private class Node {

    //-------------------------------------------------------------------------
    // Constructor
    //-------------------------------------------------------------------------
    public Node(Integer n) {
      data = n;
      left = null;
      right = null;
    }

    //-------------------------------------------------------------------------
    // Adds node as a descendent to this node
    //-------------------------------------------------------------------------
    public void addNode(Node newNode) {
      int comp = newNode.data.compareTo(data);
      if (comp < 0) {
        if (left == null) left = newNode; else left.addNode(newNode);
      } else if (comp > 0) {
        if (right == null) right = newNode; else right.addNode(newNode);
      }
    }

    //-------------------------------------------------------------------------
    // Prints every node in inorder traversal
    //-------------------------------------------------------------------------
    public void printNodes() {
      if (left != null) left.printNodes();
      System.out.print(data + " ");
      if (right != null) right.printNodes();
    }

    public Integer data;
    public Node left;
    public Node right;
  }
}
