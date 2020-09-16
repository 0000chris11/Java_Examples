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
 * @author Christopher
 */
public class MM {

      //++++++++++++++++++++++++++++++++++++++++++
      public static void setComponentToCenterJFrame(JComponent JC, JFrame JF) {
            JC.setBounds(2, 2,
                    JF.getWidth() - 21,
                    JF.getHeight() - 44);
            //System.out.println("JP Bounds: " + jc.getBounds());
      }

      public static void setComponentFitOnJFrame(JComponent jc, JFrame jf) {
            jc.setBounds(2, 2,
                    jf.getWidth() - 21,
                    jf.getHeight() - 44);

            System.out.println("JP Bounds: " + jc.getBounds());
      }
      //DELETE+LATER+++++++++++++++++++++++++++++++++++++++++
      public static ImageIcon resizeIcon(ImageIcon ii, int imageType) {
            //+++++++++++++++++++++++++++++++++++++++++++++++++
            BufferedImage bimage = new BufferedImage(225, 225, imageType);
            Graphics2D g2 = bimage.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g2.drawImage(ii.getImage(), 0, 0, 225, 225, null);

            ImageIcon icon2 = new ImageIcon(bimage);

            //System.out.println("------------------------Icon2 Width: " + icon2.getIconWidth() + "\tHeight: " + icon2.getIconHeight());
            return icon2;
            //++++++++++++++++++++++++++++++++++++++++++++++++++
      }
      //++++++++++++++++++++++++++++++++++++++++++
      public static BufferedImage changeImageColorOfOneColor(File F, Color C) {
            BufferedImage bimage = null;
            try {
                  bimage = ImageIO.read(F);

                  int w = bimage.getWidth();
                  int h = bimage.getHeight();

                  for (int a = 0; a < h; a++) {
                        for (int b = 0; b < w; b++) {
                              int rgb = bimage.getRGB(b, a);
                              //System.out.println("RGB on [" + rgb + "]");
                              if (rgb != 0) {
                                    //PAINTING ONLY WHEN THERE IS COLOR
                                    bimage.setRGB(b, a, C.getRGB());
                              }
                        }
                  }
            } catch (IOException ex) {
                  ex.printStackTrace();
            }
            return bimage;
      }
     
      public static BufferedImage resizeImage(File F, int x, int y){
            BufferedImage bimage = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bimage.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g2.drawImage(new ImageIcon(F.toString()).getImage(), 
                    0, 0, x, y, null);
            
            
            
            return bimage;
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
