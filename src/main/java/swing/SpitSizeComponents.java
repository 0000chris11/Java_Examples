/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.cofii2.methods.MComp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class SpitSizeComponents {

      private JFrame JF = new JFrame();

      private JSplitPane SP = new JSplitPane();
      private JPanel JP = new JPanel();

      private JLabel lb1 = new JLabel("LABEL 1", SwingConstants.CENTER);
      private JLabel lb2 = new JLabel("LABEL 2", SwingConstants.CENTER);
      private JLabel lb3 = new JLabel("LABEL 3", SwingConstants.CENTER);

      private JButton btn_change = new JButton("Change Size");
      private JButton btn_info = new JButton("Info");

      private SpitSizeComponents() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setLayout(new BorderLayout());

            JF.getContentPane().add(SP, BorderLayout.CENTER);
            JF.getContentPane().add(JP, BorderLayout.SOUTH);

            SP.setLeftComponent(lb1);
            SP.setRightComponent(lb2);

            JP.setBackground(Color.BLACK);
            JP.setLayout(new BoxLayout(JP, BoxLayout.X_AXIS));
            JP.add(btn_change, 0);
            JP.add(Box.createHorizontalGlue(), 1);
            JP.add(btn_info, 2);
            
            btn_change.setMaximumSize(new Dimension(180, 28));
            btn_change.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        int location = SP.getDividerLocation();
                        System.out.println("\nDivider Location: " + location);
                        
                        if (SP.getRightComponent() == lb2) {
                              //Dimension size = lb2.getSize();
                              SP.setRightComponent(lb3);
                              //SP.getRightComponent().setSize(size);
                              
                        }else if(SP.getRightComponent() == lb3){
                              //Dimension size = lb3.getSize();
                              SP.setRightComponent(lb2);
                              //SP.getRightComponent().setSize(size);
                        }
                        SP.setDividerLocation(location);
                        System.out.println("then Divider Location: " + location);
                  }

            });
            
            btn_info.setMaximumSize(new Dimension(180, 28));
            btn_info.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println("\nLEFT COMPONENT SIZE: " + lb1.getSize());
                        System.out.println("RIGHT COMPONENT SIZE: " + SP.getRightComponent().getSize());
                  }
                  
            });

      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        SpitSizeComponents tt = new SpitSizeComponents();
                        tt.JF.setSize(new Dimension(300, 200));
                        MComp.setFrameToCenterOfScreen(tt.JF);
                        tt.JF.setVisible(true);
                  }

            });
      }
}
