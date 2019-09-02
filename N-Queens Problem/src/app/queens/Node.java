package app.queens;

/**
 * Holds a value and a link to another node.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
public class Node {
  private int[] value;
  private Node next;

  public Node(int[] value) {
    this.value = value;
    this.next = null;
  }

  public Node(int[] value, Node next) {
    this.value = value;
    this.next = next;
  }

  /**
   * Removes the link to next node.
   */
  void unlinkNext() {
    this.next = null;
  }

  /**
   * Clears the value of the node.
   */
  void clearValue() {
    this.value = null;
  }

  void setValue(int[] value) {
    this.value = value;
  }

  void setNext(Node next) {
    this.next = next;
  }

  int[] getValue() {
    return this.value;
  }

  Node getNext() {
    return this.next;
  }
}
