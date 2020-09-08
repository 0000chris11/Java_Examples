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
public class JTE2_CellRenderer extends DefaultTreeCellRenderer implements TreeCellRenderer {

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
            //this.setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));
            //checkBoxLeaf.setFont();

            Boolean booleanValue = (Boolean) UIManager
                    .get("Tree.drawsFocusBorderAroundIcon");

            checkBoxLeaf.setFocusPainted((booleanValue != null)
                    && (booleanValue.booleanValue()));

            //++++++++++++++++++++++++++++++++++++++++++++++
            //selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
            selectionForeground = Color.BLACK;
            selectionBackground = new Color(Color.CYAN.getRed(),
                    Color.CYAN.getGreen(), Color.CYAN.getBlue(), 100);
            textForeground = Color.WHITE;
            //textBackground = UIManager.getColor("Tree.textBackground");
            textBackground = new Color(0, 0, 0, 0);
            //DefaultVALUES++++++++++++++++++++++++++++++++++++++++++++++
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

            //System.out.println("userObject: " + 
              //      ((DefaultMutableTreeNode) value).getUserObject());
            
            Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
            checkBoxLeaf.setText(value.toString());
            
            if (userObject instanceof CheckBoxNode) {
                  boolean isSel = ((CheckBoxNode) userObject).isSelected();
                  //System.out.println("isSelected: " + isSel);
                  checkBoxLeaf.setSelected(isSel);
            }
            //checkBoxLeaf.setEnabled(tree.isEnabled());

            if (selected) {
                  checkBoxLeaf.setForeground(selectionForeground);
                  checkBoxLeaf.setBackground(selectionBackground);
            } else {
                  checkBoxLeaf.setForeground(textForeground);
                  checkBoxLeaf.setBackground(textBackground);
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            if (node.isLeaf()) {
                  returnValue = checkBoxLeaf;
            } else {
                  super.getTreeCellRendererComponent(
                          tree, value, selected,
                          expanded, leaf, row,
                          hasFocus);

                  returnValue = this;
            }

            return returnValue;
      }

}
