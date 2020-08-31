/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAMethods;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

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
}
