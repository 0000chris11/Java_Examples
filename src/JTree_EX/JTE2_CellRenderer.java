/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTree_EX;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author Christopher
 */
public class JTE2_CellRenderer extends DefaultTreeCellRenderer
        implements TreeCellRenderer {

      private JCheckBox checkBoxLeaf = new JCheckBox();
      private JTextField textFieldLeaf = new JTextField();

      private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();

      Color CB_selectionBorderColor, CB_selectionForeground, CB_selectionBackground,
              CB_textForeground, CB_textBackground;

      Color selectionBorderColor, normalBorderColor;
      LineBorder selectionBorder = new LineBorder(Color.WHITE, 2);
      LineBorder normalBorder = new LineBorder(Color.GRAY, 2);

      //++++++++++++++++++++++++++++++++++++++
      protected JCheckBox getCheckBoxLeaf() {
            return checkBoxLeaf;
      }

      protected JTextField getTextFieldLeaf() {
            return textFieldLeaf;
      }

      //+++++++++++++++++++++++++++++++++++++
      private void checkBoxConfig() {
            Boolean booleanValue = (Boolean) UIManager
                    .get("Tree.drawsFocusBorderAroundIcon");

            checkBoxLeaf.setFocusPainted((booleanValue != null)
                    && (booleanValue.booleanValue()));

            //++++++++++++++++++++++++++++++++++++++++++++++
            //selectionBorderColor = UIManager.getColor("Tree.CB_selectionBorderColor");
            CB_selectionForeground = Color.BLACK;
            CB_selectionBackground = new Color(Color.CYAN.getRed(),
                    Color.CYAN.getGreen(), Color.CYAN.getBlue(), 100);
            CB_textForeground = Color.WHITE;
            //textBackground = UIManager.getColor("Tree.CB_textBackground");
            CB_textBackground = new Color(0, 0, 0, 0);
      }

      private void textFieldConfig() {
            selectionBorderColor = Color.WHITE;
            normalBorderColor = Color.GRAY;

            textFieldLeaf.setForeground(Color.WHITE);
            textFieldLeaf.setBackground(Color.DARK_GRAY);
            textFieldLeaf.setPreferredSize(new Dimension(200,
                    textFieldLeaf.getPreferredSize().height));
      }

      public JTE2_CellRenderer() {

            checkBoxConfig();
            textFieldConfig();
            //DEFAULT (+ NON-LEAFS)
            this.setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));
            this.setBackgroundSelectionColor(Color.CYAN);
            this.setTextNonSelectionColor(Color.WHITE);
            this.setTextSelectionColor(Color.BLACK);
      }

      @Override
      public Component getTreeCellRendererComponent(
              JTree tree, Object value, boolean selected, boolean expanded, boolean leaf,
              int row, boolean hasFocus) {

            Component returnValue;
            Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            //++++++++++++++++++++++++++++++++++++++++
            checkBoxLeaf.setText(value.toString());
            JComponent cp = null;
            //JToggleButton jtg = null;

            if (node.isLeaf()) {
                  if (userObject instanceof CheckBoxNode) {
                        //OLD WAY
                        boolean isSel = ((CheckBoxNode) userObject).isSelected();
                        //System.out.println("isSelected: " + isSel);
                        checkBoxLeaf.setSelected(isSel);
                        returnValue = checkBoxLeaf;

                  } else if (userObject instanceof TextFieldNode) {
                        //OLD WAY
                        textFieldLeaf.setText(((TextFieldNode) userObject).getText());
                        returnValue = textFieldLeaf;

                  } else if (userObject instanceof JToggleButton) {
                        //jtg = (JToggleButton) userObject;
                        cp = (JComponent) userObject;
                        cp.setPreferredSize(new Dimension(40, cp.getPreferredSize().height));
                        //System.out.println(jtg.getText() + " is a instance of JToggleButton");
                        returnValue = (JToggleButton) cp;

                  } else {
                        super.getTreeCellRendererComponent(
                                tree, value, selected,
                                expanded, leaf, row,
                                hasFocus);

                        return returnValue = this;
                  }
            } else {
                  super.getTreeCellRendererComponent(
                          tree, value, selected,
                          expanded, leaf, row,
                          hasFocus);

                  return returnValue = this;
            }
            //checkBoxLeaf.setEnabled(tree.isEnabled());
            //++++++++++++++++++++++++++++++++++++++++++++
            if (selected) {
                  checkBoxLeaf.setForeground(CB_selectionForeground);
                  checkBoxLeaf.setBackground(CB_selectionBackground);
                  textFieldLeaf.setBorder(selectionBorder);
                  if (cp != null) {
                        cp.setBorder(selectionBorder);
                  }
            } else {
                  checkBoxLeaf.setForeground(CB_textForeground);
                  checkBoxLeaf.setBackground(CB_textBackground);
                  textFieldLeaf.setBorder(normalBorder);
                  if (cp != null) {
                        cp.setBorder(normalBorder);
                  }
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++

            return returnValue;
      }

}
