package stack.arithmetic;

/**
 * A class for a basic stack data structure.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
public class Stack implements StackInterface {
  ListInterface list;

  public Stack() {
    list = new List();
  }

  public Stack(Object item) {
    list = new List(new Node(item));
  }

  /**
   * @see stack.arithmetic.StackInterface#isEmpty()
   */
  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  /**
   * @see stack.arithmetic.StackInterface#push(java.lang.Object)
   */
  @Override
  public void push(Object item) {
    list.add(1, item);
  }

  /**
   * @see stack.arithmetic.StackInterface#pop()
   */
  @Override
  public Object pop() throws Exception {
    if (!isEmpty()) {
      Object popped = list.get(1);
      list.remove(1);

      return popped;
    } else {
      throw new Exception("StackException: stack is empty");
    }
  }

  /**
   * @see stack.arithmetic.StackInterface#popAll()
   */
  @Override
  public void popAll() {
    list.removeAll();
  }

  /**
   * @see stack.arithmetic.StackInterface#peek()
   */
  @Override
  public Object peek() throws Exception {
    if (!isEmpty()) {
      return list.get(1);
    } else {
      throw new Exception("StackException: stack is empty");
    }
  }

}
