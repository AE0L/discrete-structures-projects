package list.addition;

/**
 * Holds the toLinkedList method which is important in the program.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
class Converter {

  /**
   * String to Linked List.
   *
   * <p>
   * Converts each character digit into type integer then makes the last digit as the head and add
   * the following digits until the first character digit.
   * </p>
   *
   * @param numString the number string to be converted
   * @return a linked list that holds the digits of the number
   * @author JIMENEZ, Carl Justin
   * @author CHUA, Orjan
   */
  static LinkedList toLinkedList(String numString) {
    int last = numString.length() - 1;
    LinkedList list = new LinkedList();

    /* Starts from the last up to the first one */
    for (int i = last; i >= 0; i--) {
      list.add(toInt(numString, i));
    }

    return list;
  }

  /**
   * Character to Integer.
   *
   * <p>
   * Utility method to convert character digit into type integer.
   * </p>
   *
   * @param num the number string
   * @param pos position of character digit to be converted
   * @return digit of type integer
   * @author JIMENEZ, Carl Justin
   * @author CHUA, Orjan
   */
  private static int toInt(String num, int pos) {
    return Character.getNumericValue(num.charAt(pos));
  }
}
