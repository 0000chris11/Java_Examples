/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author COFII
 */
public class VL_Glass extends JComponent {

      private boolean ONE_LINE = false;
      private boolean TWO_LINES = false;

      private boolean DIST = true;

      private int dist = 0;
      private int dist2 = 0;
      private int dist_2 = 0;
      private int dist2_2 = 0;

      private int x1;
      private int y1;
      private int x2;
      private int y2;

      @Override
      protected void paintComponent(Graphics g) {
            //super.paintComponent(g);
            System.out.println("PAINT COMPONENT");
            if (ONE_LINE) {
                  int n_x1;
                  int n_y1;
                  int n_x2;
                  int n_y2;

                  if (DIST) {
                        n_x1 = 0;
                        n_y1 = 0;
                        n_x2 = 0;
                        n_y2 = 0;

                        if (dist == dist2) {
                              n_y1 += 19;
                              n_y2 += 19;
                        } else if (dist > dist2) {
                              n_y1 += 6;
                              n_y2 += 6;
                        }

                  } else {
                        n_x1 = this.x1;
                        n_y1 = this.y1;
                        n_x2 = this.x2;
                        n_y2 = this.y2;
                  }

                  final int x1 = n_x1;
                  final int y1 = n_y1;
                  final int x2 = n_x2;
                  final int y2 = n_y2;
                  /*
                  Graphics2D g2 = (Graphics2D) g;
                  g2.setComposite(AlphaComposite.getInstance(
                                           AlphaComposite.SRC_OVER, 0.5f));
                   g2.setColor(Color.WHITE);
                    g2.drawLine(8, 8, VL_Glass.this.getHeight() - 8, VL_Glass.this.getHeight() - 8);
                   */

                  new Thread(new Runnable() {
                        @Override
                        public void run() {
                              float alpha = 1.0f;
                              Graphics2D g2 = (Graphics2D) g;
                              //for (int a = 0; a < 10; a++) {
                                    g2.setComposite(AlphaComposite.getInstance(
                                            AlphaComposite.SRC_OVER, alpha));
                                    g2.setColor(Color.WHITE);

                                    //g2.drawLine(x1, y1, x2, y2);
                                    int xx1 = VL_Glass.this.getHeight() - 8;
                                    g2.drawLine(8, 8, xx1, xx1);
                                    System.out.println("LINE DRAWED " + (xx1));
                                    try {
                                          Thread.sleep(1000);
                                          //g2.dispose();
                                          alpha = alpha - 0.1f;
                                    } catch (InterruptedException ex) {
                                          Logger.getLogger(VL_Glass.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                              //}
                              ONE_LINE = false;
                        }

                  }).start();

            }

      }

      public void setOneLine(int dist, int dist2) {
            ONE_LINE = true;
            DIST = true;
            this.dist = dist;
            this.dist2 = dist2;
      }

      public void setOneLine(int x1, int y1, int x2, int y2) {
            ONE_LINE = true;
            DIST = false;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
      }

      public void setTwoLines(int dist, int dist2, int dist_2, int dist2_2) {
            TWO_LINES = true;
            this.dist = dist;
            this.dist2 = dist2;
            this.dist_2 = dist_2;
            this.dist2_2 = dist2_2;
      }

      /*
            1-1
            2-1
            2-2
            3-2
            3-3
            4-3
            4-4
            5-4
       */
}
