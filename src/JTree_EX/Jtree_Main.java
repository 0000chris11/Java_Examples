/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTree_EX;

import AAMethods.MM;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.tree.TreeModel;

/**
 *
 * @author Christopher
 */
public class Jtree_Main {

      JFrame JF = new JFrame();
      
      static JTree JTE;

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

            //root.add(new DefaultMutableTreeNode(new JCheckBox("beeeee")));
            
            return root;
      }
      
      private void setBackgroundToNodes(){
            //CELLRENDERER NEEDED!!!!!!!!!!!!!!!!!!!
            TreeModel tm = JTE.getModel();
            Object o = tm.getRoot();
            for(int a = 0; a < tm.getChildCount(o); a++){
                  
                  //((DefaultMutableTreeNode) tm.getChild(o, a));
            }
      }

      private void frameConfig(){
            JF.setDefaultCloseOperation(3);
            JF.setAlwaysOnTop(true);
            JF.setLayout(null);
            JF.getContentPane().setBackground(Color.LIGHT_GRAY);
            JF.setLocationRelativeTo(null);
            JF.setSize(471, 644);
      }
      
      private void treeConfig(){
            JTE = new JTree(getDefaultMutableTreeNode());
            JScrollPane sc_JTE = new JScrollPane(JTE);
            
            JF.add(sc_JTE);
            JTE.setLocation(0, 0);
            MM.setComponentToCenterJFrame(sc_JTE, JF);
            
            JTE.setEditable(false);
            JTE.setRootVisible(false);
            JTE.setShowsRootHandles(true);
            JTE.setRowHeight(26);

            JTE.putClientProperty("JTree.lineStyle", "Horizontal");
            //JTE.putClientProperty("JTree.lineStyle", "None");
            
            JTE.setBackground(Color.DARK_GRAY);
            JTE.setSize(400, 800);
            JTE.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            JTE.addTreeSelectionListener(new JTE_SL());
            JTE.setCellRenderer(new JTE_CellRenderer());
      }
      
      public Jtree_Main() {
            frameConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++
            treeConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++
            JF.setVisible(true);
      }

      public static void main(String[] args) {
            new Jtree_Main();
      }
}
