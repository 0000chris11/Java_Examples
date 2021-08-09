/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_reusable_classes.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author C0FII
 */
public class VT {

      JFrame jf = new JFrame("Test Window");

      JPanel jp = new JPanel();
      JLabel lb = new JLabel("Test Label");
      JTextField tf = new JTextField();
      JButton btn = new JButton("Test Button");
      JCheckBox cb = new JCheckBox("Tesst CheckBox");

      JMenuBar jmb = new JMenuBar();
      JMenu jm = new JMenu("Test Menu");
      JMenuItem mi = new JMenuItem("Test item");

      JToolBar jtb = new JToolBar();
      JButton btnTb = new JButton("TB");

      JTable jt = new JTable(20, 4);
      JScrollPane scJT;

      JTree jtree;
      JScrollPane scJtree;

      public void setLookAndFeel(String className) {
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
            jf.setDefaultCloseOperation(3);
            jf.setAlwaysOnTop(true);
            jf.setLayout(new BorderLayout(2, 2));

            jf.setLocationRelativeTo(null);
            jf.setSize(500, 400);
      }

      private void tableConfig() {
            for (int col = 0; col < jt.getColumnCount(); col++) {
                  for (int row = 0; row < jt.getRowCount(); row++) {
                        jt.getModel().setValueAt(
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
      //++++++++++++++++++++++++++++++++++
      public VT() {
            frameConfig();
            
            jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
            jp.setBackground(Color.DARK_GRAY);
            //+++++++++++++++++++++++++++++++++++
            jp.add(lb);
            lb.setForeground(Color.WHITE);
            jp.add(tf);
            tf.setBackground(Color.LIGHT_GRAY);
            tf.setMaximumSize(new Dimension(btn.getMaximumSize().width,
                    tf.getPreferredSize().height));

            jp.add(btn);
            //+++++++++++++++++++++++++++++++++++
            jmb.add(jm);
            jm.add(mi);
            //+++++++++++++++++++++++++++++++++++
            jtb.setBackground(Color.LIGHT_GRAY);
            jtb.add(btnTb);
            //+++++++++++++++++++++++++++++++++++
            tableConfig();
            scJT = new JScrollPane(jt);
            //+++++++++++++++++++++++++++++++++++
            jtree = new JTree(treeConfig());
            scJtree = new JScrollPane(jtree);
            scJtree.setMaximumSize(new Dimension(scJtree.getMaximumSize().width, 90));
            scJtree.setMaximumSize(new Dimension(scJtree.getMaximumSize().width, 40));
            //+++++++++++++++++++++++++++++++++++
            jf.add(scJtree, BorderLayout.WEST);
            jf.add(jp, BorderLayout.SOUTH);
            jf.add(jmb, BorderLayout.NORTH);
            jf.add(jtb, BorderLayout.EAST);
            
            jf.add(scJT, BorderLayout.CENTER);
            
            jf.setVisible(true);
      }
}
