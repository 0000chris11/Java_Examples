/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.cofii2.components.swing.Table;
import com.cofii2.methods.MComp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author C0FII
 */
public class TableTest {

      private JFrame JF = new JFrame();
      private JTable JT = new Table();
      private JScrollPane sc_JT = new JScrollPane(JT);

      private int Count = 0;
      private Object[] columns = {"id", "Name", "JPName"};
      private Object[][] data = {{"1", "First", "Ichi"}, {"2", "Second", "Ni"}, {"3", "Third", "San"}};
      private DefaultTableModel model = new DefaultTableModel(data, columns);

      private JPanel JPB = new JPanel();
      private JButton btn_add = new JButton("add");
      private JButton btn_remove = new JButton("remove");
      private JButton btn_select = new JButton("select");
      private JButton btn_info = new JButton("info");

      private TableTest() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.getContentPane().setLayout(new BorderLayout());

            JF.getContentPane().add(sc_JT, BorderLayout.CENTER);
            JF.getContentPane().add(JPB, BorderLayout.SOUTH);

            tableConfig();
            panelConfig();
      }

      private void tableConfig() {

            JT.setModel(model);

            MComp.setCustomTableCellRenderer(JT);
            MComp.setCustomTableCellEditor(JT);
      }

      private void panelConfig() {
            JPB.setBackground(Color.BLACK);
            JPB.setMinimumSize(new Dimension(50, 28));
            JPB.setMaximumSize(new Dimension(Short.MAX_VALUE, 28));
            JPB.setLayout(new BoxLayout(JPB, BoxLayout.X_AXIS));

            JPB.add(btn_remove, 0);
            JPB.add(btn_add, 1);
            JPB.add(Box.createHorizontalGlue(), 2);
            JPB.add(btn_select, 3);
            JPB.add(btn_info, 4);

            btn_remove.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        model.removeRow(model.getRowCount() - 1);
                  }

            });
            
            btn_add.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        Count++;
                        Object[] row = {"N" + Count, "New " + Count, "???? " + Count};
                        model.addRow(row);
                  }
                  
            });
            
            btn_select.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        JT.setRowSelectionInterval(1, 1);
                  }
                  
            });
            
            btn_info.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        MComp.printTableInfo(JT);
                  }
                  
            });
      }

      private void start() {

      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        TableTest tt = new TableTest();
                        tt.JF.setSize(new Dimension(300, 200));
                        MComp.setFrameToCenterOfScreen(tt.JF);
                        tt.JF.setVisible(true);
                  }

            });
      }
}
