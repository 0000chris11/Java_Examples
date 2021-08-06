/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.jtree;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;

/**
 *
 * @author C0FII
 */
public class JTree2CellEditor extends AbstractCellEditor implements TreeCellEditor {

      transient JTree2CellRenderer renderer = new JTree2CellRenderer();
      DefaultMutableTreeNode editedNode;
      transient Object uo;

      JTree jtree;

      public JTree2CellEditor(JTree jtree) {
            this.jtree = jtree;
      }

      @Override
      public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
            System.out.println("getTreeCellEditorComponent");
            //this method won't be call until isCellEditable method return true

            Component editor = renderer.getTreeCellRendererComponent(tree, value,
                    true, expanded, leaf, row, true);

            //+++++++++++++++++++++++++++++++++++++++++++++++
            ItemListener itemListener = i -> {
                  tree.repaint();
                  fireEditingStopped();
            };
            //+++++++++++++++++++++++++++++++++++++++++++++++
            if (editor instanceof JCheckBox) {
                  ((JCheckBox) editor).addItemListener(itemListener);
            }

            return editor;
      }

      @Override
      public Object getCellEditorValue() {
            System.out.println("getCellEditorValue: ");
            /*
            if(UO instanceof JToggleButton){
                  returnValue = (JToggleButton) UO;
            }else if(UO instanceof CheckBoxNode){
                  returnValue = (CheckBoxNode) UO;
            }else{
                  returnValue = UO;
            }
             */
            return "dddddd";
      }

      @Override
      public boolean isCellEditable(EventObject anEvent) {
            System.out.println("isCellEditable");
            //System for get a small range/area for to activated

            boolean returnValue = false;

            if (anEvent instanceof MouseEvent) {
                  MouseEvent mouseEvent = (MouseEvent) anEvent;
                  TreePath path = jtree.getPathForLocation(mouseEvent.getX(),
                          mouseEvent.getY());
                  if (path != null) {
                        uo = path.getLastPathComponent();
                        if (uo instanceof DefaultMutableTreeNode) {
                              editedNode = (DefaultMutableTreeNode) uo;
                              Object userObject = editedNode.getUserObject();
                              if (userObject instanceof JCheckBox) {
                                    //System.out.println("JToggleButton");
                                    //System.out.println("CheckBox");
                                    Rectangle r = jtree.getPathBounds(path);
                                    int x = mouseEvent.getX() - r.x;
                                    //int y = mouseEvent.getY() - r.y;

                                    JCheckBox checkbox = renderer.getCheckBoxLeaf();

                                    checkbox.setText("");//????????????????

                                    returnValue
                                            = userObject instanceof CheckBoxNode
                                            && x > 0
                                            && x < checkbox.getPreferredSize().width;
                              } else {
                                    returnValue = true;

                              }
                        }
                  }
            }
            return returnValue;
      }
}
