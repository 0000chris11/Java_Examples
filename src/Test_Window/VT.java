/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Window;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Christopher
 */
public class VT {
      
      private JFrame JF = new JFrame();
      private ArrayList<JButton> btns = new ArrayList<JButton>();
      private ArrayList<JComboBox> cboxs = new ArrayList<JComboBox>();
      private ArrayList<JSeparator> seps = new ArrayList<JSeparator>();
      
      public void addButton(JButton btn){
            JF.add(btn);
            btns.add(btn);
            /*
            int sum = 0;
            for(int a = 0; a < btns.size(); a++){
                  sum += btns.get(a).getWidth();
            }
            JF.setSize(sum + 20, 100);
            */
            JF.pack();
      }
      public void addComboBox(JComboBox cbox){
            JF.add(cbox);
            cboxs.add(cbox);
            
            JF.pack();
      }
      public void addSeparator(JSeparator sp){
            sp.setBackground(Color.BLUE);
            //sp.setBorder(new LineBorder(sp.getBackground(), 10));
            JF.add(sp);
            seps.add(sp);
            
            JF.pack();
      }
      //+++++++++++++++++++++++++++++
      //private void 
      //+++++++++++++++++++++++++++++
      public ArrayList<JButton> getBTNS(){
            return btns;
      }
      public ArrayList<JComboBox> getCBOXS(){
            return cboxs;
      }
      public void setVisible(boolean b){
            JF.setVisible(b);
      }
      
      public VT(){
            JF.setDefaultCloseOperation(2);
            JF.setTitle("Test Window");
            JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
            //++++++++++++++++++++++++++++++++++
      }
}
