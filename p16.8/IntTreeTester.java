//-----------------------------------------------------------------------------
//Tristan Tsang
//Eckard 4B
//March 14th,2024
//Tester class for IntTree
//-----------------------------------------------------------------------------
public class IntTreeTester
{  
   //main method
   public static void main(String[] args)
   {  
      IntTree t = new IntTree();
      t.insert(5);
      t.insert(3);
      t.insert(4);
      t.insert(11);
      t.insert(9);

      t.print();
      System.out.println("Expected: 3 4 5 9 11");
   }
}
