package app.stringmatch;

import java.util.Scanner;

/**
 * A java program that reads a file then find the number of occurrences of a pattern.
 *
 * @author JIMENEZ, Carl Justin.
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class MP01_1 {
  public static void main(String[] args) {
    String ans;

    do {
      System.out.print("\nEnter filename: ");
      String file = enter();

      /* Reads the content of file */
      FileReader fr = new FileReader(file);
      String content = fr.read();

      /* If file reading is successful display contents and ask for pattern */
      if (null != content) {
        System.out.println("\nFile contents: \n" + content);

        System.out.print("\nEnter pattern: ");
        String pattern = enter();

        StringMatch string = new StringMatch(content);
        int occurences = string.find(pattern);

        if (occurences != 0) {
          System.out.println("Pattern is found " + occurences + " times.");
        } else {
          System.out.println("No matches found!");
        }
      }

      System.out.print("\nSearch again? (y/n): ");
      ans = enter();
    } while (ans.equals("Y") || ans.equals("y"));
  }

  /**
   * Gets user input.
   *
   * @return user input
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
