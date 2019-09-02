package app.queens;

/**
 * A class for a basic stack data structure.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
public class Stack implements Cloneable {
  List list;

  public Stack() {
    list = new List();
  }

  /**
   * Checks if stack is empty.
   *
   * @return true if stack is empty, otherwise false
   */
  public boolean isEmpty() {
    return list.isEmpty();
  }

  /**
   * Add item on top of the stack.
   *
   * @param item item to be added
   */
  public void push(int[] item) {
    list.add(1, item);
  }

  /**
   * Remove item on top of the stack and return it.
   *
   * @return item popped
   * @throws Exception when stack is empty
   */
  public int[] pop() throws Exception {
    if (!isEmpty()) {
      int[] popped = list.get(1);
      list.remove(1);

      return popped;
    } else {
      throw new Exception("StackException: stack is empty");
    }
  }

  /**
   * Clears the stack.
   */
  public void popAll() {
    list.removeAll();
  }

  /**
   * Return the top of the stack.
   *
   * @return the value of the item on top of the stack
   * @throws Exception when stack is empty
   */
  public int[] peek() throws Exception {
    if (!isEmpty()) {
      return list.get(1);
    } else {
      throw new Exception("StackException: stack is empty");
    }
  }

  /**
   * Return the stack's size.
   *
   * @return the current size of the stack
   */
  public int length() {
    return list.getSize();
  }
}
