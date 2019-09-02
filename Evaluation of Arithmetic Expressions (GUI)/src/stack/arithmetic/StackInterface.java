package stack.arithmetic;

/**
 * Consist of basic methods for a stack.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
public interface StackInterface {
  /**
   * Checks the stack size.
   *
   * @return true if stack size is zero, otherwise false.
   */
  public boolean isEmpty();

  /**
   * Add an item on top of the stack.
   *
   * @param item the object to be added.
   */
  public void push(Object item);

  /**
   * Removes the item on top of the stack and return it.
   *
   * @return the item on top of the stack.
   * @throws Exception when stack is empty.
   */
  public Object pop() throws Exception;

  /**
   * Clears the stack.
   */
  public void popAll();

  /**
   * Checks the item on top of the stack.
   *
   * @return the value of the item on top of the stack.
   * @throws Exception when stack is empty.
   */
  public Object peek() throws Exception;
}
