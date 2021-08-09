/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * @author C0FII
 */
class ScreenShot {
      
      ScreenShot(String path){
            try {
                  BufferedImage bi = new Robot().createScreenCapture(
                          new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                  
                  ImageIO.write(bi, "png", new File(path));
            } catch (AWTException | IOException ex) {
                  ex.printStackTrace();
            }
      }
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            String path = sc.nextLine();
            new ScreenShot(path);

            sc.close();
      }
}
