/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delete_Later;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public class CheckBoxNodeTreeSample {

      public static void main(String args[]) {
            try {
                  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e1) {
                  e1.printStackTrace();
            }
            //++++++++++++++++++++++++++++++++++++++
            JFrame frame = new JFrame("WINDOW CheckBox Tree");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //++++++++++++++++++++++++++++++++++++++
            Vector groupVector = new Vector();

            Vector group1 = new Vector();
            group1.add("Group1");
            group1.add("child1");
            group1.add("child2");
            group1.add("child3");

            Vector group2 = new Vector();
            group2.add("Group2");
            group2.add("child2");
            group2.add("child4");
            group2.add("child5");

            Vector noGroup = new Vector();
            noGroup.add("No Group");
            noGroup.add("child6");
            noGroup.add("child7");
            noGroup.add("child8");

            groupVector.add(noGroup);
            groupVector.add(group1);
            groupVector.add(group2);

            Vector children_to_be_checked = new Vector();//CHILDREN WHICH ARE TO BE CHECKED
            children_to_be_checked.add("child2");
            children_to_be_checked.add("child4");
            children_to_be_checked.add("child8");
            //++++++++++++++++++++++++++++++++++++++++++++++++
            final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");

            for (int i = 0; i < groupVector.size(); i++) {
                  String group = ((Vector) groupVector.elementAt(i)).elementAt(0).toString();

                  if (!group.equals("No Group")) {
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode(
                                new CheckBoxNode(
                                        ((Vector) groupVector.elementAt(i)).elementAt(0).toString(), false));

                        for (int j = 1; j < ((Vector) groupVector.elementAt(i)).size(); j++) {
                              boolean flag = false;
                              if (children_to_be_checked.contains(((Vector) groupVector.elementAt(i)).elementAt(j).toString())) {
                                    flag = true;
                              }
                              node.add(new DefaultMutableTreeNode(new CheckBoxNode(
                                      ((Vector) groupVector.elementAt(i)).elementAt(j).toString(), flag)));
                        }
                        rootNode.add(node);
                  } else {
                        for (int j = 1; j < ((Vector) groupVector.elementAt(i)).size(); j++) {
                              boolean flag = false;
                              if (children_to_be_checked.contains(
                                      ((Vector) groupVector.elementAt(i)).elementAt(j).toString())) {
                                    flag = true;
                              }
                              rootNode.add(new DefaultMutableTreeNode(
                                      new CheckBoxNode(
                                              ((Vector) groupVector.elementAt(i)).elementAt(j).toString(), flag)));
                        }
                  }

            }
            //++++++++++++++++++++++++++++++++++++++++++++++++
            JTree tree = new JTree(rootNode);
            tree.setToggleClickCount(1);
            tree.setRootVisible(false);
            tree.setShowsRootHandles(true);
            tree.putClientProperty("JTree.lineStyle", "None");
            CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
            tree.setCellRenderer(renderer);

            tree.setCellEditor(new CheckBoxNodeEditor(tree));
            tree.setEditable(true);

            JButton submit = new JButton("Submit");
            submit.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        if (e.getActionCommand().equals("Submit")) {
                              ArrayList<String> names = new ArrayList<String>();
                              CheckBoxNodeTreeSample cb = new CheckBoxNodeTreeSample();
                              cb.fillCheckedNodes(names, rootNode);
                        }
                  }

            });

            JScrollPane scrollPane = new JScrollPane(tree);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.add(submit);
            frame.getContentPane().add(panel, BorderLayout.PAGE_END);

            frame.setSize(150, 300);
            frame.setVisible(true);

            tree.setModel(new DefaultTreeModel(rootNode) {
                  public void valueForPathChanged(TreePath path, Object newValue) {
                        Object currNode = path.getLastPathComponent();
                        super.valueForPathChanged(path, newValue);
                        if ((currNode != null) && (currNode instanceof DefaultMutableTreeNode)) {
                              DefaultMutableTreeNode editedNode = (DefaultMutableTreeNode) currNode;
                              CheckBoxNode newCBN = (CheckBoxNode) newValue;

                              if (!editedNode.isLeaf()) {
                                    for (int i = 0; i < editedNode.getChildCount(); i++) {
                                          DefaultMutableTreeNode node = (DefaultMutableTreeNode) editedNode.getChildAt(i);
                                          CheckBoxNode cbn = (CheckBoxNode) node.getUserObject();
                                          cbn.setSelected(newCBN.isSelected());
                                    }
                              } else {
                                    boolean isAllChiledSelected = true;
                                    for (int i = 0; i < editedNode.getParent().getChildCount(); i++) {
                                          DefaultMutableTreeNode node = (DefaultMutableTreeNode) editedNode.getParent().getChildAt(i);
                                          CheckBoxNode cbn = (CheckBoxNode) node.getUserObject();
                                          if (!cbn.isSelected()) {
                                                isAllChiledSelected = false;
                                          }
                                    }

                                    if (isAllChiledSelected) {
                                          DefaultMutableTreeNode node = (DefaultMutableTreeNode) editedNode.getParent();
                                          CheckBoxNode cbn = (CheckBoxNode) node.getUserObject();
                                          cbn.setSelected(isAllChiledSelected);
                                    }
                              }

                              if (!newCBN.isSelected()) {
                                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) editedNode.getParent();
                                    if (node.getUserObject() instanceof CheckBoxNode) {
                                          ((CheckBoxNode) node.getUserObject()).setSelected(false);
                                    }
                              }
                        }
                  }
            });
      }
      //++++++++++++++++++++++++++++++++++++++++++++++

      private void fillCheckedNodes(List<String> names, DefaultMutableTreeNode node) {
            if (node.isLeaf()) {
                  CheckBoxNode cbn = (CheckBoxNode) node.getUserObject();
                  if (cbn.isSelected()) {
                        names.add(cbn.getText());
                  }
            } else {
                  for (int i = 0; i < node.getChildCount(); i++) {
                        fillCheckedNodes(names, (DefaultMutableTreeNode) node.getChildAt(i));
                  }
            }
            for (int j = 0; j < names.size(); j++) {
                  System.out.println("name of checked nodes" + names.get(j));
            }
      }

}
//==============================================

//===============================================
