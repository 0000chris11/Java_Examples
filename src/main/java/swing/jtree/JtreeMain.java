/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.jtree;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author C0FII
 */
public class JtreeMain {

        JFrame jf = new JFrame();

        static JTree jtree;
        JScrollPane scJtree;

        static JTree jtree2;
        JScrollPane scJtree2;

        private DefaultMutableTreeNode getDefaultMutableTreeNode() {

                DefaultMutableTreeNode root = new DefaultMutableTreeNode("Best Characters");

                root.add(new DefaultMutableTreeNode("Males"));
                ((DefaultMutableTreeNode) root.getChildAt(0)).add(new DefaultMutableTreeNode("MOM"));
                ((DefaultMutableTreeNode) root.getChildAt(0)).add(new DefaultMutableTreeNode("Kurapika"));
                ((DefaultMutableTreeNode) root.getChildAt(0)).add(new DefaultMutableTreeNode("Solid Snake"));

                root.add(new DefaultMutableTreeNode("Females"));
                ((DefaultMutableTreeNode) root.getChildAt(1)).add(new DefaultMutableTreeNode("Usagi Tsukino"));
                ((DefaultMutableTreeNode) root.getChildAt(1)).add(new DefaultMutableTreeNode("Pinkie Pie"));
                ((DefaultMutableTreeNode) root.getChildAt(1)).add(new DefaultMutableTreeNode("Inaho Misora"));

                // root.add(new DefaultMutableTreeNode(new JCheckBox("beeeee")));
                return root;
        }

        private DefaultMutableTreeNode getDefaultMutableTreeNode2() {
                DefaultMutableTreeNode root = new DefaultMutableTreeNode("Main Options");

                root.add(new DefaultMutableTreeNode("OLD JTextFields"));
                ((DefaultMutableTreeNode) root.getChildAt(0))
                                .add(new DefaultMutableTreeNode(new TextFieldNode("TF_1")));
                ((DefaultMutableTreeNode) root.getChildAt(0))
                                .add(new DefaultMutableTreeNode(new TextFieldNode("TF_2")));
                ((DefaultMutableTreeNode) root.getChildAt(0))
                                .add(new DefaultMutableTreeNode(new TextFieldNode("TF_3")));

                root.add(new DefaultMutableTreeNode("OLD JCheckBoxs"));
                ((DefaultMutableTreeNode) root.getChildAt(1))
                                .add(new DefaultMutableTreeNode(new CheckBoxNode("CB_1", true)));
                ((DefaultMutableTreeNode) root.getChildAt(1))
                                .add(new DefaultMutableTreeNode(new CheckBoxNode("CB_2", false)));
                ((DefaultMutableTreeNode) root.getChildAt(1))
                                .add(new DefaultMutableTreeNode(new CheckBoxNode("CB_3", true)));

                root.add(new DefaultMutableTreeNode("JToggleButtons"));
                ((DefaultMutableTreeNode) root.getChildAt(2))
                                .add(new DefaultMutableTreeNode(new JToggleButton("TB_1", false)));
                ((DefaultMutableTreeNode) root.getChildAt(2))
                                .add(new DefaultMutableTreeNode(new JToggleButton("TB_2", true)));
                ((DefaultMutableTreeNode) root.getChildAt(2))
                                .add(new DefaultMutableTreeNode(new JToggleButton("TB_3", true)));

                root.add(new DefaultMutableTreeNode("JCheckBoxs 2"));
                ((DefaultMutableTreeNode) root.getChildAt(3))
                                .add(new DefaultMutableTreeNode(new JCheckBox("CB2_1", true)));
                ((DefaultMutableTreeNode) root.getChildAt(3))
                                .add(new DefaultMutableTreeNode(new JCheckBox("CB2_2", false)));
                ((DefaultMutableTreeNode) root.getChildAt(3))
                                .add(new DefaultMutableTreeNode(new JCheckBox("CB2_3", false)));
                ((DefaultMutableTreeNode) root.getChildAt(3))
                                .add(new DefaultMutableTreeNode(new JCheckBox("CB2_4", false)));
                ((DefaultMutableTreeNode) root.getChildAt(3))
                                .add(new DefaultMutableTreeNode(new JCheckBox("CB2_5", true)));
                // +++++++++++++++++++++++++++
                addActionListenerToJToggleButtons(root);
                addItemListenerToJCheckbox(root);
                return root;
        }

        private void addActionListenerToJToggleButtons(DefaultMutableTreeNode root) {
                for (int a = 0; a < root.getChildAt(2).getChildCount(); a++) {
                        Object object = ((DefaultMutableTreeNode) root.getChildAt(2).getChildAt(a)).getUserObject();

                        if (object instanceof JToggleButton) {
                                ((JToggleButton) object).addActionListener(
                                                s -> System.out.println(s.getActionCommand() + " selected"));
                        }
                }
        }

        private void addItemListenerToJCheckbox(DefaultMutableTreeNode root) {
                for (int a = 0; a < root.getChildAt(3).getChildCount(); a++) {
                        Object object = ((DefaultMutableTreeNode) root.getChildAt(3).getChildAt(a)).getUserObject();

                        if (object instanceof JCheckBox) {
                                ((JCheckBox) object).addItemListener(e -> System.out
                                                .println(((JCheckBox) e.getSource()).getText() + " changed"));
                        }
                }
        }

        private void frameConfig() {
                jf.setDefaultCloseOperation(3);
                jf.setAlwaysOnTop(true);
                jf.setLayout(null);
                jf.getContentPane().setBackground(Color.LIGHT_GRAY);
                jf.setLocationRelativeTo(null);
                jf.setSize(942, 644);
        }

        private void treeConfig() {
                jtree = new JTree(getDefaultMutableTreeNode());
                scJtree = new JScrollPane(jtree);

                jf.add(scJtree);
                jtree.setLocation(0, 0);
                scJtree.setSize(jf.getWidth() / 2, jf.getHeight() - 30);

                jtree.setEditable(false);
                jtree.setRootVisible(false);
                jtree.setShowsRootHandles(true);
                jtree.setRowHeight(26);

                jtree.putClientProperty("JTree.lineStyle", "Horizontal");
                // JTE.putClientProperty("JTree.lineStyle", "None");

                jtree.setBackground(Color.BLACK);
                jtree.setSize(400, 800);
                jtree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
                jtree.addTreeSelectionListener(new JTreeSelectionListener());
                jtree.setCellRenderer(new JTreeCellRenderer());
        }

        private void treeConfig2() {
                jtree2 = new JTree(getDefaultMutableTreeNode2());
                scJtree2 = new JScrollPane(jtree2);

                jf.add(scJtree2);
                jtree2.setLocation(0, 0);
                scJtree2.setLocation(scJtree.getX() + scJtree.getWidth() + 4, scJtree.getY());
                scJtree2.setSize(scJtree.getSize());

                jtree2.setEditable(true);
                jtree2.setRootVisible(false);
                jtree2.setShowsRootHandles(true);
                jtree2.setRowHeight(26);

                jtree2.putClientProperty("JTree.lineStyle", "Horizontal");
                // JTE2.putClientProperty("JTree.lineStyle", "None");

                jtree2.setBackground(Color.BLACK);
                jtree2.setSize(400, 800);
                jtree2.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
                // JTE2.addTreeSelectionListener(new JTE_SL());
                jtree2.setCellRenderer(new JTree2CellRenderer());
                jtree2.setCellEditor(new JTree2CellEditor(jtree2));
        }

        JtreeMain() {
                System.out.println();
                frameConfig();
                // ++++++++++++++++++++++++++++++++++++++++++++++
                treeConfig();
                treeConfig2();
                // ++++++++++++++++++++++++++++++++++++++++++++++
                jf.setVisible(true);
        }

        public static void main(String[] args) {
                new JtreeMain();
        }
}
