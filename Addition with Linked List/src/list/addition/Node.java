package list.addition;

/**
 * A class which can hold a value and can also hold a connection/link to another node.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
class Node {

  private final int value;
  private Node next;

  Node(int value) {
    this.value = value;
  }

  /**
   * Check next node.
   *
   * Checks if the node has a connection to another node.
   *
   * @return true if there is a node connection, otherwise false.
   * @author JIMENEZ, Carl Justin
   * @author CHUA, Orjan
   */
  boolean hasNext() {
    return this.next != null;
  }

  int getValue() {
    return value;
  }

  Node getNext() {
    return next;
  }

  void setNext(Node next) {
    this.next = next;
  }
}
