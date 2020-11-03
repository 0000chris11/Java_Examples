/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB_Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.plaf.synth.SynthTableUI;
import javax.swing.plaf.basic.BasicToolBarUI;
import javax.swing.plaf.synth.SynthButtonUI;

/**
 *
 * @author Christopher
 */
public class StyleComponents extends JFrame{
      JPanel p1 = new JPanel();
      JToolBar tb = new JToolBar(JToolBar.VERTICAL);
      JToolBar tb2 = new JToolBar(JToolBar.HORIZONTAL);
      JToolBar[] tbs = new JToolBar[]{tb, tb2};
      
      JTable[] jts = new JTable[]{new JTable(new Object[][]{{"right", "left", "up", "down"},
            {"R", "L", "U", "D"}}, new Object[]{"First", "Second", "Third", "Four"}), 
      new JTable(new Object[][]{{"derecha", "izquierda", "arriba", "abajo"},
            {"D", "I", "A", "A"}}, new Object[]{"Primera", "Segunda", "Tercera", "Cuarta"})};
      
      JScrollPane[] scs = new JScrollPane[]{new JScrollPane(jts[0]), new JScrollPane(jts[1])};
      
      JButton btn1 = new JButton();
      JButton btn2 = new JButton();
      JButton btn3 = new JButton();
      JButton btn4 = new JButton();
      JButton btn5 = new JButton();
      JButton[] btns = new JButton[]{btn1, btn2, btn3, btn4, btn5};
      
      JTextField[] jtfs = new JTextField[]{new JTextField(), new JTextField(50)};
      
      private void btnListeners(){
            btns[4].addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent evt){
                        System.out.println("PRESS");
                        jts[0].setVisible(false);
                  }
            });
      }
      
      private void toolbarConfig(){
            add(tbs[0]);
            tbs[0].setLayout(null);
            int x = p1.getWidth() + 6;
            int h = p1.getHeight(); 
            tbs[0].setBounds(x, 6, 40, h);
            tbs[0].setBackground(new Color(51, 51, 51));
            System.out.println("\nToolbar 1 UI: " + tbs[0].getUI());
            
            tbs[0].add(btns[4]);
            btns[4].setBounds(2, 14, 36, 20);
            System.out.println("Btn 1 UI: " + btns[4].getUI());
            //+++++++++++++++++++++++++++++++
            add(tbs[1]);
            tbs[1].setUI(new BasicToolBarUI());
            tbs[1].setLayout(null);
            int y = p1.getHeight() + 4; 
            tbs[1].setBounds(6, y, p1.getWidth(), 40);
            tbs[1].setBackground(new Color(51, 51, 51));
            System.out.println("\nToolbar 2 UI: " + tbs[1].getUI());
            
            tbs[1].add(btns[3]);
            btns[3].setBounds(14, 2, 36, 20);
            System.out.println("Btn 2 UI: " + btns[3].getUI());
            //+++++++++++++++++++++++++++++++++++++++++++++++++
            int xb = 30;
            btns[1].setUI(new BasicButtonUI());
      }
      private void tablesConfig(){
            p1.add(scs[0]);
            //jts[0].setUI();
            //scs[0].add(jts[0]);
            scs[0].setBounds(2, 2, 400, 220);
            scs[0].setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scs[0].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            jts[0].setPreferredSize(new Dimension(400, 250));
            System.out.println("\nFirst Table size: " + scs[0].getBounds()
                    + "\n\t" + jts[0].getBounds());
            
            p1.add(scs[1]);
            jts[1].setUI(new BasicTableUI());
            //scs[1].setBounds(104, 60, 100, 60);
            scs[1].setBounds(2, 224, 400, 220);
            scs[1].setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scs[1].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            jts[1].setPreferredSize(new Dimension(400, 250));
            //System.out.println("Second Table size: "//scs[1].getBounds()
              //      + "\n\t" + jts[1].getBounds());
      }
      private void textConfig(){
            p1.add(jtfs[0]);
            int y = scs[0].getHeight() + scs[1].getHeight() + 6;
            jtfs[0].setBounds(2, y, 50, 24);
            
            p1.add(jtfs[1]);
            jtfs[1].setBounds(54, y, 50, 24);
            System.out.println("JTFS[0] Location: " + jtfs[0].getBounds());
            System.out.println("JTFS[1] Location: " + jtfs[1].getBounds());
            //++++++++++++++++++++++++++++++++++++++++++
            jtfs[0].addFocusListener(new FocusListener() {
                  @Override
                  public void focusGained(FocusEvent arg0) {
                        System.out.println("1");
                  }

                  @Override
                  public void focusLost(FocusEvent arg0) {
                        
                  }
            });
            jtfs[1].addFocusListener(new FocusListener() {
                  @Override
                  public void focusGained(FocusEvent arg0) {
                        System.out.println("2");
                  }

                  @Override
                  public void focusLost(FocusEvent arg0) {
                        
                  }
            });
      }
      public void frameConfig(){
            setLayout(null);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setAlwaysOnTop(true);
            //setUndecorated(true);
            setSize(626, 582);
            setVisible(true);
            
            add(p1);
            p1.setLayout(null);
            p1.setBounds(6, 6, 560, 490);
            p1.setBackground(Color.BLACK);
      }
      
      public StyleComponents(){
            frameConfig();
            toolbarConfig();
            tablesConfig(); 
            btnListeners();
            
            textConfig();
            
            System.out.println("\nJTable 1 UI: " + jts[0].getUI());
            System.out.println("JTable 2 UI: " + jts[1].getUI());
            
            System.out.println("\n"+ UIManager.getLookAndFeel().toString());
      }
      
      public static void main(String[] args){
            new StyleComponents();
      }
}
