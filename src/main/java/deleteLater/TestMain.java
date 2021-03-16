/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deleteLater;

import com.cofii2.methods.MComp;
import com.cofii2.methods.MList;
import com.cofii2.myAClasses.MLayout;
import com.cofii2.stores.MArrays;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Christopher
 */
public class TestMain {
      
      static final int max = 6;
      
      JFrame JF = new JFrame();
      JPanel JP = new JPanel();
      
      JLabel[] lbs = new JLabel[max];
      JTextField[] tfs = new JTextField[max];
      JButton[]  btns = new JButton[max];
      JComponent[] comps = new JComponent[]{new JLabel("Column 1"), new JTextField(), new JButton("PRESS 1")};
      
      public TestMain(){
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setLayout(new BorderLayout(2,2));
            JF.getContentPane().add(JP, BorderLayout.CENTER);
            JP.setBackground(Color.BLACK);
            
            for(int a = 0; a < max; a++){
                  lbs[a] = new JLabel("Column " + (a + 1));
                  lbs[a].setForeground(Color.WHITE);
                  
                  tfs[a] = new JTextField();
                  btns[a] = new JButton("PRESS " + (a + 1));
            }
            
            //MLayout.lineSequence(gl, components);
            MArrays ma = new MArrays();
            ma.addArray(lbs);
            ma.addArray(tfs);
            ma.addArray(btns);

            JComponent[][] components = ma.getDoubleArrayComponents(false);
            MList.printFor(components);
            
            GroupLayout gl = new GroupLayout(JP);
            JP.setLayout(gl);
            MLayout.lineSequence(gl, components);
      }
      
      
      public static void main(String[] args){
            SwingUtilities.invokeLater(new Runnable(){
                  @Override
                  public void run() {
                        TestMain tm = new TestMain();
                        tm.JF.setSize(500, 400);
                        MComp.setFrameToCenterOfScreen(tm.JF);
                        tm.JF.setVisible(true);
                        
                  }
                  
            });
      }
}
