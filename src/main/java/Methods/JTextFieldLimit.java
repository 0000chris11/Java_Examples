package Methods;

import java.awt.FlowLayout;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
      public static void main(String[] args) {
                 //DemoJTextFieldWithLimit ff = new DemoJTextFieldWithLimit();
            }
      private int Limit;

      public JTextFieldLimit(int limit) {
            super();
            this.Limit = limit;

      }

      public void insertStrings(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                  return;
            }

            if ((getLength() + str.length()) <= Limit) {
                  super.insertString(offset, str, attr);
            }
      }

      public class DemoJTextFieldWithLimit extends JApplet {

            
            
            JTextField textfield1;
            JLabel label1;

            public void init() {
                  getContentPane().setLayout(new FlowLayout());
                  //
                  label1 = new JLabel("max 10 chars");
                  textfield1 = new JTextField(15);
                  getContentPane().add(label1);
                  getContentPane().add(textfield1);
                  textfield1.setDocument(new JTextFieldLimit(10));
            }

      }

}
