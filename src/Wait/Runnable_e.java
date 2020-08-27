package Wait;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Runnable_e extends JFrame implements Runnable {

      private String name;
      private int time;
      Random r = new Random();

      static boolean bool = false;

      public void run() {
            try {
                  System.out.println("SLEEPING");
                  Thread.sleep(10);
                  System.out.println("DONE SLEEPING");
            } catch (Exception e) {
            }
      }

      public Runnable_e(String x) {
            name = x;
            time = r.nextInt(999);

      }

      public Runnable_e() {
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            JButton btn = new JButton("STAR");
            JLabel lb = new JLabel("Waiting");
            JLabel lb_2 = new JLabel("LABEL 2");
            JTextField tf = new JTextField();

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setUndecorated(false);
            frame.setLocation(50, 50);
            frame.setSize(400, 300);
            frame.setVisible(true);
            
            

            panel.setLayout(null);
            panel.setLocation(6, 6);
            panel.setSize(380, 280);
            panel.setBackground(Color.BLACK);
            frame.add(panel);

            btn.setLocation(80, 80);
            btn.setSize(40, 30);
            panel.add(btn);

            lb.setLocation(40, 116);
            lb.setSize(80, 40);
            lb.setForeground(Color.WHITE);
            panel.add(lb);
            
            lb_2.setLocation(40, 168);
            lb_2.setSize(80, 40);
            lb_2.setForeground(Color.WHITE);
            panel.add(lb_2);
            
            tf.setSize(80, 40);
            tf.setBackground(Color.GRAY);
            tf.setForeground(Color.WHITE);
            panel.add(tf);

            btn.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent evt) {
                        Thread t1 = new Thread(new Runnable() {
                              public void run() {
                                    lb.setForeground(Color.GREEN);
                                    lb.setText("PROCESS");
                                    
                                    System.out.println("SLEEPING");
                                    try {
                                          Thread.sleep(5000);
                                    } catch (InterruptedException ex) {
                                          Logger.getLogger(Runnable_e.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    System.out.println("WAKE UP");
                                    
                                    lb.setText("DONE");
                              }
                        });

                        t1.start();
                        /*
                        try {
                              t1.join();
                        } catch (InterruptedException ex) {
                              Logger.getLogger(Runnable_e.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        */
                        lb_2.setText("PROc??=");
                  }
            });

      }

      public static void main(String[] args) {

            Runnable_e t0 = new Runnable_e();

            if (bool == true) {
                  //Thread t1 = new Thread(new Runnable_e("one"));//Runnable Target
                  Thread t2 = new Thread(new Runnable_e("two"));
                  Thread t3 = new Thread(new Runnable_e("three"));
                  Thread t4 = new Thread(new Runnable_e("four"));

                  Thread t5 = new Thread();

                  //t1.start();
                  t2.start();
                  t3.start();
                  t4.start();
            }
      }

}
