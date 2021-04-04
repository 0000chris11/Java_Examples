package timer;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            int count = 1;
            public void run() {
                System.out.println("timerTask: " + count++);
            }
        };

        Timer timer = new Timer();
        Scanner sc = new Scanner(System.in);
        System.out.println("1: schedule - 2: scheduleAtFixedRate");

        int op = sc.nextInt();

        if (op == 1) {
            timer.schedule(timerTask, 1000);
        } else {
            timer.scheduleAtFixedRate(timerTask, 0, 1000);
        }
    }
}
