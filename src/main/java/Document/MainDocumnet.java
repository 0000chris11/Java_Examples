/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Document;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

/**
 *
 * @author C0FII
 */
public class MainDocumnet {

      public static void main(String[] args) {
            JTextField textField = new JTextField(10);

            JPanel panel = new JPanel();
            panel.add(textField);

            PlainDocument doc = (PlainDocument) textField.getDocument();
            doc.setDocumentFilter(new MyIntFilter());

            JOptionPane.showMessageDialog(null, panel);
      }
}
