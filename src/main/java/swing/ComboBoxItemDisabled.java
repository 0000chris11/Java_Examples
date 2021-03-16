/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class ComboBoxItemDisabled {
      
      JFrame JF = new JFrame();
      JPanel JP = new JPanel();
      
      JComboBox<String> cb = new JComboBox<>(new String[]{"ITEM 1", "ITEM 2", "ITEM 3", "ITEM 4"});
      JToggleButton btn = new JToggleButton();
      
      ComboBoxItemDisabled(){
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setLayout(new BorderLayout());
            JF.getContentPane().add(JP, BorderLayout.CENTER);
            JF.setSize(300, 300);
            JP.setBackground(Color.BLACK);
            JP.setLayout(new BoxLayout(JP, BoxLayout.Y_AXIS));
            JP.add(cb);
            cb.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            JP.add(Box.createVerticalGlue());
            JP.add(btn);
            btn.setText("ITEM 2");
            btn.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        JButton[] buttons = new JButton[2];
                        for(int a = 0; a < buttons.length; a++){
                              buttons[a] = new JButton("B" + (a + 1));
                        }
                        //new VO("VO", "DELETE?", buttons);
                  }
                  
            });
            
      }
      public static void main(String[] args){
            ComboBoxItemDisabled c = new ComboBoxItemDisabled();
            c.JF.setVisible(true);
      }
}
