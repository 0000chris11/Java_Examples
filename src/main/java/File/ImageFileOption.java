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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Christopher
 */
public class ImageFileOption {

      public ImageFileOption() {
            //BufferedImage bimage = new BufferedImage(225, 225, 
            //      BufferedImage.TYPE_INT_ARGB);
            Scanner sc = new Scanner(System.in);
            //1
            System.out.print("Choose: ");
            int n = sc.nextInt();//Read what you type (save in variable)
            //+++++++++++++++++++++++++++++++++++
            String fileName = "like.png";
            File myNewPNGFile = new File("C:\\C0F\\Image\\X Icons\\Not Mine\\"
                    + fileName);
            //++++++++++++++++++++++++++++++++++
            BufferedImage bimage = null;
            boolean b = false;
            switch (n) {
                  case 1:
                        System.out.println("\tChangeColor");
                        bimage = changeColor(myNewPNGFile);
                        break;
                  case 2:
                        System.out.println("\tResize Image");
                        bimage = MM.resizeImage(myNewPNGFile, 100, 80);
                        break;
                  case 3:
                        fileName
                                = (fileName.substring(fileName.indexOf("png") + 3, fileName.length())
                                + " copy.png").trim();
                        System.out.println("\tfileName: " + fileName);
            }

            if (n != 3) {
                  try {
                        fileName
                                = (fileName.substring(fileName.indexOf("png") + 3, fileName.length())
                                + " copy.png").trim();
                        
                        b = ImageIO.write(bimage, "PNG",
                                new File("C:\\C0F\\Image\\X Icons\\Not Mine\\"
                                        + fileName));

                  } catch (IOException ex) {
                        Logger.getLogger(ImageFileOption.class.getName()).log(Level.SEVERE, null, ex);
                  }

                  //+++++++++++++++++++++++++++++++++
                  if (b == true) {
                        System.out.println("SUCCESS");
                  } else {
                        System.out.println("ERROR");
                  }
            }
      }

      private BufferedImage changeColor(File F) {

            boolean b = false;
            BufferedImage bimage = null;

            try {
                  bimage = ImageIO.read(F);

                  bimage = MM.changeImageColorOfOneColor(F, Color.RED);

            } catch (IOException ex) {
                  ex.printStackTrace();
            }
            return bimage;
      }

      public static void main(String[] args) {
            new ImageFileOption();
      }
}
