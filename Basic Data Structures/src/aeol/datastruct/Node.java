package aeol.datastruct;

public class Node<E> implements NodeInterface<E> {

  private E value;
  private Node<E> next;
  private Node<E> prev;

  public Node(E value) {
    this.value = value;
    this.next = null;
    this.prev = null;
  }

  public Node(E value, Node<E> next) {
    this.value = value;
    this.next = next;
    this.prev = null;
  }

  public Node(E value, Node<E> next, Node<E> prev) {
    this.value = value;
    this.next = next;
    this.prev = prev;
  }

  @Override
  public void setNext(Node<E> next) {
    this.next = next;
  }

  @Override
  public void setPrev(Node<E> prev) {
    this.prev = prev;
  }

  @Override
  public Node<E> getNext() {
    return this.next;
  }

  @Override
  public Node<E> getPrev() {
    return this.prev;
  }

  @Override
  public void unlink() {
    this.next = null;
    this.prev = null;
  }

  @Override
  public void setValue(E value) {
    this.value = value;
  }

  @Override
  public E getValue() {
    return this.value;
  }

}
