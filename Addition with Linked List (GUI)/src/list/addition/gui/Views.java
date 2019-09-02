package list.addition.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Views extends JFrame {
  private static final long serialVersionUID = 1L;

  private final JTextField numField1 = new JTextField();
  private final JTextField numField2 = new JTextField();
  private final JTextField sumField = new JTextField();
  private final JButton addBtn = new JButton("Add");

  Views() {
    this.setTitle("Linked List Addition");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.initialize();
    this.pack();
  }

  private void initialize() {
    JPanel main = new JPanel(new BorderLayout());
    JPanel numbers = new JPanel(new BorderLayout());

    this.numField1.setHorizontalAlignment(JTextField.RIGHT);
    this.numField2.setHorizontalAlignment(JTextField.RIGHT);
    this.sumField.setHorizontalAlignment(JTextField.RIGHT);
    this.sumField.setEditable(false);

    this.numField1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
    this.numField2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
    this.sumField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

    numbers.add(this.numField1, BorderLayout.NORTH);
    numbers.add(this.numField2);
    numbers.add(this.sumField, BorderLayout.SOUTH);

    main.add(numbers);
    main.add(this.addBtn, BorderLayout.EAST);

    this.add(main);
  }

  String getNumField1Text() {
    return this.numField1.getText();
  }

  String getNumField2Text() {
    return this.numField2.getText();
  }

  void setSumField(String text) {
    this.sumField.setText(text);
  }

  void addButtonActionListener(ActionListener action) {
    this.addBtn.addActionListener(action);
  }
}
