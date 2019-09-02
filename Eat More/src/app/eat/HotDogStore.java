package app.eat;

/**
 * Hotdog store class.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class HotDogStore extends Store {
  HotDogStore() {
    super(0.25);
  }

  @Override
  public void serve(Customer cstmr) {
    this.serving = cstmr;
    if (cstmr == null) {
      this.serveHistory.enqueue(new Node(0));
    } else {
      this.serveHistory.enqueue(new Node(cstmr.getValue()));
      this.serving.setBusy(true);
      this.serving.setHotDog(this.serving.getHotDog() - this.serveTime);
    }
  }

  @Override
  public double checkCustomer(Customer cstmr) {
    return cstmr.getHotDog();
  }
}
