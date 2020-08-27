package Wait;

public class Waiting_for_process_to_finish {

      int ori;

      public static void main(String[] args) {
            
            

            synchronized (b) {
                  try {
                        System.out.println("Waiting for b to complete...");
                        b.wait();
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }

                  System.out.println("Main Total is: " + b.total);
            }
      }

      public void run() {
            synchronized (this) {
                  for (int i = 0; i < 100; i++) {
                        ori += i;
                        System.out.println("Ori = " + ori);
                  }
                  notify();
            }
      }
}

class lb_St extends Thread {
      
      Waiting_for_process_to_finish wfptf = new Waiting_for_process_to_finish();
      
      /*
      int total;

      public void run() {
            synchronized (this) {
                  for (int i = 0; i < 100; i++) {
                        total += i;
                        System.out.println("total = "+ total);
                  }
                  notify();
            }
      }
       */
}
