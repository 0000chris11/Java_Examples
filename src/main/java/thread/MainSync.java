package thread;

/**
 *
 * @author C0FII
 */
class MainSync {

      private int c = 0;

      //++++++++++++++++++++++++++++++++++
     synchronized void increment() {
            c++;
      }

     synchronized void decrement() {
            c--;
      }

      //+++++++++++++++++++++++++++++++++++
      synchronized void incrementSlowly() {
            new Thread() {
                  @Override
                  public void run() {
                        try {
                              Thread.sleep(10000);
                              c++;
                        } catch (InterruptedException ex) {
                              ex.printStackTrace();
                              Thread.currentThread().interrupt();
                        }
                  }
            }.start();

      }

      synchronized void decrementSlowly() {
            new Thread() {
                  @Override
                  public void run() {
                        try {
                              Thread.sleep(10000);
                              c--;
                        } catch (InterruptedException ex) {
                              ex.printStackTrace();
                              Thread.currentThread().interrupt();
                        }
                  }
            }.start();
      }

      //+++++++++++++++++++++++++++++++++++
      synchronized int getValue() {
            return c;
      }

      MainSync(){
            incrementSlowly();
            new Thread() {
                  @Override
                  public void run() {
                        incrementSlowly();
                        System.out.println("Value: " + getValue());
                  }
            }.start();
      }
      //+++++++++++++++++++++++++++++++++++
      public static void main(String[] args) {
            System.out.println("Main_Sync Thread Star");
            new MainSync();
      }
      //++++++++++++++++++++++++++++++++++
}
