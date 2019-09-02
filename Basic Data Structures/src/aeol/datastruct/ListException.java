package aeol.datastruct;

public class ListException extends Exception {

  private static final long serialVersionUID = -4777666542735768455L;
  private String msg;

  ListException() {}

  ListException(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "ListException: " + this.msg;
  }

}
