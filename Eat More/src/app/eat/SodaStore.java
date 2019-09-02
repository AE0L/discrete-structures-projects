package app.eat;

/**
 * Soda store class.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class SodaStore extends Store {
  SodaStore() {
    super(0.5);
  }

  @Override
  public void serve(Customer cstmr) {
    this.serving = cstmr;
    if (cstmr == null) {
      this.serveHistory.enqueue(new Node(0));
    } else {
      this.serveHistory.enqueue(new Node(cstmr.getValue()));
      this.serving.setBusy(true);
      this.serving.setSoda(this.serving.getSoda() - this.serveTime);
    }
  }

  @Override
  public double checkCustomer(Customer cstmr) {
    return cstmr.getSoda();
  }
}
