//-----------------------------------------------------------------------------
//Tristan Tsang
//Eckard 4B
//Advanced Data Structures
//16.9 IntSet
//-----------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//This class implements an Integer set implemented by a binary search tree
//-----------------------------------------------------------------------------
public class IntSet {

  private BinarySearchTree tree;

  //-----------------------------------------------------------------------------
  //Constructs set
  //-----------------------------------------------------------------------------

  public IntSet() {
    tree = new BinarySearchTree();
  }

  //-----------------------------------------------------------------------------
  //Inserts a new element into the set (if unique else it does nothing)
  //-----------------------------------------------------------------------------
  public void add(Integer obj) {
    if (!tree.find(obj)) tree.add(obj);
  }

  //-----------------------------------------------------------------------------
  //Returns true if set contains an element and false if not
  //-----------------------------------------------------------------------------
  public boolean find(Integer obj) {
    return tree.find(obj);
  }

  //-----------------------------------------------------------------------------
  //Removes an element from a tree if it contains it else it does nothing
  //-----------------------------------------------------------------------------
  public void remove(Integer obj) {
    if (tree.find(obj)) tree.remove(obj);
  }

  //-----------------------------------------------------------------------------
  //Prints the tree in sorted order
  //-----------------------------------------------------------------------------
  public void print() {
    tree.print();
  }
}
