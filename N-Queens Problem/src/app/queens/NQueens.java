package app.queens;

/**
 * A class that solves the N-Queens Problem.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class NQueens {

  /**
   * Solves the N-Queens problem using stack.
   *
   * @param n size of board
   * @throws Exception when an invalid stack access was done.
   */
  public static void solve(int n) throws Exception {
    Stack sol = new Stack();
    boolean success = false;

    sol.push(new int[] {1, 1});

    while (!success && !sol.isEmpty()) {
      int[] curr = sol.peek();
      if (hasConflict(curr, sol, n)) {
        curr = sol.pop();

        while (curr[1] == n) {
          try {
            curr = sol.pop();
          } catch (Exception e) {
            System.out.println("No Solution!");
            return;
          }
        }

        curr[1] += 1;

        sol.push(curr);

      } else if (!hasConflict(curr, sol, n) && sol.length() == n) {
        printSolution(sol);
        success = true;
      } else {
        sol.push(new int[] {sol.length() + 1, 1});
      }
    }
  }

  /**
   * checks the top of the stack if it has any conflict below it.
   *
   * @param tile current tile solution
   * @param stack all the solutions found so far
   * @param n size of the board
   * @return true if conflict was found, otherwise false
   * @throws Exception when an invalid stack access was done
   */
  private static boolean hasConflict(int[] tile, Stack stack, int n) throws Exception {
    int size = stack.length();
    int[] curr = new int[2];
    int[][] copy = new int[size][2];
    int index = size - 2;

    if (size == 1) {
      return false;
    } else {
      /* Create an array type clone of the stack */
      for (int i = size - 1; i >= 0; i--) {
        copy[i] = stack.pop();
      }

      while (index >= 0) {
        curr = copy[index];

        /* Checks row and columns for conflict */
        if (curr[0] == tile[0] || curr[1] == tile[1]) {
          restore(stack, copy);
          return true;
        }

        /* Check upper-right diagonal */
        for (int r = curr[0], c = curr[1]; r <= n && c <= n; r++, c++) {
          if (r == tile[0] && c == tile[1]) {
            restore(stack, copy);
            return true;
          }
        }

        /* Check upper-left diagonal */
        for (int r = curr[0], c = curr[1]; r <= n && c >= 1; r++, c--) {
          if (r == tile[0] && c == tile[1]) {
            restore(stack, copy);
            return true;
          }
        }

        /* Check lower-left diagonal */
        for (int r = curr[0], c = curr[1]; r >= 1 && c >= 1; r--, c--) {
          if (r == tile[0] && c == tile[1]) {
            restore(stack, copy);
            return true;
          }
        }

        /* Check lower-left diagonal */
        for (int r = curr[0], c = curr[1]; r >= 1 && c <= n; r--, c++) {
          if (r == tile[0] && c == tile[1]) {
            restore(stack, copy);
            return true;
          }
        }

        index--;
      }
    }

    restore(stack, copy);
    return false;
  }

  /**
   * Show the position of the queens in the solution found.
   *
   * @param sol the solution
   * @throws Exception when invalid stack access was done
   */
  private static void printSolution(Stack sol) throws Exception {
    System.out.println("Solution:\n");

    int size = sol.length();

    while (!sol.isEmpty()) {
      int[] curr = sol.pop();

      for (int i = 1; i <= size; i++) {
        if (i == curr[1]) {
          System.out.print("[Q]");
        } else {
          System.out.print("[ ]");
        }
      }
      System.out.println("\n");
    }
  }

  /**
   * Restore the contents of the stack.
   *
   * @param stack the stack to be restored
   * @param copy the copy of the original elements of the stack
   */
  private static void restore(Stack stack, int[][] copy) {
    for (int i = 0; i < copy.length; i++) {
      stack.push(copy[i]);
    }
  }
}
