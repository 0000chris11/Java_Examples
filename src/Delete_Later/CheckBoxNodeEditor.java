/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delete_Later;

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
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;

public class CheckBoxNodeEditor extends AbstractCellEditor implements TreeCellEditor{

      CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();

      ChangeEvent changeEvent = null;

      JTree tree1;

      DefaultMutableTreeNode editedNode;
      
      public CheckBoxNodeEditor(JTree tree) {
            this.tree1 = tree;
      }
      //++++++++++++++++++++++++++++++
      @Override
      public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
            Component editor = renderer.getTreeCellRendererComponent(tree, value,
                    true, expanded, leaf, row, true);
            
            ItemListener itemListener = new ItemListener() {
                  public void itemStateChanged(ItemEvent itemEvent) {
                        tree.repaint();
                        fireEditingStopped();
                  }
            };

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
            boolean returnValue = false;
            if (anEvent instanceof MouseEvent) {
                  MouseEvent mouseEvent = (MouseEvent) anEvent;
                  TreePath path = tree1.getPathForLocation(mouseEvent.getX(),
                          mouseEvent.getY());
                  if (path != null) {
                        Object node = path.getLastPathComponent();
                        if ((node != null) && (node instanceof DefaultMutableTreeNode)) {
                              editedNode = (DefaultMutableTreeNode) node;
                              Object userObject = editedNode.getUserObject();
                              
                              Rectangle r = tree1.getPathBounds(path);
                              int x = mouseEvent.getX() - r.x;
                              int y = mouseEvent.getY() - r.y;
                              JCheckBox checkbox = renderer.getCheckBoxLeaf();
                              
                              checkbox.setText("");
                              
                              System.out.println("x: " + x);
                              if(x > 0){
                                    System.out.println("\tinside (Left)");
                              }
                              if(x < checkbox.getPreferredSize().width){
                                    System.out.println("\tinside (Rigth)");
                              }
                              
                              returnValue = 
                                      userObject instanceof CheckBoxNode && 
                                      x > 0 && 
                                      x < checkbox.getPreferredSize().width;
                        }
                  }
            }
            return returnValue;
      }

}
