/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.look;

import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import basic_reusable_classes.swing.VT;

/**
 *
 * @author C0FII
 */
public class UIManagerEx {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            VT vt = new VT();

            int n = -1;
            while (n != 0) {
                  System.out.print("Select Choice: ");
                  n = Integer.parseInt(sc.nextLine());

                  switch (n) {
                        // ++++++++++++++++++++++++++++++++++++++++
                        case 1:
                              vt.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                              break;
                        // ++++++++++++++++++++++++++++++++++++++
                        case 2:
                              vt.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                              break;
                        case 3:
                              vt.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                              break;
                        case 4:
                              vt.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                              break;
                        case 5:
                              vt.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                              break;
                        case 6:
                              LookAndFeelInfo[] list = UIManager.getInstalledLookAndFeels();
                              System.out.println("\tlength: " + list.length);
                              for (int a = 0; a < list.length; a++) {
                                    System.out.println("\tName " + (a + 1) + ": " + list[a].getName());
                                    System.out.println("\t\ttoString " + (a + 1) + ": " + list[a].toString());
                                    // System.out.println("\t\tClass " + (a + 1) + ": " + list[a].getClass());
                              }
                              break;
                        default:
                              break;
                  }
            }
            new VT();

            sc.close();
      }
}
