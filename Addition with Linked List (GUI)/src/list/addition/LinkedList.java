package list.addition;

/**
 * Holds a number of nodes and makes a connections between them.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
class LinkedList {

  private Node head;
  private int size;

  LinkedList() {
    this.head = null;
    this.size = 0;
  }

  /**
   * Add item.
   *
   * <p>
   * Adds a new node at the tail of the list.
   * </p>
   *
   * @param value the value of the new node.
   * @author JIMENEZ, Carl Justin
   * @author CHUA, Orjan
   */
  void add(int value) {
    Node current = this.head;
    Node newNode = new Node(value);

    if (current == null) {
      this.head = newNode;
      ++this.size;
      return;
    }

    while (current.hasNext()) {
      current = current.getNext();
    }

    current.setNext(newNode);
    ++this.size;
  }

  /**
   * Get item.
   *
   * <p>
   * Gets the value of a specific node.
   * </p>
   *
   * @param pos position of node to access
   * @return value of the node accessed
   * @author JIMENEZ, Carl Justin
   * @author CHUA, Orjan
   */
  int get(int pos) {
    if (pos <= 0) {
      return -1;
    }

    Node current = this.head;

    for (int i = 1; i < pos; i++) {
      current = current.getNext();
    }

    return current.getValue();
  }

  /**
   * LinkedList to String.
   *
   * <p>
   * Makes a string representation of the values of the list starting from the tail to the head.
   * </p>
   *
   * @return the values of the list in string type.
   * @author JIMENEZ, Carl Justin
   * @author CHUA, Orjan
   */
  @Override
  public String toString() {
    StringBuilder text = new StringBuilder();

    for (int i = 1; i <= getSize(); i++) {
      text.insert(0, get(i));
    }

    return text.toString();
  }

  int getSize() {
    return this.size;
  }
}
