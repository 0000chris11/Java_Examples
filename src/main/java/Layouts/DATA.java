/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author C0FII
 */
public class DATA {

      private static DATA instance;

      JLabel[] lbs = new JLabel[10];
      JTextField[] tfs = new JTextField[10];
      JList[] lsts = new JList[10];
      JComboBox[] cbs = new JComboBox[10];
      JButton[] btns = new JButton[10];

      public static DATA getInstance() {
            if (instance == null) {
                  return new DATA();
            } else {
                  return instance;
            }
      }

      private DATA() {

      }

}
