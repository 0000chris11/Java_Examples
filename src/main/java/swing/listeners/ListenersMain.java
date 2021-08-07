/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.listeners;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
class ListenersMain {

      ListenersMain(){
            JFrame jf = new JFrame();
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jf.setSize(new Dimension(400, 200));
            jf.getContentPane().setLayout(new BoxLayout(jf.getContentPane(), BoxLayout.X_AXIS));
            
            JTextField tf = new JTextField();
            jf.getContentPane().add(tf);
            tf.setPreferredSize(new Dimension(200, 28));
            
            /*
            MListeners ml = new MListeners();
            ml.addTextChangeListener("TEXT", new LTextChange(){
                  @Override
                  public void textHasChanged() {
                        
                  }
                  
            });
            */
            
            JButton btn = new JButton("Press");
            jf.getContentPane().add(btn);
            tf.setPreferredSize(new Dimension(60, 28));
            
            jf.setVisible(true);
      }
      public static void main(String[] args){
            SwingUtilities.invokeLater(ListenersMain::new);
            
      }
}
