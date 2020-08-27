package Basic;


import java.util.Timer;
import java.util.TimerTask;

public class Timer_ex {

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
            Timer_ex te = new Timer_ex();
            te.start();
      }
}
