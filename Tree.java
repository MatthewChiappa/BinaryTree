package BinaryTree;

public class Tree {
  
  Node root;
  int size;
  
  // creates a new tree
  
  public Tree() {
    root = null;
  }
  
  // checks if the tree is empty
  
  public boolean isEmpty() {
    return (root == null);
  }
  
  // adds nodes to the tree
  
  public void add(int data) {
    
    Node newNode = new Node(data);
    
    if (root == null) {
      root = newNode;
    }
    else {
      Node curr = root;
      Node parent;
      while (true) {
        parent = curr;
        
      if (data < curr.getData()) {
        curr = curr.getLeft();
        if (curr == null) {
          parent.setLeft(newNode);
          return;
        }
      }
      else {
        curr = curr.getRight();
        if (curr == null) {
          parent.setRight(newNode);
          return;
        }
      }
      }
    }
    size++;
  }
  
  public Node findNode(int data) {
    
    Node curr = root;
    
    while (curr.getData() != data) {
      if (data < curr.getData()) {
        curr = curr.getLeft();
      } 
      else {
        curr = curr.getRight();
      }
      
      if (curr == null) {
        return (new Node(0));
      }
      
    }
    return curr;
  }
  
  // deletes nodes from the tree
  
  public boolean delete(int data) {
    
    Node curr = root;
    Node parent = root;
    boolean isItALeftChild = true;

    while (curr.getData() != data) {

      parent = curr;

      if (data < curr.getData()) {

        isItALeftChild = true;
        curr = curr.getLeft();

      } 
      else {
        isItALeftChild = false;
        curr = curr.getRight();
      }

      if (curr == null)
        return false;

    }

    if (curr.getLeft() == null && curr.getRight() == null) {
      if (curr == root)
        root = null;
      else if (isItALeftChild)
        parent.setLeft(null);
      else
        parent.setRight(null);

    }
    else if (curr.getRight() == null) {

      if (curr == root)
        root = curr.getLeft();
      else if (isItALeftChild)
        parent.setLeft(curr.getLeft());
      else
        parent.setRight(curr.getLeft());

    }
    else if (curr.getLeft() == null) {

      if (curr == root)
        root = curr.getRight();
      else if (isItALeftChild)
        parent.setLeft(curr.getRight());
      else
        parent.setRight(curr.getRight());

    }
    else {
      Node replace = getReplacement(curr);

      if (curr == root)
        root = replace;
      else if (isItALeftChild)
        parent.setLeft(replace);
      else
        parent.setRight(replace);

      replace.setLeft(curr.getLeft());

    }

    return true;
  }
  
  // gets a replacement node to fill in the tree when a
  // node is deleted

  public Node getReplacement(Node replace) {

    Node replacementParent = replace;
    Node replacement = replace;

    Node curr = replace.getRight();

    while (curr != null) {

      replacementParent = replacement;

      replacement = curr;

      curr = curr.getLeft();

    }
    
    if (replacement != replace.getRight()) {

      replacementParent.setLeft(replacement.getRight());
      replacement.setRight(replace.getRight());
      
    }

    return replacement;
  }
  
  // prints the tree in preorder
  
  public void printTreePreOrder(Node curr) {
    
    if (curr != null) {
      System.out.println(curr.getData());
      
      printTreePreOrder(curr.getLeft());
      
      printTreePreOrder(curr.getRight());
    }
    
  }
  
  // prints the tree inorder
  
  public void printTreeInOrder(Node curr) {
    
    if (curr != null) {
      printTreeInOrder(curr.getLeft());
      
      System.out.println(curr.getData());
      
      printTreeInOrder(curr.getRight());
    }
    
  }
  
  // prints the tree in postorder
  
  public void printTreePostOrder(Node curr) {
    
    if (curr != null) {
      printTreePostOrder(curr.getLeft());
      
      printTreePostOrder(curr.getRight());
      
      System.out.println(curr.getData());
    }
    
  }
  
  // sets a node as the root
  
  public void setRootItem(Node rootItem) {
    rootItem = root;
  }
  
  // retrieves the root of the tree
  
  public Node getRootItem() {
    return root;
  }
    
}