package aeol.datastruct;

import java.util.Iterator;

public class List<E> implements Iterable<E> {

  private Node<E> head;
  private Node<E> tail;
  private int size;

  public List() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public List(Node<E> head) {
    this.head = head;
    this.tail = head;
    this.size = 1;
  }

  public void add(E value) {
    Node<E> node = new Node<>(value);

    if (this.getHead() == null && this.getHead() == null) {
      this.setHead(node);
      this.setTail(node);
    } else {
      node.setPrev(this.getTail());
      this.getTail().setNext(node);
      this.setTail(node);
    }

    this.size += 1;
  }

  public void add(E value, int index) {
    if (index < 0 || index > this.getSize()) {
      throw new IndexOutOfBoundsException();
    } else {
      Node<E> node = new Node<>(value);

      if (index == 0) {
        node.setNext(this.getHead());
        this.getHead().setPrev(node);
        this.setHead(node);
      } else if (index == this.getSize()) {
        node.setPrev(this.getTail());
        this.getTail().setNext(node);
        this.setTail(node);
      } else {
        int i = 1;
        Node<E> temp = this.getHead().getNext();

        while (i++ != index) {
          temp = temp.getNext();
        }

        node.setPrev(temp.getPrev());
        node.setNext(temp);
        temp.getPrev().setNext(node);
        temp.setPrev(node);
      }
    }

    this.size += 1;
  }

  public void clear() {
    this.setHead(null);
    this.setTail(null);
  }

  public boolean contains(E value) {
    Node<E> temp = this.getHead();

    while ((temp != null) && (temp.getValue() != value)) {
      temp = temp.getNext();
    }

    if (temp == null) {
      return false;
    } else {
      return true;
    }

  }

  public E get(int index) throws ListException {
    if (index < 0 || index == size) {
      throw new IndexOutOfBoundsException();
    } else {
      if (index == 0) {
        return this.getHead().getValue();
      } else if (index == this.getSize() - 1) {
        return this.getTail().getValue();
      } else {
        int i = 1;
        Node<E> temp = this.getHead().getNext();

        while (i++ != index && temp != null) {
          temp = temp.getNext();
        }

        return temp.getValue();
      }
    }
  }

  private Node<E> getHead() {
    return this.head;
  }

  public int getSize() {
    return this.size;
  }

  private Node<E> getTail() {
    return this.tail;
  }

  public int indexOf(E value) {
    int index = 0;
    Node<E> temp = this.getHead();

    while (temp.getValue() == value && temp != null) {
      temp = temp.getNext();
      index++;
    }

    return temp == null ? -1 : index;
  }

  public boolean isEmpty() {
    return this.getSize() == 0;
  }

  @Override
  public Iterator<E> iterator() {
    Iterator<E> it = new Iterator<E>() {
      Node<E> node = getHead();

      @Override
      public boolean hasNext() {
        return node != null;
      }

      @Override
      public E next() {
        E val = node.getValue();
        node = node.getNext();
        return val;
      }
    };
    return it;
  }

  public boolean remove(E value) {
    Node<E> temp = this.getHead();

    while ((temp.getValue() != value)) {
      temp = temp.getNext();

      if (temp == null) {
        break;
      }
    }

    if (temp == null) {
      return false;
    } else {
      temp.getPrev().setNext(temp.getNext());
      temp.getNext().setPrev(temp.getPrev());
    }

    this.size -= 1;
    return true;
  }

  public boolean remove(int index) {
    if (this.isEmpty() || (index < 0 || index == this.getSize())) {
      throw new IndexOutOfBoundsException();
    } else {
      int half = (this.getSize() / 2) - 1;

      if (index == 0) {
        this.setHead(this.getHead().getNext());
        this.getHead().setPrev(null);
      } else if (index == this.getSize() - 1) {
        this.setTail(this.getTail().getPrev());
        this.getTail().setNext(null);
      } else if (index <= half) {
        int i = 1;
        Node<E> temp = this.getHead().getNext();

        while (i != index) {
          temp = temp.getNext();
          i++;
        }

        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());

      } else if (index >= half) {
        int i = this.getSize() - 2;
        Node<E> temp = this.getTail().getPrev();

        while (i != index) {
          temp = temp.getPrev();
          i--;
        }

        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
      }

    }

    this.size -= 1;
    return true;
  }

  private void setHead(Node<E> head) {
    this.head = head;
  }

  private void setTail(Node<E> tail) {
    this.tail = tail;
  }

}
