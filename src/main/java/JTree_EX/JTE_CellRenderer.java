/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTree_EX;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import amethods.MM;

/**
 *
 * @author Christopher
 */
public class JTE_CellRenderer extends DefaultTreeCellRenderer {

      final File heart = new File("C:\\C0F\\Image\\Z Icons\\Not Mine\\like.png");
      final File note = new File("C:\\C0F\\Image\\Z Icons\\Not Mine\\musicNote.png");
      final File folder = new File("C:\\C0F\\Image\\Z Icons\\Not Mine\\folder-blue-512.png");

      @Override
      public Component getTreeCellRendererComponent(JTree tree, Object value,
              boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            //System.out.println("node.getRoot().getChildAt(0): " + node.getRoot().getChildAt(0));
            
            if (node.isLeaf()) {
                  if (node.getParent().equals(node.getRoot().getChildAt(1))) {
                        //System.out.println(node + " is a female");
                        this.setLeafIcon(new ImageIcon(MM.resizeImage(heart, 30, 20)));
                        
                  } else if (node.getParent().equals(node.getRoot().getChildAt(0))) {
                        System.out.println(node  + " is a male");
                        this.setLeafIcon(new ImageIcon(MM.resizeImage(note, 30, 20)));
                  }
            }
            //+++++++++++++++++++++++++++++++++++++++++++
            super.getTreeCellRendererComponent(
                    tree, value, sel,
                    expanded, leaf, row,
                    hasFocus);
            //+++++++++++++++++++++++++++++++++++++++++++
            if(node.getChildCount() > 0){
                  //System.out.println("\nNON-LEAF");
                  this.setIcon(new ImageIcon(MM.resizeImage(folder, 30, 20)));
            }
            //System.out.println("sel: " + sel);
            //System.out.println("expanded: " + expanded);
            //System.out.println("leaf: " + leaf);
            //System.out.println("row: " + row);
            //System.out.println("hasFocus: " + hasFocus);
            //if (sel == false) {
            //     this.setOpaque(true);
            //} 
            //this.setForeground(Color.WHITE);
            return this;
      }

      public JTE_CellRenderer() {
            //ImageIcon icon = new ImageIcon("C:\\C0F\\Image\\X Icons\\+ small.png");
            //this.setLeafIcon(icon);
            this.setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));
            this.setBackgroundSelectionColor(Color.CYAN);
            this.setTextNonSelectionColor(Color.WHITE);
            this.setTextSelectionColor(Color.BLACK);
      }
}
