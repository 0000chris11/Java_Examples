/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.cofii2.components.swing.CheckBoxMenuItemCustom;
import com.cofii2.components.swing.MenuBarCustom;
import com.cofii2.components.swing.MenuCustom;
import com.cofii2.components.swing.MenuItemCustom;
import com.cofii2.methods.MComp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author C0FII
 */
public class MenuBarLook {

      private static final Color bgColor = Color.BLACK;
      private static final Color fgColor = Color.WHITE;
      
      private JFrame JF = new JFrame();

      
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private JMenuBar MB = new MenuBarCustom();
      
      private JMenu menu1 = new MenuCustom("Menu 1");
      private JMenuItem mi_11 = new MenuItemCustom("menu item 1");
      private JCheckBoxMenuItem mi_12 = new CheckBoxMenuItemCustom("menu item 2");

      private JMenu menu2 = new MenuCustom("Menu 2");
      private JMenuItem mi_21 = new MenuItemCustom("menu item 1");
      private JCheckBoxMenuItem mi_22 = new CheckBoxMenuItemCustom("menu item 2");
      private JMenu mi_23 = new MenuCustom("menu item 3");

      private JMenu menu3 = new MenuCustom("Menu 3");
      private JMenuItem mi_31 = new MenuItemCustom("menu item 1");
      private JCheckBoxMenuItem mi_32 = new CheckBoxMenuItemCustom("menu item 2");
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private JMenuBar MBN = new MenuBarCustom();
      
      private JMenu menuN1 = new MenuCustom("Menu 1");
      private JMenuItem miN_11 = new MenuItemCustom("menu item 1");
      private JCheckBoxMenuItem miN_12 = new CheckBoxMenuItemCustom("menu item 2");

      private JMenu menuN2 = new MenuCustom("Menu 2");
      private JMenuItem miN_21 = new MenuItemCustom("menu item 1");
      private JCheckBoxMenuItem miN_22 = new CheckBoxMenuItemCustom("menu item 2");
      private JMenu miN_23 = new MenuCustom("menu item 3");

      private JMenu menuN3 = new MenuCustom("Menu 3");
      private JMenuItem miN_31 = new MenuItemCustom("menu item 1");
      private JCheckBoxMenuItem miN_32 = new CheckBoxMenuItemCustom("menu item 2");
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

      private JButton btn_change = new JButton("Change Size");

      private MenuBarLook() {

            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setLayout(new BorderLayout());

            JF.getContentPane().add(MB, BorderLayout.NORTH);
            JF.getContentPane().add(MBN, BorderLayout.SOUTH);
            
            MB.setPreferredSize(new Dimension(Short.MAX_VALUE, 30));
            MB.setMaximumSize(new Dimension(Short.MAX_VALUE, 30));
            
            MBN.setPreferredSize(new Dimension(Short.MAX_VALUE, 30));
            MBN.setMaximumSize(new Dimension(Short.MAX_VALUE, 30));

            MB.add(menu1);
            menu1.add(mi_11);
            menu1.add(mi_12);
            MB.add(menu2);
            menu2.add(mi_21);
            menu2.add(mi_22);
            menu2.add(mi_23);
            //mi_23.GET
            MB.add(menu3);
            menu3.add(mi_31);
            menu3.add(mi_32);
            //++++++++++++++++++++++++++++++++++
            MBN.add(menuN1);
            menuN1.add(miN_11);
            menuN1.add(miN_12);
            MBN.add(menuN2);
            menuN2.add(miN_21);
            menuN2.add(miN_22);
            menuN2.add(miN_23);
            //mi_23.GET
            MBN.add(menuN3);
            menuN3.add(miN_31);
            menuN3.add(miN_32);
            //+++++++++++++++++++++++++++++++++
            MBN.setBackground(bgColor);
            menuN1.setBackground(bgColor);
            menuN2.setBackground(bgColor);
            menuN3.setBackground(bgColor);
            miN_11.setBackground(bgColor);
            miN_12.setBackground(bgColor);
            
            miN_21.setBackground(bgColor);
            miN_22.setBackground(bgColor);
            miN_23.setBackground(bgColor);
            
            miN_31.setBackground(bgColor);
            miN_32.setBackground(bgColor);

            btn_change.setMaximumSize(new Dimension(180, 28));
            btn_change.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {

                  }

            });

      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {

                        MenuBarLook tt = new MenuBarLook();
                        tt.JF.setSize(new Dimension(300, 200));
                        MComp.setFrameToCenterOfScreen(tt.JF);
                        tt.JF.setVisible(true);
                  }

            });
      }
}
