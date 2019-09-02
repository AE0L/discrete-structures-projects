package stack.arithmetic;

/**
 * A class for a basic list data structure.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
public class List implements ListInterface {
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
   * {@inheritDoc}
   *
   * @see stack.arithmetic.ListInterface#isEmpty()
   */
  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * {@inheritDoc}
   *
   * @see stack.arithmetic.ListInterface#add(int, java.lang.Object)
   */
  @Override
  public void add(int pos, Object item) {
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
   * {@inheritDoc}
   *
   * @see stack.arithmetic.ListInterface#remove(int)
   */
  @Override
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
   * {@inheritDoc}
   *
   * @see stack.arithmetic.ListInterface#removeAll()
   */
  @Override
  public void removeAll() {
    this.head = null;
    this.size = 0;
  }

  /**
   * {@inheritDoc}
   *
   * @see stack.arithmetic.ListInterface#get(int)
   */
  @Override
  public Object get(int pos) {
    Node current = this.head;

    for (int i = 1; i < pos; i++) {
      current = current.getNext();
    }

    return current.getValue();
  }
}
