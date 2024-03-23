public class Queue
{
  public void enqueue(String s)
  {
    if (head == null) 
      head = tail = new Node(s,null);
    else 
    { 
      tail.next = new Node(s,null); 
      tail = tail.next; 
    }
  }
  public String dequeue()
  { 
    Node t = head; 
    try{
      head = head.next;
       if (head == null)
      tail = null;
    }catch ( NullPointerException e){
      
      // printStackTrace method 
            // prints line numbers + call stack 
            //e.printStackTrace(); 
  
            // Prints what exception has been thrown 
            System.out.println(e); 

      //System.out.println("Error in SpecialFunc: " + e.getMessage());
    }
   
    return t.data; 
  }
  public boolean empty() { return head == null; }

  public Iter iterator() { return new Iter(head); }

  protected class Iter
  {
    private Node curr;
    public Iter(Node start) { curr = start; }
    public boolean hasNext() { return curr != null; }
    public String next() 
    { 
      String s = curr.data; 
      curr = curr.next;  
      return s; 
    }
  }

  private class Node
  {
    public String data;
    public Node next;
    public Node(String d, Node n) { data = d; next = n; }
  }
  
  private Node head = null, tail = null;
}
