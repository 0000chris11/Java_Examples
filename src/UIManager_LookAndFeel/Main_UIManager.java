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
            new VT();

            Scanner sc = new Scanner(System.in);

            while (true) {
                  System.out.print("Select Choice: ");
                  int n = Integer.parseInt(sc.nextLine());

                  switch (n) {
                        //++++++++++++++++++++++++++++++++++++++++
                        case 1:
                              System.out.println("'\nsetLookAndFeel - > getSystemLookAndFeelClassName");
                              try {
                                    UIManager.setLookAndFeel(
                                            UIManager.getSystemLookAndFeelClassName());

                                    System.out.println("\tNative look: "
                                            + UIManager.getSystemLookAndFeelClassName().toString());
                              } catch (ClassNotFoundException | InstantiationException
                                      | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                                    ex.printStackTrace();
                              }
                              break;
                        //++++++++++++++++++++++++++++++++++++++
                        case 2:
                              LookAndFeelInfo[] list = UIManager.getInstalledLookAndFeels();
                              System.out.println("\tlength: " + list.length);
                              for (int a = 0; a < list.length; a++) {
                                    System.out.println("\tName " + (a + 1) + ": " + list[a].getName());
                                    System.out.println("\t\ttoString " + (a + 1) + ": " + list[a].toString());
                                    //System.out.println("\t\tClass " + (a + 1) + ": " + list[a].getClass());
                              }
                  }
            }

      }
}
