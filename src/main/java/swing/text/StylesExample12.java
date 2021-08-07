package swing.text;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class StylesExample12 {

      public static void main(String[] args) {
            JFrame f = new JFrame("Styles Example 1");

            // Create the StyleContext, the document and the pane
            StyleContext sc = new StyleContext();
            final DefaultStyledDocument doc = new DefaultStyledDocument(sc);
            JTextPane pane = new JTextPane(doc);

            // Create and add the style
            final Style heading2Style = sc.addStyle("Heading2", null);
            heading2Style.addAttribute(StyleConstants.Foreground, Color.red);
            //heading2Style.addAttribute(StyleConstants.FontSize, new Integer(16));
            heading2Style.addAttribute(StyleConstants.FontSize, 16);
            heading2Style.addAttribute(StyleConstants.FontFamily, "serif");
            heading2Style.addAttribute(StyleConstants.Bold, true);

            try {
                  SwingUtilities.invokeAndWait(() -> {
                        try {
                              // Add the text to the document
                              doc.insertString(0, TEXT, null);

                              // Finally, apply the style to the heading
                              doc.setParagraphAttributes(0, 1, heading2Style, false);
                        } catch (BadLocationException e) {
                              e.printStackTrace();
                        }
                  });
            } catch (Exception e) {
                  System.out.println("Exception when constructing document: " + e);
                  System.exit(1);
                  Thread.currentThread().interrupt();
            }
            f.getContentPane().add(new JScrollPane(pane));
            f.setSize(400, 300);
            f.setVisible(true);
      }
      private static final String TEXT = "Attributes, Styles and Style Contexts\n"
            + "The simple PlainDocument class that you saw in the previous "
            + "chapter is only capable of holding text. The more complex text "
            + "components use a more sophisticated model that implements the "
            + "StyledDocument interface. StyledDocument is a sub-interface of "
            + "Document that contains methods for manipulating attributes that "
            + "control the way in which the text in the document is displayed. "
            + "The Swing text package contains a concrete implementation of "
            + "StyledDocument called DefaultStyledDocument that is used as the "
            + "default model for JTextPane and is also the base class from which "
            + "more specific models, such as the HTMLDocument class that handles "
            + "input in HTML format, can be created. In order to make use of "
            + "DefaultStyledDocument and JTextPane, you need to understand how "
            + "Swing represents and uses attributes.\n";

}
