/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.cofii2.components.swing.ButtonGradient;
import com.cofii2.components.swing.LabelCustom;
import com.cofii2.methods.MComp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class DragComponents2 {

      private static final int MAX = 6;
      private static final int SPACE = 12;

      private JFrame JF = new JFrame();
      
      private JLayeredPane JLP = new JLayeredPane();
      private JPanel JPM = new JPanel();
      private JPanel JPG = new JPanel(){
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  Graphics2D g2 = (Graphics2D) g;
                  for(int a = 0; a < MAX; a++){
                        if(btns_Dist[a].isSelected()){
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
            /**
             *
             */
            private static final long serialVersionUID = 1L;

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
      private JLabel type1 = new LabelCustom("TYPE 1", SwingConstants.CENTER);
      private JLabel type2 = new LabelCustom("TYPE 2", SwingConstants.CENTER);

      private JToggleButton[] btns_Dist = new JToggleButton[MAX];
      private JToggleButton[] btns_Dist2 = new JToggleButton[MAX - 1];
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private JButton[] btns_lock1 = new JButton[MAX];
      private JButton[] btns_lock2 = new JButton[MAX];
      private JButton[] btns_lock3 = new JButton[MAX];

      private DragComponents2(String choice) {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setLayout(new BorderLayout());
            JF.getContentPane().add(JPL, BorderLayout.CENTER);
            
            JPL.setMinimumSize(new Dimension(100, 60));
            JPL.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
            JPL.setPreferredSize(new Dimension(800, 400));

            JPM.setBackground(Color.BLACK);
            JPM.setLayout(new BorderLayout(1,1));
            
            JPG.setOpaque(true);
            JPG.setBackground(new Color(0,0,0,0));
                    
            JLP.add(JPM, 1);
            JPG.setVisible(false);
            //++++++++++++++++++++++++++++++++++++++++++
            JPM.add(JPC, BorderLayout.CENTER);
            JPM.add(JPL, BorderLayout.WEST);
            JPM.add(JPR, BorderLayout.EAST);

            JPC.setMinimumSize(new Dimension(200, 60));
            JPC.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
            JPC.setPreferredSize(new Dimension(200, 600));
            JPC.setBackground(Color.BLACK);
            JPC.setLayout(new BoxLayout(JPC, BoxLayout.Y_AXIS));
            JPC.add(Box.createVerticalStrut(SPACE), 0);
            int c = 1;
            for (int a = 0; a < MAX; a++) {
                  columns[a] = new LabelCustom("Column " + (a + 1), SwingConstants.CENTER);
                  columns[a].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                  JPC.add(columns[a], c++);
                  columns[a].setMinimumSize(new Dimension(50, 27));
                  columns[a].setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
                  columns[a].setPreferredSize(new Dimension(180, 27));

                  columns[a].setAlignmentX(Component.CENTER_ALIGNMENT);
                  JPC.add(Box.createVerticalStrut(SPACE), c++);
            }
            //++++++++++++++++++++++++++++++++++
            JPL.setBackground(Color.BLACK);
            JPL.setMinimumSize(new Dimension(270, 60));
            JPL.setMaximumSize(new Dimension(270, Short.MAX_VALUE));
            JPL.setPreferredSize(new Dimension(270, 600));
            JPL.setLayout(new BoxLayout(JPL, BoxLayout.X_AXIS));
            JPL.add(JPL1, 0);
            JPL.add(JPL2, 1);
            JPL.add(JPL3, 2);
            JPL1.setBackground(Color.BLACK);
            JPL2.setBackground(Color.BLACK);
            JPL3.setBackground(Color.BLACK);

            JPL1.setMinimumSize(new Dimension(90, 60));
            JPL1.setMaximumSize(new Dimension(90, Short.MAX_VALUE));
            JPL1.setPreferredSize(new Dimension(90, 600));
            JPL2.setMinimumSize(new Dimension(90, 60));
            JPL2.setMaximumSize(new Dimension(90, Short.MAX_VALUE));
            JPL2.setPreferredSize(new Dimension(90, 600));
            JPL3.setMinimumSize(new Dimension(90, 60));
            JPL3.setMaximumSize(new Dimension(90, Short.MAX_VALUE));
            JPL3.setPreferredSize(new Dimension(90, 600));

            JPL1.setLayout(new BoxLayout(JPL1, BoxLayout.Y_AXIS));
            JPL2.setLayout(new BoxLayout(JPL2, BoxLayout.Y_AXIS));
            JPL3.setLayout(new BoxLayout(JPL3, BoxLayout.Y_AXIS));
            JPL1.add(Box.createVerticalStrut(SPACE), 0);
            JPL2.add(Box.createVerticalStrut(SPACE), 0);
            JPL3.add(Box.createVerticalStrut(SPACE), 0);
            c = 1;
            for (int a = 0; a < MAX; a++) {
                  btns_lock1[a] = new ButtonGradient("LOCK 1", new Color[]{Color.RED, Color.WHITE});
                  btns_lock2[a] = new ButtonGradient("LOCK 2", new Color[]{Color.RED, Color.WHITE});
                  btns_lock3[a] = new ButtonGradient("LOCK 3", new Color[]{Color.RED, Color.WHITE});

                  btns_lock1[a].setMinimumSize(new Dimension(80, 27));
                  btns_lock1[a].setMaximumSize(new Dimension(80, 27));
                  btns_lock1[a].setPreferredSize(new Dimension(80, 27));
                  btns_lock2[a].setMinimumSize(new Dimension(80, 27));
                  btns_lock2[a].setMaximumSize(new Dimension(80, 27));
                  btns_lock2[a].setPreferredSize(new Dimension(80, 27));
                  btns_lock3[a].setMinimumSize(new Dimension(80, 27));
                  btns_lock3[a].setMaximumSize(new Dimension(80, 27));
                  btns_lock3[a].setPreferredSize(new Dimension(80, 27));

                  JPL1.add(btns_lock1[a], c++);
                  JPL1.add(Box.createVerticalStrut(SPACE), c--);

                  JPL2.add(btns_lock2[a], c++);
                  JPL2.add(Box.createVerticalStrut(SPACE), c--);

                  JPL3.add(btns_lock3[a], c++);
                  JPL3.add(Box.createVerticalStrut(SPACE), c++);

                  btns_lock1[a].setAlignmentX(Component.CENTER_ALIGNMENT);
                  btns_lock2[a].setAlignmentX(Component.CENTER_ALIGNMENT);
                  btns_lock3[a].setAlignmentX(Component.CENTER_ALIGNMENT);
            }
            //++++++++++++++++++++++++++++++++++++++++++++
            JPR.setBackground(Color.BLACK);
            JPR.setMinimumSize(new Dimension(90, 60));
            JPR.setMaximumSize(new Dimension(90, Short.MAX_VALUE));
            JPR.setPreferredSize(new Dimension(90, 600));

            JPR.setLayout(new BoxLayout(JPR, BoxLayout.Y_AXIS));
            if (choice.equals("DRAG")) {
                  dragChoice();
            } else if (choice.equals("BUTTON")) {
                  buttonChoice();
            }

      }

      private void dragChoice() {
            JPR.add(Box.createVerticalStrut(SPACE), 0);
            JPR.add(type1, 1);
            JPR.add(Box.createVerticalStrut(SPACE), 2);
            JPR.add(type2, 3);

            type1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            type2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

            type1.setMinimumSize(new Dimension(80, 27));
            type1.setMaximumSize(new Dimension(80, 27));
            type1.setPreferredSize(new Dimension(80, 27));
            type2.setMinimumSize(new Dimension(80, 27));
            type2.setMaximumSize(new Dimension(80, 27));
            type2.setPreferredSize(new Dimension(80, 27));

            type1.setAlignmentX(Component.CENTER_ALIGNMENT);
            type2.setAlignmentX(Component.CENTER_ALIGNMENT);
      }

      private void buttonChoice() {
            JPR.add(Box.createVerticalStrut(SPACE), 0);
            int c = 1;
            for (int a = 0; a < MAX; a++) {
                  btns_Dist[a] = new JToggleButton("" + (a + 1));
                  btns_Dist[a].setMinimumSize(new Dimension(80, 27));
                  btns_Dist[a].setMaximumSize(new Dimension(80, 27));
                  btns_Dist[a].setPreferredSize(new Dimension(80, 27));
                  btns_Dist[a].setAlignmentX(Component.CENTER_ALIGNMENT);
                  btns_Dist[a].setAlignmentX(Component.CENTER_ALIGNMENT);
                  JPR.add(btns_Dist[a], c++);

                  if (a != MAX - 1) {
                        btns_Dist2[a] = new JToggleButton("" + (a + 1) + "-" + (a + 2));
                        btns_Dist2[a].setMinimumSize(new Dimension(80, SPACE));
                        btns_Dist2[a].setMaximumSize(new Dimension(80, SPACE));
                        btns_Dist2[a].setPreferredSize(new Dimension(80, SPACE));
                        btns_Dist2[a].setAlignmentX(Component.CENTER_ALIGNMENT);
                        btns_Dist2[a].setAlignmentX(Component.CENTER_ALIGNMENT);
                        JPR.add(btns_Dist2[a], c++);
                  }else{
                        c++;
                  }

            }
      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        DragComponents2 tt = new DragComponents2("BUTTON");
                        tt.JF.setSize(new Dimension(800, 400));
                        MComp.setFrameToCenterOfScreen(tt.JF);
                        tt.JF.setVisible(true);
                        
                        System.out.println("JPL VISIBLE: " + tt.JPL.isVisible());
                        System.out.println("JPL SIZE: " + tt.JPL.getSize());
                  }

            });
      }
}
