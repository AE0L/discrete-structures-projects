package app.eat;

/**
 * Base class for the stores needed in the Eat More problem.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class Store {
  public Customer serving;
  public Queue serveHistory;
  public double serveTime;

  Store(double serveTime) {
    this.serving = null;
    this.serveHistory = new Queue();
    this.serveTime = serveTime;
  }

  /**
   * Must be overriden and provide the following logic:
   * 
   * If customer is null enqueue in the history a node with a value of 0 otherwise enqueue the
   * customer's number, set the customer's busy state to true and decrease the correct order with
   * the store's serving time (the number of minutes it takes to complete an order).
   * 
   * @param cstmr - the customer to be served
   */
  public void serve(Customer cstmr) {}

  public double getServeTime() {
    return this.serveTime;
  }

  public Customer getServing() {
    return this.serving;
  }

  public Queue getServeHistory() {
    return this.serveHistory;
  }

  /**
   * Checks the busy state of the store.
   * 
   * @return true if the store is not serving any customer, otherwise false
   */
  public boolean isBusy() {
    return this.serving != null;
  }

  /**
   * Complete it's serving on a customer and set it available for the next customer if there are
   * still left.
   */
  public void completeServe() {
    this.serving.setBusy(false);
    this.serving = null;
  }

  /**
   * Checks the correct product, and return the number of orders left on a customer.
   * 
   * @param cstmr - the customer to be checked
   * @return the number of order left for the customer
   */
  public double checkCustomer(Customer cstmr) {
    return 0;
  }

}
