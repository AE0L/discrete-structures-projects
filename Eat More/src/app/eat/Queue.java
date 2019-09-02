package app.eat;

/**
 * Basic Queue data structure class.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class Queue {
  public Node front;
  public Node back;
  public int size;

  Queue(Node head) {
    this.front = head;
    this.size = 1;
  }

  Queue() {
    this.front = null;
    this.size = 0;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Add a node on the back of the queue.
   * 
   * @param node - the node to be added
   */
  public void enqueue(Node node) {
    if (this.front == null) {
      this.front = node;
      this.back = node;
      this.size = 1;
    } else {
      this.back.setNext(node);
      this.back = node;
      this.size += 1;
    }
  }

  /**
   * Remove the front node of the queue and return it.
   * 
   * @return the front node of the queue
   * @throws Exception when the queue is empty
   */
  public Node dequeue() throws Exception {
    if (this.front == null) {
      throw new Exception();
    } else {
      Node temp = this.front;
      this.front = this.front.getNext();
      return temp;
    }
  }
}
