package stack.arithmetic;

import stack.arithmetic.gui.Controller;

/**
 * <p>
 * A java program that evaluates a infix expression provided by the user by converting it into a
 * postfix expression for easier evaluation. This program works with multiple digits and only
 * supports the following operators:
 * </p>
 *
 * <ul>
 * <li>(+) Addition</li>
 * <li>(-) Subtraction</li>
 * <li>(*) Multiplication</li>
 * <li>(/) Division</li>
 * <li>(%) Modulus</li>
 * <li>(^) Exponential</li>
 * </ul>
 *
 * <p>
 * The program also disregard whitespace characters between 2 or more digits and evaluate them as
 * one digit.
 * </p>
 *
 * <em>Update</em>
 * <ul>
 * <li>Now has a GUI</li>
 * </ul>
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 * @version 2.0.0
 */
public class MP01_3 {
  /**
   * Main method.
   *
   * @param args program's arguments
   */
  public static void main(String[] args) {
    Controller app = new Controller();
    app.start();
  }
}
