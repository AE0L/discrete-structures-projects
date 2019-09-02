package app.president;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * A java program that displays the advisers which were selected in the order that they were
 * selected each separated by a comma and space.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section: BSCS 2-2
 */
public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Queue<Integer> advisors = new LinkedList<>();
    int start, interval;
    int j = 0;

    while (true) {
      System.out.print("\nEnter Start Number   : ");
      start = input.nextInt();

      if (start == 0)
        break;

      System.out.print("Enter Interval Number: ");
      interval = input.nextInt();


      for (int i = 0; i <= 12; i++) {
        advisors.add(i + 1);
      }

      while (start != advisors.peek()) {
        j = advisors.remove();
        advisors.add(j);
      }

      System.out.print("\nChosen Advisers      :");

      for (int i = 0; i < 5; i++) {
        for (int k = 0; k < interval; k++) {
          if (k == interval - 1) {
            j = advisors.remove();
          } else {
            j = advisors.remove();
            advisors.add(j);
          }
        }

        System.out.print(" " + j);
        if (i != 4) {
          System.out.print(",");
        }
      }

      System.out.println("");
    }

    input.close();
  }
}
