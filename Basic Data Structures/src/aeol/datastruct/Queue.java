package aeol.datastruct;

public class Queue<E> {
  List<E> list;

  public Queue() {
    this.list = new List<>();
  }

  public void enqueue(E value) {
    this.list.add(value);
  }

  public E dequeue() throws QueueException {
    if (this.isEmpty()) {
      throw new QueueException("empty queue");
    } else {
      E value = null;

      try {
        value = this.list.get(0);
        this.list.remove(0);
      } catch (ListException e) {
        throw new QueueException("can't access element");
      }

      return value;
    }
  }

  public E front() throws QueueException {
    if (this.isEmpty()) {
      throw new QueueException("empty queue");
    } else {
      try {
        return this.list.get(0);
      } catch (ListException e) {
        throw new QueueException("can't access element");
      }
    }
  }

  public E back() throws Exception {
    if (this.isEmpty()) {
      throw new QueueException("empty queue");
    } else {
      try {
        return this.list.get(this.size() - 1);
      } catch (ListException e) {
        throw new QueueException("can't access element");
      }
    }
  }

  public void clear() {
    this.list = new List<>();
  }

  public int size() {
    return this.list.getSize();
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  @Override
  public String toString() {
    String str = "[";
    E curr = null;

    for (int i = 0; i < this.size(); i++) {
      try {
        curr = this.list.get(i);
      } catch (ListException ignore) {
      }

      str = str.concat(curr.toString());

      if (i == this.size() - 1) {
        str = str.concat("]");
      } else {
        str = str.concat(", ");
      }
    }

    return str;
  }

}
