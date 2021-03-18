package NB_Window.TEXT;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Christopher
 */
public class TextFieldControl extends JFrame {

      private JPanel p1 = new JPanel();
      private JTextField[] jtfs = new JTextField[]{new JTextField("0"), new JTextField("0"),
            new JTextField("0"), new JTextField("0")};
      
      private JLabel lb_2d = new JLabel(":");

      private static JTextField tf_ex = new JTextField("0");
      public static JTextField getTf_ex(){
            return tf_ex;
      }
      /*public void setTf_ex(String t){
            tf_ex.setText(t);
      }*/
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void frameConfig() {
            setLayout(null);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setAlwaysOnTop(true);
            setSize(800, 500);

            add(p1);
            p1.setLayout(null);
            p1.setBounds(2, 2, 796, 496);
            p1.setBackground(Color.BLACK);
      }

      private void textConfig() {
            Font f = new Font("Dialog", Font.BOLD, 24);
            int b = 2;
            for (int a = 0; a < 4; a++) {
                  p1.add(jtfs[a]);

                  jtfs[a].setBounds(b, 2, 32, 36);

                  jtfs[a].setBackground(new Color(51, 51, 51));
                  jtfs[a].setForeground(Color.WHITE);
                  jtfs[a].setFont(f);
                  jtfs[a].setHorizontalAlignment(JTextField.CENTER);
                  if (a == 1) {
                        b += 48;
                  } else {
                        b += 30;
                  }
                  //jtfs[a].addKeyListener(new KeyControl(a));
                  ((AbstractDocument) jtfs[a].getDocument()).setDocumentFilter(new LimitText(1));
                  
            }
            p1.add(lb_2d);
            int x = jtfs[1].getX() + jtfs[1].getWidth() + 3;
            lb_2d.setBounds(x, jtfs[1].getY() - 2, 20, jtfs[1].getHeight());
            lb_2d.setForeground(Color.WHITE);
            lb_2d.setFont(new Font("Dialog", Font.BOLD, 30));
            lb_2d.setHorizontalTextPosition(SwingConstants.CENTER);
            lb_2d.setVerticalTextPosition(SwingConstants.CENTER);
            //JTF-EXAMPLE+++++++++++++++++++++++++++++++++++
            p1.add(tf_ex);
            tf_ex.setBounds(6, 50, 200, 36);
            tf_ex.setBackground(new Color(51, 51, 51));
            tf_ex.setForeground(Color.WHITE);
            tf_ex.setFont(f);
            ((AbstractDocument)tf_ex.getDocument()).setDocumentFilter(new LimitText());
            tf_ex.addKeyListener(new KeyText());
      }

      public TextFieldControl() {
            frameConfig();
            textConfig();
      }
      public TextFieldControl(String s){
            
      }

      public static void main(String[] args) {
            new TextFieldControl().setVisible(true);

      }

      public class KeyControl implements KeyListener {

            int C = -1;

            public KeyControl(int c) {
                  C = c;
            }

            @Override
            public void keyTyped(KeyEvent arg0) {

            }

            @Override
            public void keyPressed(KeyEvent arg0) {

            }

            @Override
            public void keyReleased(KeyEvent evt) {
                  //((AbstractDocument) jtfs[C].getDocument()).setDocumentFilter(new LimitText(1, evt));
            }

      }
}
