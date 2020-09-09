/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTree_EX;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;

/**
 *
 * @author Christopher
 */
public class JTE2_CellEditor extends AbstractCellEditor implements TreeCellEditor {

      JTE2_CellRenderer renderer = new JTE2_CellRenderer();
      
      DefaultMutableTreeNode editedNode;
      
      JTree JTE;
      
      public JTE2_CellEditor(JTree jtr){
            JTE = jtr;
      }
      
      @Override
      public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
            System.out.println("getTreeCellEditorComponent");
            //this method won't be call until isCellEditable method return true
            
            Component editor = renderer.getTreeCellRendererComponent(tree, value,
                    true, expanded, leaf, row, true);
            
            //+++++++++++++++++++++++++++++++++++++++++++++++
            ItemListener itemListener = new ItemListener() {
                  public void itemStateChanged(ItemEvent itemEvent) {
                        tree.repaint();
                        fireEditingStopped();//???????????????????????
                  }
            };
            //+++++++++++++++++++++++++++++++++++++++++++++++
            if (editor instanceof JCheckBox) {
                  ((JCheckBox) editor).addItemListener(itemListener);
            }
            
            return editor;
      }

      @Override
      public Object getCellEditorValue() {
            JCheckBox checkbox = renderer.getCheckBoxLeaf();

            CheckBoxNode checkBoxNode = new CheckBoxNode(checkbox.getText(),
                    checkbox.isSelected());

            return checkBoxNode;
      }

      @Override
      public boolean isCellEditable(EventObject anEvent) {
            System.out.println("isCellEditable");
            //System for get a small range/area for to activated
            boolean returnValue = false;
            if (anEvent instanceof MouseEvent) {
                  MouseEvent mouseEvent = (MouseEvent) anEvent;
                  TreePath path = JTE.getPathForLocation(mouseEvent.getX(),
                          mouseEvent.getY());
                  if (path != null) {
                        Object node = path.getLastPathComponent();
                        //node instanceof DefaultMutableTreeNode ?????
                        if ((node != null) && (node instanceof DefaultMutableTreeNode)) {
                              editedNode = (DefaultMutableTreeNode) node;
                              Object userObject = editedNode.getUserObject();
                              
                              Rectangle r = JTE.getPathBounds(path);
                              int x = mouseEvent.getX() - r.x;
                              int y = mouseEvent.getY() - r.y;
                              
                              JCheckBox checkbox = renderer.getCheckBoxLeaf();
                              
                              checkbox.setText("");//????????????????
                              
                              returnValue = 
                                      userObject instanceof CheckBoxNode && 
                                      x > 0 && 
                                      x < checkbox.getPreferredSize().width ;
                        }
                  }
            }
            return returnValue;
      }
}
