package app.eat;

/**
 * Popcorn store class.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class PopCornStore extends Store {
  PopCornStore() {
    super(1.0);
  }

  @Override
  public void serve(Customer cstmr) {
    this.serving = cstmr;
    if (cstmr == null) {
      this.serveHistory.enqueue(new Node(0));
    } else {
      this.serveHistory.enqueue(new Node(cstmr.getValue()));
      this.serving.setBusy(true);
      this.serving.setPopCorn(this.serving.getPopCorn() - this.serveTime);
    }
  }

  @Override
  public double checkCustomer(Customer cstmr) {
    return cstmr.getPopCorn();
  }
}
