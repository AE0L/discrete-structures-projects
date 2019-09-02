package aeol.datastruct;

public interface NodeInterface<E> {

  void setNext(Node<E> next);

  void setPrev(Node<E> prev);

  Node<E> getNext();

  Node<E> getPrev();

  void unlink();

  void setValue(E value);

  E getValue();

}
