package stack.arithmetic.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import stack.arithmetic.Expression;

public class Controller {
  private final Views view;

  public Controller() {
    this.view = new Views();
    this.addActionListeners();
  }

  private void addActionListeners() {
    this.view.addButtonActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        String text = view.getExprFieldText();

        if (text != "") {
          Expression inFix = new Expression(text);
          try {
            String postFix = inFix.toPostFix();
            view.setPostLabel("PostFix: " + postFix + "\nAnswer: " + inFix.evaluate());
            view.pack();
          } catch (Exception ex) {
            view.setPostLabel("Invalid or incomplete expression, please try again...");
          }
        }
      }

    });
  }

  public void start() {
    this.view.setVisible(true);
  }
}
