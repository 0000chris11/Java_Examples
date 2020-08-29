/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTree_EX;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Christopher
 */
public class JTE_CellRenderer extends DefaultTreeCellRenderer{
      
      @Override
      public Component getTreeCellRendererComponent(JTree tree, Object value, 
              boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus){
            
            super.getTreeCellRendererComponent(
                        tree, value, sel,
                        expanded, leaf, row,
                        hasFocus);
            
            this.setOpaque(true);
            this.setForeground(Color.WHITE);
            
            return this;
      }
      
      public JTE_CellRenderer(){
            ImageIcon icon = new ImageIcon("C:\\C0F\\Image\\X Icons\\+ small.png");
            this.setLeafIcon(icon);
            
      }
}
