/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.document_d;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author C0FII
 */
public class DocumentFilterImpl extends DocumentFilter {

      @Override
      public void insertString(FilterBypass fb, int offset, String string,
              AttributeSet attr) throws BadLocationException {
            System.out.println("insertString");
            Document doc = fb.getDocument();
            StringBuilder sb = new StringBuilder();
            sb.append(doc.getText(0, doc.getLength()));
            sb.insert(offset, string);

            if (test(sb.toString())) {
                  super.insertString(fb, offset, string, attr);
            } else {
                  // warn the user and don't allow the insert
            }
      }

      @Override
      public void replace(FilterBypass fb, int offset, int length, String text,
              AttributeSet attrs) throws BadLocationException {
            System.out.println("replace");
            Document doc = fb.getDocument();
            StringBuilder sb = new StringBuilder();
            sb.append(doc.getText(0, doc.getLength()));
            sb.replace(offset, offset + length, text);

            if (test(sb.toString())) {
                  super.replace(fb, offset, length, text, attrs);
            } else {
                  // warn the user and don't allow the insert
            }

      }

      @Override
      public void remove(FilterBypass fb, int offset, int length)
              throws BadLocationException {

            Document doc = fb.getDocument();
            StringBuilder sb = new StringBuilder();
            String text = doc.getText(0, doc.getLength());

            sb.append(text);
            
            if (offset != 0) {
                  sb.delete(offset, offset + length);
            }

            if (test(sb.toString())) {
                  super.remove(fb, offset, length);
            }
      }

      private boolean test(String text) {
            try {
                  Integer.parseInt(text);
                  return true;
            } catch (NumberFormatException e) {
                  return false;
            }
      }
}
