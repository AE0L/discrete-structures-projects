package aeol.datastruct;

public class QueueException extends Exception {

  private static final long serialVersionUID = 14169255878377691L;

  private String msg;

  public QueueException(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "QueueException: " + this.msg;
  }

}
