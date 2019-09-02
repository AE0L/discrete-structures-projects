package aeol.datastruct;

public class StackException extends Exception {

  private static final long serialVersionUID = -2684262613521118833L;

  private String msg;

  StackException() {}

  StackException(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "ListException: " + this.msg;
  }

}
