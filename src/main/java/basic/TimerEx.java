package basic;


import java.util.Timer;
import java.util.TimerTask;

public class TimerEx {

      int s = 0;
      Timer myTimer = new Timer();
      TimerTask tt = new TimerTask() {
            public void run() {
                  s++;
                  System.out.println("TIME: " + s);
            }
      };

      public void start() {
            myTimer.scheduleAtFixedRate(tt, 1000, 1000);
      }

      public static void main(String args[]) {
            TimerEx te = new TimerEx();
            te.start();
      }
}
