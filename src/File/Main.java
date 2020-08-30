/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import AAMethods.MM;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Christopher
 */
public class Main {

      public Main() {
            //BufferedImage bimage = new BufferedImage(225, 225, 
            //      BufferedImage.TYPE_INT_ARGB);
            try {
                  File myNewPNGFile = new File("C:\\C0F\\Image\\X Icons\\Not Mine\\"
                          + "3101078.png");
                  
                  BufferedImage bimage = ImageIO.read(myNewPNGFile);
                  
                  bimage = MM.changeImageColorOfOneColor(myNewPNGFile, Color.GREEN);
                  
                  boolean b = ImageIO.write(bimage, "PNG",
                          new File("C:\\C0F\\Image\\X Icons\\Not Mine\\"
                                  + "3101078_new 4.png"));

                  //+++++++++++++++++++++++++++++++++
                  if (b == true) {
                        System.out.println("SUCCESS");
                  } else {
                        System.out.println("ERROR");
                  }

            } catch (IOException ex) {
                  ex.printStackTrace();
            }
      }

      public static void main(String[] args) {
            new Main();
      }
}
