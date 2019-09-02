package stack.arithmetic;

import java.util.Scanner;

/**
 * Evaluation of Arithmetic Expressions.
 * 
 * A java program that evaluates a infix expression provided by the user by converting it into a
 * postfix expression for easier evaluation. This program works with multiple digits and only
 * supports the following operators:
 *
 * - (+) Addition - (-) Subtraction - (*) Multiplication - (/) Division - (%) Modulus - (^)
 * Exponential
 *
 * The program also disregard whitespace characters between 2 or more digits and evaluate them as
 * one digit.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan Section: BSCS 2-2
 * @section BSCS 2-2
 */
public class Main {
  /**
   * Main method.
   *
   * @param args program's arguments
   */
  public static void main(String[] args) {
    System.out.print("Enter a valid infix expression: ");
    Expression expr = new Expression(enter());

    try {
      String postFix = expr.toPostFix();
      System.out.println("Postfix equivalent: " + postFix);
      System.out.print("Answer is: " + expr.evaluate());
    } catch (Exception e) {
      System.err.println("Please try again, exiting...");
      System.exit(-1);
    }
  }

  /**
   * Utility method for user input.
   *
   * @return use input
   */
  private static String enter() {
    Scanner input = new Scanner(System.in);
    String text = "";

    try {
      text = input.nextLine();
    } finally {
      input.close();
    }

    return text;
  }
}
