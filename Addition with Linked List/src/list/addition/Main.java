package list.addition;

import java.util.Scanner;

/**
 * Addition with Linked List.
 * 
 * A java program that utilizes linked list to add two integers with long number of digits which is
 * currently not supported by primitive data types except the double & float.
 * 
 * @author JIMENEZ, Carl Justin P.
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
public class Main {

  /**
   * Main method.
   *
   * @param args program's arguments
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String num1;
    String num2;

    try {
      System.out.println("Long Numbers Addition\n");
      System.out.print("Enter 1st number: ");
      num1 = input.next();
      System.out.print("Enter 2nd number: ");
      num2 = input.next();
    } finally {
      input.close();
    }

    String sum = ListAdder.add(num1, num2);
    System.out.println("\nThe sum is: " + sum);
  }
}
