package app.eat;

/**
 * The algorithm to find all the possible solutions for the Eat more problem.
 * 
 * @author JIMENEZ, Carl Justin
 * @author CHUA, Orjan
 * @section BSCS 2-2
 */
public class Solver {

  /**
   * Solves all the possible solutions and prints the two best solutions.
   * 
   * @param cstmr1 - the first customer
   * @param cstmr2 - the second customer
   * @param cstmr3 - the third customer
   * @throws Exception when solution printing throws and exception
   */
  public static void solve(Customer cstmr1, Customer cstmr2, Customer cstmr3) throws Exception {
    Customer first, second, third;
    double c1t = cstmr1.getTotal();
    double c2t = cstmr2.getTotal();
    double c3t = cstmr3.getTotal();

    /* Get customer prioritization */
    if (c1t >= c2t && c1t >= c3t) {
      first = cstmr1;
      if (c2t >= c3t) {
        second = cstmr2;
        third = cstmr3;
      } else {
        second = cstmr3;
        third = cstmr2;
      }
    } else if (c2t >= c1t && c2t >= c3t) {
      first = cstmr2;
      if (c1t >= c3t) {
        second = cstmr1;
        third = cstmr3;
      } else {
        second = cstmr1;
        third = cstmr3;
      }
    } else if (c3t >= c1t && c3t >= c2t) {
      first = cstmr3;
      if (c1t >= c2t) {
        second = cstmr1;
        third = cstmr2;
      } else {
        second = cstmr2;
        third = cstmr1;
      }
    } else {
      first = cstmr1;
      second = cstmr2;
      third = cstmr3;
    }

    /* Display customer prioritization */
    System.out.println("\nCustomer priority: Customer " + first.getValue() + " -> Customer "
        + second.getValue() + " -> Customer " + third.getValue());

    /* Get possible solutions */
    Solution best, alt;

    Solution sol1 =
        algorithm(new PopCornStore(), new SodaStore(), new HotDogStore(), (Customer) first.clone(),
            (Customer) second.clone(), (Customer) third.clone(), "PopCorn -> Soda -> HotDog");

    Solution sol2 =
        algorithm(new PopCornStore(), new HotDogStore(), new SodaStore(), (Customer) first.clone(),
            (Customer) second.clone(), (Customer) third.clone(), "PopCorn -> HotDog -> Soda");

    Solution sol3 =
        algorithm(new SodaStore(), new HotDogStore(), new PopCornStore(), (Customer) first.clone(),
            (Customer) second.clone(), (Customer) third.clone(), "Soda -> HotDog -> PopCorn");

    Solution sol4 =
        algorithm(new SodaStore(), new PopCornStore(), new HotDogStore(), (Customer) first.clone(),
            (Customer) second.clone(), (Customer) third.clone(), "Soda -> PopCorn -> HotDog");

    Solution sol5 =
        algorithm(new HotDogStore(), new PopCornStore(), new SodaStore(), (Customer) first.clone(),
            (Customer) second.clone(), (Customer) third.clone(), "HotDog -> PopCorn -> Soda");

    Solution sol6 =
        algorithm(new HotDogStore(), new SodaStore(), new PopCornStore(), (Customer) first.clone(),
            (Customer) second.clone(), (Customer) third.clone(), "HotDog -> Soda -> PopCorn");

    /* Get best two solutions */
    if (sol1.getAverage() < sol2.getAverage()) {
      best = sol1;
      alt = sol2;
    } else {
      best = sol2;
      alt = sol1;
    }

    if (sol3.getAverage() < best.getAverage()) {
      best = sol3;
    } else if (sol3.getAverage() < alt.getAverage()) {
      alt = sol3;
    }

    if (sol4.getAverage() < best.getAverage()) {
      best = sol4;
    } else if (sol4.getAverage() < alt.getAverage()) {
      alt = sol4;
    }

    if (sol5.getAverage() < best.getAverage()) {
      best = sol5;
    } else if (sol5.getAverage() < alt.getAverage()) {
      alt = sol5;
    }

    if (sol6.getAverage() < best.getAverage()) {
      best = sol6;
    } else if (sol6.getAverage() < alt.getAverage()) {
      alt = sol6;
    }

    /* Print best two solutions */
    System.out.print("\nBest solution ");
    best.printSolution();
    System.out.print("\nAlternative solution ");
    alt.printSolution();
  }

  /**
   * The algorithm for the Eat more problem.
   * 
   * Starts with the store and customer with the highest priority. When a store or customer is busy
   * try the other stores and customers. Each iteration is measured in minutes. When all the
   * customers completed their orders stop the looping and create a new Solution object with the
   * values obtained and return it.
   * 
   * @param store1 - first priority store
   * @param store2 - second priority store
   * @param store3 - third priority store
   * @param first - first priority customer
   * @param second - second priority customer
   * @param third - third priority customer
   * @param priority - string representation of the store prioritization
   * @return the solution obtained with the given prioritizations
   * @throws Exception when an exception occured while accessing the serve history of a store
   */
  private static Solution algorithm(Store store1, Store store2, Store store3, Customer first,
      Customer second, Customer third, String priority) throws Exception {
    int minutes = 0;
    double c1min = 0, c2min = 0, c3min = 0;

    /* Loop until every customer is done */
    while (!first.isDone() || !second.isDone() || !third.isDone()) {
      minutes += 1;

      /* First store */
      if (!store1.isBusy()) {
        double c1 = store1.checkCustomer(first);
        double c2 = store1.checkCustomer(second);
        double c3 = store1.checkCustomer(third);

        if (c1 != 0 && !first.isBusy()) {
          store1.serve(first);
        } else if (c2 != 0 && !second.isBusy()) {
          store1.serve(second);
        } else if (c3 != 0 && !third.isBusy()) {
          store1.serve(third);
        } else {
          store1.serve(null);
        }
      }

      /* Second store */
      if (!store2.isBusy()) {
        double c1 = store2.checkCustomer(first);
        double c2 = store2.checkCustomer(second);
        double c3 = store2.checkCustomer(third);

        if (c1 != 0 && !first.isBusy()) {
          store2.serve(first);
        } else if (c2 != 0 && !second.isBusy()) {
          store2.serve(second);
        } else if (c3 != 0 && !third.isBusy()) {
          store2.serve(third);
        } else {
          store2.serve(null);
        }
      } else {
        store2.serve(store2.getServing());
      }

      /* Third store */
      if (!store3.isBusy()) {
        double c1 = store3.checkCustomer(first);
        double c2 = store3.checkCustomer(second);
        double c3 = store3.checkCustomer(third);

        if (c1 != 0 && !first.isBusy()) {
          store3.serve(first);
        } else if (c2 != 0 && !second.isBusy()) {
          store3.serve(second);
        } else if (c3 != 0 && !third.isBusy()) {
          store3.serve(third);
        } else {
          store3.serve(null);
        }
      } else {
        store3.serve(store3.getServing());
      }

      /* Checks if order on each store is complete */
      if (store1.isBusy()) {
        store1.completeServe();
      }

      if (store2.isBusy() && store2.checkCustomer(store2.getServing()) % 1 == 0) {
        store2.completeServe();
      }

      if (store3.isBusy() && store3.checkCustomer(store3.getServing()) % 1 == 0) {
        store3.completeServe();
      }

      /* Store the maximum minutes of each customer in queue */
      c1min = (first.isDone() && c1min == 0) ? minutes : c1min;
      c2min = (second.isDone() && c2min == 0) ? minutes : c2min;
      c3min = (third.isDone() && c3min == 0) ? minutes : c3min;
    }


    /* Gets the correct serve history */
    Queue popCorn, soda, hotDog;

    if (store1 instanceof PopCornStore) {
      popCorn = store1.getServeHistory();
      if (store2 instanceof SodaStore) {
        soda = store2.getServeHistory();
        hotDog = store3.getServeHistory();
      } else {
        soda = store3.getServeHistory();
        hotDog = store2.getServeHistory();
      }
    } else if (store2 instanceof PopCornStore) {
      popCorn = store2.getServeHistory();
      if (store1 instanceof SodaStore) {
        soda = store1.getServeHistory();
        hotDog = store3.getServeHistory();
      } else {
        soda = store3.getServeHistory();
        hotDog = store1.getServeHistory();
      }
    } else {
      popCorn = store3.getServeHistory();
      if (store1 instanceof SodaStore) {
        soda = store1.getServeHistory();
        hotDog = store2.getServeHistory();
      } else {
        soda = store2.getServeHistory();
        hotDog = store1.getServeHistory();
      }
    }

    return new Solution(popCorn, soda, hotDog, minutes, c1min, c2min, c3min, priority);
  }

}
