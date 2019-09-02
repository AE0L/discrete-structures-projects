package stack.arithmetic;

/**
 * A class for a infix expression.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan Section: BSCS 2-2
 * @section BSCS 2-2
 */
public class Expression implements ExpressionInterface {
  private String expr;
  private final char[] validOperators = {'+', '-', '/', '%', '*', '^'};

  public Expression(String expr) {
    this.expr = removeWhitespace(expr);
  }

  /**
   * Filter the expression for whitespace characters.
   *
   * @param expr the expression to be filtered.
   * @return expression with no whitespace characters.
   */
  public String removeWhitespace(String expr) {
    String temp = "";

    for (int i = 0; i < expr.length(); i++) {
      char curr = expr.charAt(i);
      if (Character.isWhitespace(curr)) {
        continue;
      } else {
        temp = temp.concat(charToString(curr));
      }
    }

    return temp;
  }

  /**
   * Infix to Postfix.
   *
   * Converts infix expression to postfix using stacks.
   *
   * @return converted expression.
   * @throws Exception when invalid stack method was done.
   */
  public String toPostFix() throws Exception {
    String postFixExpr = "";
    Stack op = new Stack();

    for (int i = 0; i < this.expr.length(); i++) {
      char curr = this.expr.charAt(i);

      if (isOperand(curr)) {
        String digit = "";
        digit = digit.concat(charToString(curr));

        int j = i + 1;

        while (j < expr.length() && isOperand(this.expr.charAt(j))) {
          digit = digit.concat(charToString(this.expr.charAt(j)));
          j++;
          i++;
        }

        postFixExpr = postFixExpr.concat(digit + " ");
      } else if (curr == '(') {
        op.push(curr);
      } else if (curr == ')') {
        while ((Character) op.peek() != '(') {
          postFixExpr = postFixExpr.concat(charToString((Character) op.pop()) + " ");
        }
        op.pop();
      } else if (isOperator(curr)) {
        while (!op.isEmpty() && (Character) op.peek() != '('
            && precedence(curr) <= precedence((Character) op.peek())) {
          postFixExpr = postFixExpr.concat(charToString((Character) op.pop()) + " ");
        }

        op.push(curr);
      }
    }

    while (!op.isEmpty()) {
      postFixExpr = postFixExpr.concat(charToString((Character) op.pop()) + " ");
    }

    return postFixExpr;
  }

  /**
   * Character to String.
   *
   * Utility method for converting a character to String.
   *
   * @param ch character to be converted.
   * @return converted character.
   */
  private String charToString(char ch) {
    return Character.toString(ch);
  }

  /**
   * @see stack.arithmetic.ExpressionInterface#isOperand(char)
   */
  @Override
  public boolean isOperand(char ch) {
    return Character.isDigit(ch);
  }

  /**
   * @see stack.arithmetic.ExpressionInterface#isOperator(char)
   */
  @Override
  public boolean isOperator(char ch) throws Exception {
    for (int i = 0; i < this.validOperators.length; i++) {
      if (this.validOperators[i] == ch) {
        return true;
      }
    }

    throw new Exception("EvaluationException: invalid operator...");
  }

  /**
   * @see stack.arithmetic.ExpressionInterface#precedence(char)
   */
  @Override
  public int precedence(char op) {
    switch (op) {
      case '+':
        return 1;
      case '-':
        return 1;
      case '/':
        return 2;
      case '%':
        return 2;
      case '*':
        return 2;
      case '^':
        return 3;
      default:
        break;
    }

    return 0;
  }

  /**
   * @see stack.arithmetic.ExpressionInterface#evaluate()
   */
  @Override
  public double evaluate() throws Exception {
    Stack stack = new Stack();
    String postFix = this.toPostFix();

    for (int i = 0; i < postFix.length(); i++) {
      char curr = postFix.charAt(i);

      if (isOperand(curr)) {
        String digit = "";
        digit = digit.concat(charToString(curr));

        int j = i + 1;

        while (j < postFix.length() && isOperand(postFix.charAt(j))) {
          digit = digit.concat(charToString(postFix.charAt(j)));
          j++;
          i++;
        }

        stack.push(Double.parseDouble(digit));
      } else if (Character.isWhitespace(curr)) {
        continue;
      } else {
        double operand1 = 0;
        double operand2 = 0;

        try {
          operand1 = (Double) stack.pop();
          operand2 = (Double) stack.pop();
        } catch (Exception e) {
          System.err.println(e.getMessage());
          System.err.println("Probable cause: incomplete or invalid expression");

          throw new Exception();
        }

        switch (postFix.charAt(i)) {
          case '+':
            stack.push(operand2 + operand1);
            break;
          case '-':
            stack.push(operand2 - operand1);
            break;
          case '/':
            stack.push(operand2 / operand1);
            break;
          case '%':
            stack.push(operand2 % operand1);
            break;
          case '*':
            stack.push(operand2 * operand1);
            break;
          case '^':
            stack.push(Math.pow(operand2, operand1));
            break;
          default:
            break;
        }
      }
    }

    return (Double) stack.pop();
  }

  @Override
  public String toString() {
    return this.expr;
  }
}
