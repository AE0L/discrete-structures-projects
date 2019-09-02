package stack.arithmetic;

/**
 * Provides basic methods for a list data structure.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
public interface ListInterface {
  /**
   * Checks the list's size.
   *
   * @return true if list size is zero, otherwise false.
   */
  public boolean isEmpty();

  /**
   * Adds new a new node.
   *
   * @param pos position of the new node in the list.
   * @param item value of the new node.
   */
  public void add(int pos, Object item);

  /**
   * Removes a node in the list.
   *
   * @param pos position of node to be removed.
   */
  public void remove(int pos);

  /**
   * Clears the list.
   */
  public void removeAll();

  /**
   * Gets the value of a given node.
   *
   * @param pos position of node to be accessed.
   * @return value of node accessed.
   */
  public Object get(int pos);
}
