package BinaryTree;

public class Node {
  
  public int data;
  public Node leftNode;
  public Node rightNode;
  
  public Node(int data) {
    
    this.data = data;
    
  }
  
  public void setLeft(Node leftNode) {
    this.leftNode = leftNode; 
  }
  
  public void setRight(Node rightNode) {
    this.rightNode = rightNode; 
  }
  
  public Node getLeft() {
    return leftNode;
  }
  
  public Node getRight() {
    return rightNode;
  }
  
  public int getData() {
    return data;
  }
  
}