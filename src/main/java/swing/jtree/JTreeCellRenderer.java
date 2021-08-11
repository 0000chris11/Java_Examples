/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.jtree;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.cofii2.methods.MImage;

//import amethods.MM;

/**
 *
 * @author C0FII
 */
public class JTreeCellRenderer extends DefaultTreeCellRenderer {

      // static final String HEATH_PATH = "C:\\C0F\\Image\\Z Icons\\Not
      // Mine\\like.png";
      final File heart = new File(JTreeCellRenderer.class.getResource("/swing/jtree/like.png").toExternalForm());
      final File note = new File(JTreeCellRenderer.class.getResource("/swing/jtree/musicNote.png").toExternalForm());
      final File folder = new File(JTreeCellRenderer.class.getResource("/swing/jtree/folder-blue-512.png").toExternalForm());

      @Override
      public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                  boolean leaf, int row, boolean hasFocus) {

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            // System.out.println("node.getRoot().getChildAt(0): " +
            // node.getRoot().getChildAt(0));

            if (node.isLeaf()) {
                  if (node.getParent().equals(node.getRoot().getChildAt(1))) {
                        // System.out.println(node + " is a female");
                        //this.setLeafIcon(new ImageIcon(MImage.resizeIcon(heart.toString(), 30, 20)));

                  } else if (node.getParent().equals(node.getRoot().getChildAt(0))) {
                        System.out.println(node + " is a male");
                        //this.setLeafIcon(new ImageIcon(MM.resizeImage(note, 30, 20)));
                  }
            }
            // +++++++++++++++++++++++++++++++++++++++++++
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            // +++++++++++++++++++++++++++++++++++++++++++
            if (node.getChildCount() > 0) {
                  // System.out.println("\nNON-LEAF");
                  //this.setIcon(new ImageIcon(MM.resizeImage(folder, 30, 20)));
            }
            // System.out.println("sel: " + sel);
            // System.out.println("expanded: " + expanded);
            // System.out.println("leaf: " + leaf);
            // System.out.println("row: " + row);
            // System.out.println("hasFocus: " + hasFocus);
            // if (sel == false) {
            // this.setOpaque(true);
            // }
            // this.setForeground(Color.WHITE);
            return this;
      }

      public JTreeCellRenderer() {
            // ImageIcon icon = new ImageIcon("C:\\C0F\\Image\\X Icons\\+ small.png");
            // this.setLeafIcon(icon);
            this.setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));
            this.setBackgroundSelectionColor(Color.CYAN);
            this.setTextNonSelectionColor(Color.WHITE);
            this.setTextSelectionColor(Color.BLACK);
      }
}
