package app.eat;

/**
 * Node class.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class Node {
  private int value;
  private Node next;

  Node(int value) {
    this.value = value;
    this.next = null;
  }

  public Node getNext() {
    return this.next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
