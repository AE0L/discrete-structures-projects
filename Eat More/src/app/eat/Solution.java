package app.eat;

/**
 * Holds necessary values for a solution to the Eat more problem.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class Solution {
  private final Queue popCornHistory;
  private final Queue sodaHistory;
  private final Queue hotDogHistory;
  private final int maxMinutes;
  private final double c1min;
  private final double c2min;
  private final double c3min;
  private final double average;
  private final String priority;

  Solution(Queue popCornHistory, Queue sodaHistory, Queue hotDogHistory, int maxMinutes,
      double cstmr1Min, double cstmr2Min, double cstmr3Min, String priority) {
    this.popCornHistory = popCornHistory;
    this.sodaHistory = sodaHistory;
    this.hotDogHistory = hotDogHistory;
    this.maxMinutes = maxMinutes;
    this.c1min = cstmr1Min;
    this.c2min = cstmr2Min;
    this.c3min = cstmr3Min;
    this.priority = priority;
    this.average = calculateAverage();
  }

  /**
   * Calculate the average time in queue of all the customers.
   * 
   * @return - the computed average
   */
  private double calculateAverage() {
    return (this.c1min + this.c2min + this.c3min) / 3;
  }

  public double getAverage() {
    return this.average;
  }

  /**
   * Prints the solution.
   * 
   * @throws Exception when a invalid queue operation was done
   */
  public void printSolution() throws Exception {
    System.out.println("(Store priority: " + this.priority + "):");
    for (int i = 1; i <= this.maxMinutes; i++) {
      int popCorn = this.popCornHistory.dequeue().getValue(),
          soda = this.sodaHistory.dequeue().getValue(),
          hotDog = this.hotDogHistory.dequeue().getValue();

      System.out.println(
          ((i < 10) ? "min " + i + ":  " : "min " + i + ": ") + (popCorn != 0 ? popCorn : "*") + " "
              + (soda != 0 ? soda : "*") + " " + (hotDog != 0 ? hotDog : "*"));
    }

    int min = 0, sec = 0;
    double avg = (c1min + c2min + c3min) / 3;
    min = (int) avg;
    sec = (int) Math.ceil((avg % 1) * 60);

    System.out.printf("\nAverage time in queue: (%d + %d + %d) / 3 = %d minutes", (int) c1min,
        (int) c2min, (int) c3min, min);
    if (sec != 0) {
      System.out.println(" and " + sec + " seconds");
    } else {
      System.out.println("");
    }
  }
}
