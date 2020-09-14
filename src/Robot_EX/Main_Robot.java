/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Robot_EX;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
/**
         *
         * @author Christopher
         */
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main_Robot {

      public static void main(String[] args) {
            try {
                  BufferedImage bi = new Robot().createScreenCapture(
                          new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                  
                  ImageIO.write(bi, "png", new File("C:\\C0F\\ScreenShot.png"));
            } catch (AWTException | IOException ex) {
                  ex.printStackTrace();
            }
      }
}
