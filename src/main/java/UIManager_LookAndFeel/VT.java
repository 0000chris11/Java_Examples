/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIManager_LookAndFeel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Christopher
 */
public class VT {

      JFrame JF = new JFrame("Test Window");

      JPanel JP = new JPanel();
      JLabel lb = new JLabel("Test Label");
      JTextField tf = new JTextField();
      JButton btn_p = new JButton("Test Button");
      JCheckBox cb = new JCheckBox("Tesst CheckBox");

      JMenuBar JMB = new JMenuBar();
      JMenu JM = new JMenu("Test Menu");
      JMenuItem MI = new JMenuItem("Test item");

      JToolBar JTB = new JToolBar();
      JButton btn_tb = new JButton("TB");

      JTable JT = new JTable(20, 4);
      JScrollPane SC_JT;

      JTree JTE;
      JScrollPane SC_JTE;

      static void setLookAndFeel(String className) {
            System.out.println("'\nsetLookAndFeel - > " + className);
            try {
                  UIManager.setLookAndFeel(
                          className);
            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                  ex.printStackTrace();
            }
      }
      
      private void frameConfig() {
            JF.setDefaultCloseOperation(3);
            JF.setAlwaysOnTop(true);
            JF.setLayout(new BorderLayout(2, 2));

            JF.setLocationRelativeTo(null);
            JF.setSize(500, 400);
      }

      private void tableConfig() {
            for (int col = 0; col < JT.getColumnCount(); col++) {
                  for (int row = 0; row < JT.getRowCount(); row++) {
                        JT.getModel().setValueAt(
                                "position [" + row + ", " + col + "]", 
                                row, col);
                        
                  }
            }
      }
      
      private DefaultMutableTreeNode treeConfig(){
            DefaultMutableTreeNode root = new DefaultMutableTreeNode();
            
            root.add(new DefaultMutableTreeNode("Video"));
            ((DefaultMutableTreeNode)root.getChildAt(0)).add(
                    new DefaultMutableTreeNode("Full-Screen"));
            ((DefaultMutableTreeNode)root.getChildAt(0)).add(
                    new DefaultMutableTreeNode("Window Size"));
            
            root.add(new DefaultMutableTreeNode("Sound"));
            ((DefaultMutableTreeNode)root.getChildAt(1)).add(
                    new DefaultMutableTreeNode("Allow Audio"));
            ((DefaultMutableTreeNode)root.getChildAt(1)).add(
                    new DefaultMutableTreeNode("Stereo"));
            ((DefaultMutableTreeNode)root.getChildAt(1)).add(
                    new DefaultMutableTreeNode("Mono"));
            
            root.add(new DefaultMutableTreeNode("UI"));
            ((DefaultMutableTreeNode)root.getChildAt(2)).add(
                    new DefaultMutableTreeNode("Simple"));
            ((DefaultMutableTreeNode)root.getChildAt(2)).add(
                    new DefaultMutableTreeNode("Full"));
            
            return root;
      }
      //++++++++++++++++++++++++++++++++++
      private void printComponentsJF(){
            //JF.getComponent(0).get
      }
      //++++++++++++++++++++++++++++++++++
      public VT() {
            frameConfig();
            
            JP.setLayout(new BoxLayout(JP, BoxLayout.Y_AXIS));
            JP.setBackground(Color.DARK_GRAY);
            //+++++++++++++++++++++++++++++++++++
            JP.add(lb);
            lb.setForeground(Color.WHITE);
            JP.add(tf);
            tf.setBackground(Color.LIGHT_GRAY);
            tf.setMaximumSize(new Dimension(btn_p.getMaximumSize().width,
                    tf.getPreferredSize().height));

            JP.add(btn_p);
            //+++++++++++++++++++++++++++++++++++
            JMB.add(JM);
            JM.add(MI);
            //+++++++++++++++++++++++++++++++++++
            JTB.setBackground(Color.LIGHT_GRAY);
            JTB.add(btn_tb);
            //+++++++++++++++++++++++++++++++++++
            tableConfig();
            SC_JT = new JScrollPane(JT);
            //+++++++++++++++++++++++++++++++++++
            JTE = new JTree(treeConfig());
            SC_JTE = new JScrollPane(JTE);
            SC_JTE.setMaximumSize(new Dimension(SC_JTE.getMaximumSize().width, 90));
            SC_JTE.setMaximumSize(new Dimension(SC_JTE.getMaximumSize().width, 40));
            //+++++++++++++++++++++++++++++++++++
            JF.add(SC_JTE, BorderLayout.WEST);
            JF.add(JP, BorderLayout.SOUTH);
            JF.add(JMB, BorderLayout.NORTH);
            JF.add(JTB, BorderLayout.EAST);
            
            JF.add(SC_JT, BorderLayout.CENTER);
            
            JF.setVisible(true);
      }
}
