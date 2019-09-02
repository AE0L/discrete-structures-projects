package aeol.datastruct;

public class Stack<E> {
  List<E> list;

  public Stack() {
    this.list = new List<>();
  }

  public E pop() throws StackException {
    E value;

    if (this.size() == 0) {
      throw new StackException("empty stack");
    } else {
      try {
        value = this.list.get(this.size() - 1);
        this.list.remove(this.size() - 1);
      } catch (ListException e) {
        throw new StackException("cant access stack element");
      }

      return value;
    }
  }

  public void push(E value) {
    this.list.add(value);
  }

  public E peek() throws StackException {
    E value;

    if (this.size() == 0) {
      throw new StackException("empty stack");
    } else {
      try {
        value = this.list.get(this.size() - 1);
      } catch (ListException e) {
        throw new StackException();
      }

      return value;
    }
  }

  public int size() {
    return this.list.getSize();
  }

  public void clear() {
    this.list = new List<>();
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

}
