package list.addition.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import list.addition.ListAdder;

public class Controller {
  private final Views view;

  public Controller() {
    this.view = new Views();
    this.addActionListener();
  }

  private void addActionListener() {
    this.view.addButtonActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        String num1 = view.getNumField1Text();
        String num2 = view.getNumField2Text();

        try {
          Double.parseDouble(num1);
          Double.parseDouble(num2);
          String sum = ListAdder.add(num1, num2);
          view.setSumField(sum);
          view.pack();
        } catch (NumberFormatException e) {
          view.setSumField("Invalid input, please try again...");
        }
      }
    });
  }

  public void start() {
    this.view.setVisible(true);
  }
}
