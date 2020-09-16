package Layouts;

import AAMethods.MM;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Christopher
 */
public class Main {

      JFrame JF = new JFrame();
      JPanel JP = new JPanel();
      JScrollPane SC = new JScrollPane(JP);
      
      static JPanel[] JPS = new JPanel[]{
            new PanelG(null),
            new PanelG("BorderLayout"),//"miglayout" 
            new PanelG("BoxLayout"),//"boxlayout" 
            new PanelG("CardLayout"),
            new PanelG("FlowLayout"),
            new PanelG("GridBagLayout"),
            new PanelG("GridLayout"),
            new PanelG("GroupLayout"),
            new PanelG("MigLayout"),
            new PanelG("OverLayout"),
            new PanelG("SpringLayout")};

      static JButton[] JBTNS = new JButton[]{
            new Button(null),
            new Button("miglayout"),
            new Button("boxlayout")};

      private void setPanelsLayouts() {
            JPS[0].setLayout(null);
            JPS[1].setLayout(new BorderLayout(2, 2));
            JPS[2].setLayout(new BoxLayout(JPS[2], BoxLayout.Y_AXIS));
            JPS[3].setLayout(new CardLayout(2, 2));
            JPS[4].setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
            JPS[5].setLayout(new GridBagLayout());
            JPS[6].setLayout(new GridLayout(2, 2));
            JPS[7].setLayout(new GroupLayout(JPS[7]));
            JPS[8].setLayout(new MigLayout());
            JPS[9].setLayout(new OverlayLayout(JPS[9]));
            JPS[10].setLayout(new SpringLayout());
      }

      public Main() {
            JF.setTitle("Layout Test");
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setAlwaysOnTop(true);
            //JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
            JF.setLocationRelativeTo(null);
            JF.setLayout(new AbsoluteLayout());
            JF.setSize(600, 1000);
            //int d = 2;
            int sX = 0;
            int bs = 4;
            JF.add(SC);
            JP.setLayout(new GridLayout(5, 2, 2, 2));
            MM.setComponentFitOnJFrame(SC, JF);
            for (int a = 0; a < JPS.length; a++) {
                  setName(JPS[a], ("JP_" + (a + 1)));
                  JP.add(JPS[a]);
                  //JPS[a].setBackground(Color.BLACK);
                  //JPS[a].setLocation(d, 2);
                  //d += 302;
                  //sX += JPS[a].getWidth();
                  //+++++++++++++++++++++++
                  /*
                  for (int b = 0; b < JBTNS.length; b++) {
                        //System.out.println(JPS[a].getName() + ": " + JBTNS[b].getName());
                        setName(JBTNS[b], ("BTN_" + (b + 1)));
                        JPS[a].add(JBTNS[b]);
                        JBTNS[b].setLocation(4, bs);
                        bs += 44;
                        //JPS[a].add
                  }
                   */
            }
            //+++++++++++++++++++++++
            //JF.setSize(sX + 24, JPS[0].getHeight() + 44);
            JF.setVisible(true);
      }

      public void setName(JComponent jc, String name) {
            jc.setName(name);
      }

      public static void main(String[] args) {
            new Main();
            new Second();
      }
}
