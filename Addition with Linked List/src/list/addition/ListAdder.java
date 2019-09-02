package list.addition;

/**
 * A class which holds the add method for adding two strings of long integers.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
class ListAdder extends Converter {

  /**
   * Add two numbers.
   *
   * Converts two strings into a linked list then add them.
   *
   * @param num1 first number
   * @param num2 second number
   * @return sum in String type
   * @see Converter#toLinkedList
   * @author JIMENEZ, Carl Justin
   * @author CHUA, Orjan
   */
  static String add(String num1, String num2) {
    LinkedList listNum1;
    LinkedList listNum2;
    LinkedList sum = new LinkedList();
    int carry = 0;
    int temp;
    int pos1 = 1;
    int pos2 = 1;

    /* place the longest number on variable num1 */
    if (num1.length() >= num2.length()) {
      listNum1 = toLinkedList(num1);
      listNum2 = toLinkedList(num2);
    } else {
      listNum1 = toLinkedList(num2);
      listNum2 = toLinkedList(num1);
    }

    /* Algorithm to add two linked list */
    while (pos1 <= listNum1.getSize()) {
      if (pos2 <= listNum2.getSize()) {
        temp = listNum1.get(pos1) + listNum2.get(pos2);
      } else {
        temp = listNum1.get(pos1);
      }

      if (carry != 0) {
        temp += carry;
        carry = 0;
      }

      if (temp >= 10) {
        temp -= 10;
        carry = 1;
      }

      sum.add(temp);
      ++pos1;
      ++pos2;
    }

    return sum.toString();
  }
}
