//-----------------------------------------------------------------------------
//Tristan Tsang
//Eckard 4B
//Advanced Data Structures
//16.9 IntSet
//-----------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//A Tester class for int set
//-----------------------------------------------------------------------------
public class IntSetTester {

  public static void main(String[] args) {
    IntSet s = new IntSet();
    s.add(2);
    s.add(3);
    s.add(7);
    s.add(5);
    s.add(9);
    s.add(7);
    s.remove(9);
    s.print();
    System.out.println("Expected: 2 3 5 7");
    System.out.println(s.find(7));
    System.out.println("Expected: true");
    System.out.println(s.find(9));
    System.out.println("Expected: false");
  }
}
