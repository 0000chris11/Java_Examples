/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTree_EX;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Christopher
 */
public class JTE_SL implements TreeSelectionListener {

      @Override
      public void valueChanged(TreeSelectionEvent e) {
            //System.out.println("VALUE CHANGED ");
            //System.out.println("Path: " + e.getPath());
            //System.out.println("Path Component 0: " 
            //       + e.getPath().getPathComponent(0));
            if (e.getPath().getPathComponent(0).toString().equals("Best Characters")) {
                  //System.out.println("\tINSIDE ROOT");
                  //System.out.println("\tgetLastSelectedPathComponent: "
                  //+ JTE.getLastSelectedPathComponent());
                  //+++++++++++++++++++++++++++++++++++++++++++++
                  DefaultMutableTreeNode node
                          = (DefaultMutableTreeNode) Main.JTE.getLastSelectedPathComponent();

                  if (node != null) {
                        if (node.toString().equals("Pinkie Pie")) {
                              //System.out.println("\t\tPinkePie <- Selected");
                        }

                        if (node.isLeaf()) {
                              //System.out.println("\t\t\tTYPE: LEAF");
                        } else {
                              //System.out.println("\t\t\tTYPE: NOT LEAF");
                        }
                  } else {
                        //System.out.println("\t\tNOTHING IS Selected");
                  }

            }
            //+++++++++++++++++++++++++++++++++++++++
            /*
            new Thread() {
                  public void run() {
                        try {
                              Thread.sleep(1000);
                              Main.JTE.getSelectionModel().clearSelection();
                        } catch (InterruptedException ex) {

                        }
                  }
            }.start();
            */
      }

}
