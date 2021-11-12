
public class Node {

    Product info;
    Node next;
   
    public Node() {}
  
    public Node(Product info, Node next) {
        this.info = info;
        this.next = next; 
    }
    public Node(Node next, Product info) {
        this.next = next; 
        this.info = info;
    }
    public Node(Product x) {
        this(x,null);
    }
   
    
    
}