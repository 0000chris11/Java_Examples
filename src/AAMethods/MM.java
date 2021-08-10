/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAMethods;

import JTree_EX.CheckBoxNode;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

/**
 *
 * @author C0FII
 */
public class MM {

      private MM(){
            super();
            throw new IllegalStateException("PRIVATE CONSTRUCTOR");
      }
      //++++++++++++++++++++++++++++++++++++++++++
      public static void setComponentFitOnJFrame(JComponent jc, JFrame jf) {
            jc.setBounds(2, 2,
                    jf.getWidth() - 21,
                    jf.getHeight() - 44);

            System.out.println("JP Bounds: " + jc.getBounds());
      }
      //+++++++++++++++++++++++++++++++++++++++++++
      public static boolean isCellEditableForCheckBoxAndDefaults(EventObject anEvent, JTree JTE, 
              DefaultMutableTreeNode editedNode){
            boolean returnValue = false;

            if (anEvent instanceof MouseEvent) {
                  MouseEvent mouseEvent = (MouseEvent) anEvent;
                  TreePath path = JTE.getPathForLocation(mouseEvent.getX(),
                          mouseEvent.getY());
                  if (path != null) {
                        Object ob = path.getLastPathComponent();
                        if ((ob != null) && (ob instanceof DefaultMutableTreeNode)) {
                              editedNode = (DefaultMutableTreeNode) ob;
                              Object userObject = editedNode.getUserObject();
                              if (userObject instanceof JCheckBox) {
                                    //System.out.println("JToggleButton");
                                    //System.out.println("CheckBox");
                                    Rectangle r = JTE.getPathBounds(path);
                                    int x = mouseEvent.getX() - r.x;
                                    int y = mouseEvent.getY() - r.y;

                                    JCheckBox checkbox = (JCheckBox) userObject;

                                    checkbox.setText("");//????????????????

                                    returnValue
                                            = userObject instanceof JCheckBox
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
