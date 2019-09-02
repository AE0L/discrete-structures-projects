package stack.arithmetic.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Views extends JFrame {

  private static final long serialVersionUID = 1L;

  private JTextField exprField = new JTextField();
  private JButton evalBtn = new JButton("Evaluate");
  private JTextPane postLabel = new JTextPane();

  /**
   * Constructor.
   */
  public Views() {
    this.setTitle("Arithmetic Expression");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.initialize();
    this.pack();
  }

  private void initialize() {
    JPanel main = new JPanel(new BorderLayout());

    this.postLabel.setEditable(false);
    this.exprField.setPreferredSize(new Dimension(500, 0));
    main.setBorder(new EmptyBorder(10, 10, 10, 10));

    main.add(this.exprField);
    main.add(this.evalBtn, BorderLayout.EAST);
    main.add(this.postLabel, BorderLayout.SOUTH);

    this.add(main);
  }

  public void addButtonActionListener(ActionListener action) {
    this.evalBtn.addActionListener(action);
  }

  public void setPostLabel(String text) {
    this.postLabel.setText(text);
  }

  public String getExprFieldText() {
    return this.exprField.getText();
  }
}
