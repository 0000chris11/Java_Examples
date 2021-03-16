/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.util.EventListener;
import java.util.EventObject;
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
public class ListenersMain {
      public ListenersMain(){
            JFrame JF = new JFrame();
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setSize(new Dimension(400, 200));
            JF.getContentPane().setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
            
            JTextField tf = new JTextField();
            JF.getContentPane().add(tf);
            tf.setPreferredSize(new Dimension(200, 28));
            
            MListeners ml = new MListeners();
            ml.addTextChangeListener("TEXT", new LTextChange(){
                  @Override
                  public void textHasChanged() {
                        
                  }
                  
            });
            
            JButton btn = new JButton("Press");
            JF.getContentPane().add(btn);
            tf.setPreferredSize(new Dimension(60, 28));
            
            JF.setVisible(true);
      }
      public static void main(String[] args){
            SwingUtilities.invokeLater(new Runnable(){
                  @Override
                  public void run() {
                        ListenersMain lm = new ListenersMain();
                  }
                  
            });
            
      }
}
