package app.eat;

import java.util.Scanner;

/**
 * Eat more problem.
 * 
 * A java program that finds two possible solutions to decrease the queue time of customers when
 * ordering on 3 different stores.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class Main {

  /**
   * Main method.
   * 
   * @param args - application arguments
   */
  public static void main(String[] args) {
    Customer customer1, customer2, customer3;
    Scanner input = new Scanner(System.in);

    try {
      System.out.print("First Customer (P / S / H):  ");
      customer1 = new Customer(input.nextInt(), input.nextInt(), input.nextInt(), 1);
      System.out.print("Second Customer (P / S / H): ");
      customer2 = new Customer(input.nextInt(), input.nextInt(), input.nextInt(), 2);
      System.out.print("Third Customer (P / S / H):  ");
      customer3 = new Customer(input.nextInt(), input.nextInt(), input.nextInt(), 3);

      Solver.solve(customer1, customer2, customer3);

    } catch (Exception e) {
      System.out.println("ERROR: input error, please try again...");
      System.out.println("Exiting...");
      System.exit(0);
    } finally {
      input.close();
    }
  }

}
