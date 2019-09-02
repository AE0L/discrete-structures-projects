/**
 * Source code of the class FileReader
 */
package app.stringmatch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A utility class for reading a file and getting it's contents.
 *
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 */
class FileReader {
  String fileName;

  FileReader(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Reads the contents of the file.
   * 
   * @return contents of file
   */
  String read() {
    try {
      FileInputStream is = new FileInputStream(this.fileName);
      BufferedReader buf = new BufferedReader(new InputStreamReader(is));

      String line = "";
      String content = "";

      try {
        line = buf.readLine();
        content = line;

        while (line != null) {
          content.concat(line);
          line = buf.readLine();
        }

        buf.close();
        return content;
      } catch (IOException e) {
        System.err.println("Error: can't read file...");
      }

    } catch (FileNotFoundException e) {
      System.err.println("Error: file not found...");
    }

    return null;
  }
}
