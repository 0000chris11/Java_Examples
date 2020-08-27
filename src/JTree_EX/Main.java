/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTree_EX;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Christopher
 */
public class Main {

      JFrame JF = new JFrame();
      JTree JTE;

      private DefaultMutableTreeNode getDefaultMutableTreeNode() {

            DefaultMutableTreeNode root = new DefaultMutableTreeNode(
                    "Best Characters");
            
            
            root.add(new DefaultMutableTreeNode("Males"));
            ((DefaultMutableTreeNode) root.getChildAt(0)).add(
                    new DefaultMutableTreeNode("MOM"));
            ((DefaultMutableTreeNode) root.getChildAt(0)).add(
                    new DefaultMutableTreeNode("Kurapika"));
            ((DefaultMutableTreeNode) root.getChildAt(0)).add(
                    new DefaultMutableTreeNode("Solid Snake"));
            
            root.add(new DefaultMutableTreeNode("Females"));
            ((DefaultMutableTreeNode) root.getChildAt(1)).add(
                    new DefaultMutableTreeNode("Usagi Tsukino"));
            ((DefaultMutableTreeNode) root.getChildAt(1)).add(
                    new DefaultMutableTreeNode("Pinkie Pie"));
            ((DefaultMutableTreeNode) root.getChildAt(1)).add(
                    new DefaultMutableTreeNode("Inaho Misora"));
             
            return root;
      }

      public Main() {
            JF.setDefaultCloseOperation(3);
            JF.setLayout(null);
            JF.getContentPane().setBackground(Color.LIGHT_GRAY);
            JF.setLocationRelativeTo(null);

            JTE = new JTree(getDefaultMutableTreeNode());
            JF.add(JTE);
            JTE.setBounds(4, 4, 150, 200);
            JTE.getSelectionModel().setSelectionMode
            (TreeSelectionModel.SINGLE_TREE_SELECTION);
            JTE.addTreeSelectionListener(new TreeSelectionListener(){
                  @Override
                  public void valueChanged(TreeSelectionEvent e) {
                        
                  }
                  
            });

            JF.setSize(171, 244);
            JF.setVisible(true);
      }

      public static void main(String[] args) {
            new Main();
      }
}
