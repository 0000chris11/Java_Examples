/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTree_EX;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author Christopher
 */
public class JTE2_CellRenderer implements TreeCellRenderer {

      private JCheckBox checkBoxLeaf = new JCheckBox();
      private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();

      Color selectionBorderColor, selectionForeground, selectionBackground,
              textForeground, textBackground;

      //++++++++++++++++++++++++++++++++++++++
      protected JCheckBox getCheckBoxLeaf() {
            return checkBoxLeaf;
      }

      //+++++++++++++++++++++++++++++++++++++
      public JTE2_CellRenderer() {
            Font fontValue;
            fontValue = UIManager.getFont("Tree.font");
            if (fontValue != null) {
                  checkBoxLeaf.setFont(fontValue);
            }
            Boolean booleanValue = (Boolean) UIManager
                    .get("Tree.drawsFocusBorderAroundIcon");

            checkBoxLeaf.setFocusPainted((booleanValue != null)
                    && (booleanValue.booleanValue()));

            selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
            selectionForeground = UIManager.getColor("Tree.selectionForeground");
            selectionBackground = UIManager.getColor("Tree.selectionBackground");
            textForeground = UIManager.getColor("Tree.textForeground");
            textBackground = UIManager.getColor("Tree.textBackground");
      }

      @Override
      public Component getTreeCellRendererComponent(
              JTree tree, Object value, boolean selected, boolean expanded, boolean leaf,
              int row, boolean hasFocus) {

            Component returnValue;

            System.out.println("Value: " + value);
            String stringValue = tree.convertValueToText(value, selected,
                    expanded, leaf, row, false);
            System.out.println("StringValue: " + stringValue);

            checkBoxLeaf.setText(stringValue);
            checkBoxLeaf.setSelected(false);

            checkBoxLeaf.setEnabled(tree.isEnabled());

            if (selected) {
                  checkBoxLeaf.setForeground(selectionForeground);
                  checkBoxLeaf.setBackground(selectionBackground);
            } else {
                  checkBoxLeaf.setForeground(textForeground);
                  checkBoxLeaf.setBackground(textBackground);
            }

            if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
                  Object userObject = ((DefaultMutableTreeNode) value)
                          .getUserObject();
                  if (userObject instanceof Delete_Later.CheckBoxNode) {
                        Delete_Later.CheckBoxNode node = (Delete_Later.CheckBoxNode) userObject;
                        checkBoxLeaf.setText(node.getText());
                        checkBoxLeaf.setSelected(node.isSelected());
                  }
            }
            returnValue = checkBoxLeaf;
            return returnValue;
      }

}
