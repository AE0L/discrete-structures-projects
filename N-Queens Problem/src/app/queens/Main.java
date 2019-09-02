package app.queens;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * N-Queens Problem.
 * 
 * A java program solves a N-Queens problem which states that for a given N of a N x N board, find
 * all the possible positions of all N numbers of queens in the board where not one of them are on
 * the same rank(horizontal), file(vertical), and diagonal tiles. In simple terms, not one of them
 * capture another queen. The program uses the concept of backtracking while using stacks for easier
 * access to the solutions.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class Main {

  /**
   * Main method.
   *
   * @param args program's arguments
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("N-Queens Problem\n");
    System.out.print("Enter value of N for the N x N chess board: ");

    try {
      int n = input.nextInt();
      NQueens.solve(n);
    } catch (InputMismatchException e) {
      System.err.println("\nError on input: type mismatch...");
    } catch (Exception e) {
      System.err.println("\nError on evaluation: logic error...");
    } finally {
      System.out.println("\nExiting...");
      input.close();
    }
  }
}
