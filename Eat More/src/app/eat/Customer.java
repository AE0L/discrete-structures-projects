package app.eat;

/**
 * Customer class.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class Customer extends Node implements Cloneable {
  private double popCorn;
  private double soda;
  private double hotDog;
  private boolean busy;

  Customer(double popCorn, double soda, double hotDog, int value) {
    super(value);
    this.popCorn = popCorn;
    this.soda = soda;
    this.hotDog = hotDog;
  }

  public double getPopCorn() {
    return this.popCorn;
  }

  public double getSoda() {
    return this.soda;
  }

  public double getHotDog() {
    return this.hotDog;
  }

  /**
   * Add total number of orders and return it.
   * 
   * @return the total number of orders.
   */
  public double getTotal() {
    return this.popCorn + this.soda + this.hotDog;
  }

  public void setPopCorn(double popCorn) {
    this.popCorn = popCorn;
  }

  public void setSoda(double soda) {
    this.soda = soda;
  }

  public void setHotDog(double hotDog) {
    this.hotDog = hotDog;
  }

  /**
   * Checks if order is complete.
   * 
   * @return true if order is zero, otherwise false
   */
  public boolean isDone() {
    return this.popCorn == 0 && this.soda == 0 && this.hotDog == 0;
  }

  /**
   * Set busy state.
   * 
   * @param busy - the state of the customer
   */
  public void setBusy(boolean busy) {
    this.busy = busy;
  }

  /**
   * Check busy state of customer.
   * 
   * @return true if busy, otherwise false
   */
  public boolean isBusy() {
    return this.busy;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
