/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIManager_LookAndFeel;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Christopher
 */
public class Main_UIManager {

      

      public static void main(String[] args) {
            

            Scanner sc = new Scanner(System.in);
            int n = -1;
            while (n != 0) {
                  System.out.print("Select Choice: ");
                  n = Integer.parseInt(sc.nextLine());
                  
                  switch (n) {
                        //++++++++++++++++++++++++++++++++++++++++
                        case 1:
                              VT.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                              break;
                        //++++++++++++++++++++++++++++++++++++++
                        case 2:
                              VT.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                              break;
                        case 3:
                              VT.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                              break;
                        case 4:
                              VT.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                              break;
                        case 5:
                              VT.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                              break;
                        case 6:
                              LookAndFeelInfo[] list = UIManager.getInstalledLookAndFeels();
                              System.out.println("\tlength: " + list.length);
                              for (int a = 0; a < list.length; a++) {
                                    System.out.println("\tName " + (a + 1) + ": " + list[a].getName());
                                    System.out.println("\t\ttoString " + (a + 1) + ": " + list[a].toString());
                                    //System.out.println("\t\tClass " + (a + 1) + ": " + list[a].getClass());
                              }
                              break;
                  }
            }
            new VT();
      }
}
