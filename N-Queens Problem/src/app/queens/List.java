package app.queens;

/**
 * A class for a basic list data structure.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
public class List {
  private int size;
  private Node head;

  public List() {
    this.size = 0;
    this.head = null;
  }

  public List(Node head) {
    this.size = 1;
    this.head = head;
  }

  /**
   * Checks if list is empty.
   *
   * @return true if list is empty, otherwise false
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Add item on the list and link it to the node before it.
   *
   * @param pos position of the new item
   * @param item item to be added
   */
  public void add(int pos, int[] item) {
    Node current = this.head;
    Node temp = null;

    if (pos == 1) {
      this.head = new Node(item);
      this.head.setNext(current);
      this.size += 1;

      return;
    } else {
      for (int i = 1; i < (pos - 1); i++) {
        current = current.getNext();
        temp = current.getNext();
      }

      current.setNext(new Node(item));
      current.getNext().setNext(temp);
    }

    this.size += 1;
  }

  /**
   * Remove item at given position.
   *
   * @param pos position of the item to be removed
   */
  public void remove(int pos) {
    Node current = this.head;

    if (pos == 1) {
      this.head = current.getNext();
    } else {
      for (int i = 1; i < (pos - 1); i++) {
        current = current.getNext();
      }

      current.setNext(current.getNext().getNext());
    }

    this.size -= 1;
  }

  /**
   * Clears the list.
   */
  public void removeAll() {
    this.head = null;
    this.size = 0;
  }

  /**
   * Gets the item at the given position.
   *
   * @param pos position of the item to be accessed
   * @return the value of the item accessed
   */
  public int[] get(int pos) {
    Node current = this.head;

    for (int i = 1; i < pos; i++) {
      current = current.getNext();
    }

    return current.getValue();
  }

  /**
   * Return the list's size.
   *
   * @return the current size of the list.
   */
  public int getSize() {
    return this.size;
  }
}
