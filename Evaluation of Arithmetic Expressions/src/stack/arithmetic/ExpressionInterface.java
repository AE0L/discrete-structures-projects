package stack.arithmetic;

/**
 * Basic methods for a expression.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
public interface ExpressionInterface {
  /**
   * Evaluate the expression.
   *
   * @return result of the expression's evaluation.
   * @throws Exception when an invalid stack access was done.
   */
  public double evaluate() throws Exception;

  /**
   * Checks if character is a valid digit.
   *
   * @param ch character to be checked.
   * @return true if character is a digit, otherwise false.
   */
  public boolean isOperand(char ch);

  /**
   * Checks if character is one of the valid operator.
   *
   * @param ch character to be processed.
   * @return true if character is one of the valid operator, otherwise false.
   * @throws Exception when an invalid operator was detected.
   */
  public boolean isOperator(char ch) throws Exception;

  /**
   * Checks the precedence of the given operator using the PEMDAS rule.
   *
   * @param op the operator to be checked.
   * @return the precedence level of the operator.
   */
  public int precedence(char op);
}
