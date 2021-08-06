/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.jtree;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import amethods.MM;

import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.tree.TreeModel;

/**
 *
 * @author Christopher
 */
public class Jtree_Main {

      JFrame JF = new JFrame();

      static JTree JTE;
      JScrollPane sc_JTE;

      static JTree JTE2;
      JScrollPane sc_JTE2;

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

      private DefaultMutableTreeNode getDefaultMutableTreeNode2() {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(
                    "Main Options");

            root.add(new DefaultMutableTreeNode("OLD JTextFields"));
            ((DefaultMutableTreeNode) root.getChildAt(0)).add(
                    new DefaultMutableTreeNode(new TextFieldNode("TF_1")));
            ((DefaultMutableTreeNode) root.getChildAt(0)).add(
                    new DefaultMutableTreeNode(new TextFieldNode("TF_2")));
            ((DefaultMutableTreeNode) root.getChildAt(0)).add(
                    new DefaultMutableTreeNode(new TextFieldNode("TF_3")));

            root.add(new DefaultMutableTreeNode("OLD JCheckBoxs"));
            ((DefaultMutableTreeNode) root.getChildAt(1)).add(
                    new DefaultMutableTreeNode(new CheckBoxNode("CB_1", true)));
            ((DefaultMutableTreeNode) root.getChildAt(1)).add(
                    new DefaultMutableTreeNode(new CheckBoxNode("CB_2", false)));
            ((DefaultMutableTreeNode) root.getChildAt(1)).add(
                    new DefaultMutableTreeNode(new CheckBoxNode("CB_3", true)));

            root.add(new DefaultMutableTreeNode("JToggleButtons"));
            ((DefaultMutableTreeNode) root.getChildAt(2)).add(
                    new DefaultMutableTreeNode(new JToggleButton("TB_1", false)));
            ((DefaultMutableTreeNode) root.getChildAt(2)).add(
                    new DefaultMutableTreeNode(new JToggleButton("TB_2", true)));
            ((DefaultMutableTreeNode) root.getChildAt(2)).add(
                    new DefaultMutableTreeNode(new JToggleButton("TB_3", true)));
            
            root.add(new DefaultMutableTreeNode("JCheckBoxs 2"));
            ((DefaultMutableTreeNode) root.getChildAt(3)).add(
                    new DefaultMutableTreeNode(new JCheckBox("CB2_1", true)));
            ((DefaultMutableTreeNode) root.getChildAt(3)).add(
                    new DefaultMutableTreeNode(new JCheckBox("CB2_2", false)));
            ((DefaultMutableTreeNode) root.getChildAt(3)).add(
                    new DefaultMutableTreeNode(new JCheckBox("CB2_3", false)));
            ((DefaultMutableTreeNode) root.getChildAt(3)).add(
                    new DefaultMutableTreeNode(new JCheckBox("CB2_4", false)));
            ((DefaultMutableTreeNode) root.getChildAt(3)).add(
                    new DefaultMutableTreeNode(new JCheckBox("CB2_5", true)));
            //+++++++++++++++++++++++++++
            addActionListenerToJToggleButtons(root);
            addItemListenerToJCheckbox(root);
            return root;
      }
      
      private void addActionListenerToJToggleButtons(DefaultMutableTreeNode root){
            for (int a = 0; a < root.getChildAt(2).getChildCount(); a++) {
                  Object object = 
                          ((DefaultMutableTreeNode) root.getChildAt(2).getChildAt(a)).getUserObject();
                  
                  if(object instanceof JToggleButton){
                        ((JToggleButton) object).addActionListener(new ActionListener(){
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                    System.out.println(e.getActionCommand() + " selected");
                              }
                                    
                        });
                  }
            }
      }
      
      private void addItemListenerToJCheckbox(DefaultMutableTreeNode root){
            for (int a = 0; a < root.getChildAt(3).getChildCount(); a++) {
                  Object object = 
                          ((DefaultMutableTreeNode) root.getChildAt(3).getChildAt(a)).getUserObject();
                  
                  if(object instanceof JCheckBox){
                        ((JCheckBox) object).addItemListener(new ItemListener(){
                              @Override
                              public void itemStateChanged(ItemEvent e) {
                                    System.out.println(((JCheckBox )e.getSource()).getText() + 
                                            " changed");
                              }
                              
                        });
                  }
            }
      }

      private void frameConfig() {
            JF.setDefaultCloseOperation(3);
            JF.setAlwaysOnTop(true);
            JF.setLayout(null);
            JF.getContentPane().setBackground(Color.LIGHT_GRAY);
            JF.setLocationRelativeTo(null);
            JF.setSize(942, 644);
      }

      private void treeConfig() {
            JTE = new JTree(getDefaultMutableTreeNode());
            sc_JTE = new JScrollPane(JTE);

            JF.add(sc_JTE);
            JTE.setLocation(0, 0);
            sc_JTE.setSize(JF.getWidth() / 2, JF.getHeight() - 30);

            JTE.setEditable(false);
            JTE.setRootVisible(false);
            JTE.setShowsRootHandles(true);
            JTE.setRowHeight(26);

            JTE.putClientProperty("JTree.lineStyle", "Horizontal");
            //JTE.putClientProperty("JTree.lineStyle", "None");

            JTE.setBackground(Color.BLACK);
            JTE.setSize(400, 800);
            JTE.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            JTE.addTreeSelectionListener(new JTE_SL());
            JTE.setCellRenderer(new JTreeCellRenderer());
      }

      private void treeConfig2() {
            JTE2 = new JTree(getDefaultMutableTreeNode2());
            sc_JTE2 = new JScrollPane(JTE2);

            JF.add(sc_JTE2);
            JTE2.setLocation(0, 0);
            sc_JTE2.setLocation(sc_JTE.getX() + sc_JTE.getWidth() + 4, sc_JTE.getY());
            sc_JTE2.setSize(sc_JTE.getSize());

            JTE2.setEditable(true);
            JTE2.setRootVisible(false);
            JTE2.setShowsRootHandles(true);
            JTE2.setRowHeight(26);

            JTE2.putClientProperty("JTree.lineStyle", "Horizontal");
            //JTE2.putClientProperty("JTree.lineStyle", "None");

            JTE2.setBackground(Color.BLACK);
            JTE2.setSize(400, 800);
            JTE2.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            //JTE2.addTreeSelectionListener(new JTE_SL());
            JTE2.setCellRenderer(new JTree2CellRenderer());
            JTE2.setCellEditor(new JTree2CellEditor(JTE2));
      }

      public Jtree_Main() {
            System.out.println();
            frameConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++
            treeConfig();
            treeConfig2();
            //++++++++++++++++++++++++++++++++++++++++++++++
            JF.setVisible(true);
      }

      public static void main(String[] args) {
            new Jtree_Main();
      }
}
