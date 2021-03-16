/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.cofii2.components.swing.ButtonGradient;
import com.cofii2.components.swing.LabelCustom;
import com.cofii2.methods.MComp;
import com.cofii2.methods.MImage;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

/**
 *
 * @author C0FII
 */
public class dragComponents1 {

      private static final int MAX = 6;
      private static final int SPACE = 12;

      private JFrame JF = new JFrame();

      private JLayeredPane JLP = new JLayeredPane();
      private JPanel JPM = new JPanel();
      private JPanel JPG = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  Graphics2D g2 = (Graphics2D) g;
                  for (int a = 0; a < MAX; a++) {
                        if (btns_Dist[a].isSelected()) {
                              int x1 = columns[a].getX() + columns[a].getWidth() + 2;
                              int y = columns[a].getY() + 13;
                              int x2 = btns_Dist[a].getX() - 2;
                              g2.setColor(Color.PINK);
                              g2.drawLine(x1, y, x2, y);
                        }
                  }
            }
      };

      private JPanel JPC = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  /*
                  Graphics2D g2 = (Graphics2D) g;
                  for(int a = 0; a < MAX; a++){
                        if(columns[a] != null){
                              g2.setColor(Color.WHITE);
                              int y = columns[a].getY() + 13;
                              g2.drawLine(2, y, getWidth() - 4, y);
                        }
                  }
                   */
            }
      };
      private JPanel JPL = new JPanel();
      private JPanel JPL1 = new JPanel();
      private JPanel JPL2 = new JPanel();
      private JPanel JPL3 = new JPanel();
      private JPanel JPR = new JPanel();

      private JLabel[] columns = new JLabel[MAX];
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private JLabel type1 = new LabelCustom("TYPE 1", JLabel.CENTER);
      private JLabel type2 = new LabelCustom("TYPE 2", JLabel.CENTER);

      private JToggleButton[] btns_Dist = new JToggleButton[MAX];
      private JToggleButton[] btns_Dist2 = new JToggleButton[MAX - 1];
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private JButton[] btns_lock1 = new JButton[MAX];
      private JButton[] btns_lock2 = new JButton[MAX];
      private JButton[] btns_lock3 = new JButton[MAX];

      private Line line = new Line();

      private dragComponents1(String choice) {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setLayout(new BorderLayout());

            JPanel glass = (JPanel) JF.getGlassPane();
            glass.setLayout(new BorderLayout());

            //JButton btn = new JButton("wwwww");
            //btn.setMinimumSize(new Dimension(200, 27));
            //btn.setMaximumSize(new Dimension(200, 27));
            //btn.setPreferredSize(new Dimension(200, 27));
            VL_Glass vl = new VL_Glass();
            vl.setOneLine(20, 20, 200, 20);
            glass.add(line, BorderLayout.CENTER);
            glass.setVisible(true);

            JPanel panelBACK = new JPanel();
            panelBACK.setBackground(Color.BLACK);
            JF.getContentPane().add(panelBACK, BorderLayout.CENTER);
            panelBACK.setLayout(new BorderLayout());
            JLabel lb1 = new LabelCustom("DOOP 1");
            JLabel lb2 = new LabelCustom("DOOP 2", JLabel.CENTER);
            JLabel lb3 = new LabelCustom("DOOP 3");
            lb1.setFont(new Font("Dialog", Font.BOLD, 30));
            lb2.setFont(new Font("Dialog", Font.BOLD, 30));
            lb3.setFont(new Font("Dialog", Font.BOLD, 30));
            panelBACK.add(lb1, BorderLayout.WEST);
            panelBACK.add(lb2, BorderLayout.CENTER);
            panelBACK.add(lb3, BorderLayout.EAST);
            /*
            JPanel panelFRONT = new JPanel(){
                  @Override
                  public void paintComponent(Graphics g){
                        super.paintComponent(g);
                        g.setColor(Color.RED);
                        g.drawLine(2, 50, this.getWidth() - 4 ,50);
                  }
            };
            panelFRONT.setOpaque(true);
            panelFRONT.setBackground(new Color(0,0,0,0));
            //panelFRONT.setBackground();
            pane.add(panelFRONT, 2);
             */
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void buttonChoice() {
            JPR.add(Box.createVerticalStrut(SPACE), 0);
            int c = 1;
            for (int a = 0; a < MAX; a++) {
                  btns_Dist[a] = new JToggleButton("" + (a + 1));
                  btns_Dist[a].setMinimumSize(new Dimension(80, 27));
                  btns_Dist[a].setMaximumSize(new Dimension(80, 27));
                  btns_Dist[a].setPreferredSize(new Dimension(80, 27));
                  btns_Dist[a].setAlignmentX(JComponent.CENTER_ALIGNMENT);
                  btns_Dist[a].setAlignmentX(JComponent.CENTER_ALIGNMENT);
                  JPR.add(btns_Dist[a], c++);
                  btns_Dist[a].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }

                  });
                  if (a != MAX - 1) {
                        btns_Dist2[a] = new JToggleButton("" + (a + 1) + "-" + (a + 2));
                        btns_Dist2[a].setMinimumSize(new Dimension(80, SPACE));
                        btns_Dist2[a].setMaximumSize(new Dimension(80, SPACE));
                        btns_Dist2[a].setPreferredSize(new Dimension(80, SPACE));
                        btns_Dist2[a].setAlignmentX(JComponent.CENTER_ALIGNMENT);
                        btns_Dist2[a].setAlignmentX(JComponent.CENTER_ALIGNMENT);
                        JPR.add(btns_Dist2[a], c++);
                  } else {
                        c++;
                  }

            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private class Line extends JComponent {

            private double alpha = 1.0;
            private Timer timer = new Timer(500, new ActionListener() {
                  public void actionPerformed(ActionEvent ae) {
                        System.out.println("Timer Action " + alpha);
                        alpha = alpha - 0.1;
                        System.out.println("\tTimer Action " + alpha);

                        if (alpha <= 0.0) {
                              System.out.println("\t\tXXXXXXXXXXXXXXSTOPXXXXXXXXXXXXXX");
                              stop();
                        } else {
                              repaint();
                        }
                  }
            });

            public void start() {
                  timer.start();
            }

            private void stop() {
                  timer.stop();
            }

            @Override
            public void paintComponent(Graphics g) {
                  if (alpha >= 0.0) {
                        Graphics2D g2 = (Graphics2D) g;
                        float alph = (float) alpha;
                        System.out.println("-----------------alph: " + alph);
                        g2.setComposite(AlphaComposite.getInstance(
                                AlphaComposite.SRC_OVER, alph));
                        g2.setColor(Color.RED);
                        g2.drawOval(8, 8, 200, 200);
                  }
            }
      }
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        dragComponents1 tt = new dragComponents1("BUTTON");
                        tt.JF.setSize(new Dimension(800, 400));
                        MComp.setFrameToCenterOfScreen(tt.JF);
                        tt.line.start();
                        tt.JF.setVisible(true);

                        System.out.println("JPL VISIBLE: " + tt.JPL.isVisible());
                        System.out.println("JPL SIZE: " + tt.JPL.getSize());
                  }

            });
      }
}
