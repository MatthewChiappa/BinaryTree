// To show that tree works whatever values that are smaller
// than the value of the root are put on the left side of the tree 
// and the values bigger the value of the root are put on the right
// side. When the tree is printed inorder the numbers are printed
// from smallest to greatest to show that the values of the tree 
// have been put in the corrrect order.
package BinaryTree;

import java.util.Scanner;

public class Main {
  
  static Tree tree = new Tree();
   
  public static void main(String[] args) {
    
    // adding and deleting values on the list
    
    tree.add(110);
    tree.add(11);
    tree.delete(11);
    tree.add(302);
    tree.add(1002);
    tree.add(2);
    tree.add(100);
    //tree.delete(1002);
    System.out.println("");
    
    // printing the tree in every type of order
    
    tree.printTreePreOrder(tree.getRootItem());
    System.out.println("");
    tree.printTreeInOrder(tree.getRootItem());
    System.out.println("");
    tree.printTreePostOrder(tree.getRootItem());
    
    System.out.println("");
    
    // finding a particular nod in the tree by its key
    // and printing a zero when the node doesn't exist
    System.out.println(tree.findNode(100).getData());
    System.out.println(tree.findNode(4325453).getData());
    
    getInput();
    
  }
  
  // gets any input from the user to add to the tree 
  // or print from the tree
  
  public static void getInput() {
    
    Scanner scan = new Scanner(System.in);
    
    String input = scan.next();
      if (input.equals("add")) {
      int number = scan.nextInt();
      tree.add(number);
    }
    else if (input.equals("print")) {
      tree.printTreeInOrder(tree.getRootItem());
      System.out.println("");
    }
    else {
      System.out.println("That is not a valid input.");
    }
    
    getInput();
  }
  
}